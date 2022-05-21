<%@ page import="models.dto.RealEstate" %>
<%@ page import="control.Controller" %>
<%@ page import="models.dto.User" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 23.03.2022
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Статистика</title>
    <script src="https://www.google.com/jsapi"></script>
    <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
</head>
<body>
    <jsp:include page="/menu/menu.jsp"></jsp:include>
    <%
    User user = (User)request.getSession().getAttribute("user");
        int selectedEid = 0;
        if (request.getParameter("eid")!=null){
            selectedEid=Integer.parseInt(request.getParameter("eid"));
        }
    %>
    <div class="text2cols-item">
        <select class="choose_estate" id="choose_estate">
            <% if (selectedEid==0){%>
            <option value = "nullptr" disabled selected>Выберите недвижимость</option>
            <%}%>
           <%

               for(RealEstate estate: Controller.getInstance().getAllEstateUser(user.getUid())){
                   %>
                <option value="<%=estate.getEid()%>" <%=(estate.getEid()==selectedEid?"selected":"")%>><%=estate.getAddress()%></option>
                   <%
               }
           %>
        </select>
        <br>
        <p class="result_values">
            <% try {
                HashMap<String, Double> estateTotal = Controller.getInstance().getEstateTotal(user.getUid(), selectedEid);
                %>
            Доходы от недвижимости:<%=estateTotal.get("income")%> рублей<br>
            Расходы от недвижимости:<%=estateTotal.get("outcome")%> рублей<br>
            Итог недвижимости: <%=estateTotal.get("income")-estateTotal.get("outcome")%> рублей<br>
            <%
            } catch (Exception e){
                %>
            Доходы от недвижимости: выберете недвижимость<br>
            Расходы от недвижимости: выберете недвижимость<br>
            Итог недвижимости: выберете недвижимость<br>
            <%
            }
            %>

        </p>
        <div  id="comeMonth_estate" class="bar_graph1"></div>

        <div  id="comeYear_estate" class="bar_graph1"></div>

    </div>
    <div class="text2cols-item">
        <p class="result_values2">
            <%
                HashMap<String, Double> userTotal = Controller.getInstance().getUserTotal(user.getUid());
            %>
            Сумма доходов: <%=userTotal.get("income")%><br>
            Сумма расходов: <%=userTotal.get("outcome")%><br>
            Итог: <%=userTotal.get("income")-userTotal.get("outcome")%><br>
            <br>
            Выберете период:<br>
            От <input type="date" id="user_from" onchange="saveValue(this)"> до <input type="date" id="user_to" onchange="saveValue(this)">
        </p>
        <div  id="comeMonth" class="bar_graph1"></div>
        <div  id="comeYear" class="bar_graph1"></div>
    </div>
<script>
    let select = document.getElementById('choose_estate');
    select.addEventListener('input', function(){
        window.location.replace('/realestatecontrol/statistics?eid='+select.options[select.selectedIndex].value);
    });
    function saveValue(e){
        var id = e.id;  // get the sender's id to save it .
        var val = e.value; // get the value.
        sessionStorage.setItem(id, val);// Every time user writing something, the sessionStorage's value will override .
    }

    //get the saved value function - return the value of "v" from sessionStorage.
    function getSavedValue  (v){
        if (!sessionStorage.getItem(v)) {
            return "";// You can change this to your defualt value.
        }
        return sessionStorage.getItem(v);
    }
    document.getElementById("user_from").value=getSavedValue("user_from");
    document.getElementById("user_to").value=getSavedValue("user_to");
