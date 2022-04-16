<%--
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
            var chart = new google.visualization.ColumnChart(document.getElementById('comeMonth'));
            chart.draw(data, options);
        }
    </script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Месяц', 'Доходы','Расходы'],
                ['февраль', 23.132, 19.345],
                ['март', 31.214, 19.763],
                ['апрель', 34.520, 25.477]
            ]);
            var options = {
                title: 'Доходы/Расходы за последние три месяца',
                //hAxis: {title: 'Месяц'},
                vAxis: {title: 'Тыс. рублей'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('comeThreeMonths'));
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
            var chart = new google.visualization.ColumnChart(document.getElementById('comeYear'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
    <div  id="comeMonth" class="bar_graph"></div>
    <div  id="comeThreeMonths" class="bar_graph"></div>
    <div  id="comeYear" class="bar_graph"></div>
</body>
</html>