</script>
    <script>
        function getStatUser(from, to, period){
            $.ajax({
                url: 'statistics/getstat',
                method: 'GET',
                data: {
                    from: from,
                    to: to,
                    mode: 'user',
                    period: period
                },
                success: function (response){
                    return JSON.parse(response);
                }
            });
        }

        function getStatEstate(from, to, period, eid){
            $.ajax({
                url: 'statistics/getstat',
                method: 'GET',
                data: {
                    from: from,
                    to: to,
                    eid: eid,
                    mode: 'user',
                    period: period
                },
                success: function (response){
                    return JSON.parse(response);;
                }
            });
        }

    </script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            let from=null;
            let to = null;
            if (document.getElementById("user_from").value===''&&document.getElementById("user_to").value===''){
                to = new Date();
                from = new Date();
                from.setMonth(from.getMonth()-1);
            } else if (document.getElementById("user_from").value===''){
                to = new Date(document.getElementById("user_to").value);
                from = new Date(document.getElementById("user_to").value);
                from.setMonth(from.getMonth()-1);
            } else if (document.getElementById("user_to").value===''){
                from = new Date(document.getElementById("user_from").value);
                to =  new Date(document.getElementById("user_from").value);
                to.setMonth(to.getMonth()+1);
            } else {
                from = new Date(document.getElementById("user_from").value);
                to = new Date(document.getElementById("user_to").value);
            }
            console.log(from);
            console.log(to);/////////////////////////////////////////////////////////////////////////////
            var data = google.visualization.arrayToDataTable([
                ['Дата', 'Доходы','Расходы'],
                ['1.05.2001', 15.0, 0.880],
                ['3', 0, 1.5],
                ['5', 0, 2.350],
                ['7', 0.870, 0.987],
                ['8', 0, 1.27],
                ['10', 15.0, 0.690],
                ['17', 3.65, 8.7],
                ['24', 0, 1.760],
                ['28', 0, 1.540],
                ['30', 0, 4.810],
                ['31', 0, 0.990]
            ]);
            var options = {
                title: 'Итоговые Доходы/Расходы за последний месяц',
                hAxis: {title: 'Апрель'},
                vAxis: {title: 'Тыс. рублей'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('comeMonth'));
            chart.draw(data, options);
        }
    </script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Дата', 'Доходы','Расходы'],
                ['1', 15.0, 0.880],
                ['3', 0, 1.5],
                ['5', 0, 2.350],
                ['7', 0.870, 0.987],
                ['8', 0, 1.27],
                ['10', 15.0, 0.690],
                ['17', 3.65, 8.7],
                ['24', 0, 1.760],
                ['28', 0, 1.540],
                ['30', 0, 4.810],
                ['31', 0, 0.990]
            ]);
            var options = {
                title: 'Доходы/Расходы за последний месяц',
                hAxis: {title: 'Апрель'},
                vAxis: {title: 'Тыс. рублей'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('comeMonth_estate'));
            chart.draw(data, options);
        }
    </script>

    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Месяц', 'Доходы','Расходы'],
                ['май',20.230,25.976],
                ['июнь',19.760,25.092],
                ['июль',21.240,21.845],
                ['август',22.250,21.880],
                ['сентябрь',29.330,22.421],
                ['октябрь',28.270,21.843],
                ['ноябрь',27.230,20.003],
                ['декабрь',23.230,20.243],
                ['январь',20.230,21.843],
                ['февраль', 23.132, 19.345],
                ['март', 31.214, 19.763],
                ['апрель', 34.520, 25.477]
            ]);
            var options = {
                title: 'Итоговые Доходы/Расходы за последний год',
                //hAxis: {title: 'Месяц'},
                vAxis: {title: 'Тыс. рублей'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('comeYear'));
            chart.draw(data, options);
        }
    </script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Месяц', 'Доходы','Расходы'],
                ['май',20.230,25.976],
                ['июнь',19.760,25.092],
                ['июль',21.240,21.845],
                ['август',22.250,21.880],
                ['сентябрь',29.330,22.421],
                ['октябрь',28.270,21.843],
                ['ноябрь',27.230,20.003],
                ['декабрь',23.230,20.243],
                ['январь',20.230,21.843],
                ['февраль', 23.132, 19.345],
                ['март', 31.214, 19.763],
                ['апрель', 34.520, 25.477]
            ]);
            var options = {
                title: 'Доходы/Расходы за последний год',
                //hAxis: {title: 'Месяц'},
                vAxis: {title: 'Тыс. рублей'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('comeYear_estate'));
            chart.draw(data, options);
        }
    </script>
</body>
</html>
