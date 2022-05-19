<%@ page import="models.dto.User" %>
<%@ page import="models.dto.RealEstate" %>
<%@ page import="control.Controller" %><%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 18.05.2022
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Изменить информацию о недвижимости</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<%User user=(User)request.getSession().getAttribute("user");
    RealEstate estate= Controller.getInstance().getRealEstate(user.getUid(),Integer.parseInt(request.getParameter("eid")));
%>
<form action="ChangeEstateServlet?eid=<%=estate.getEid()%>"  method="post" class="user_info">
    <label for="type">Тип:</label><br>
    <input type="text" id="type" name="typeEstate" value="<%=estate.getType()%>"><br>
    <label for="address">Адрес:</label><br>
    <input type="text" id="address" name="addressEstate" value="<%=estate.getAddress()%>"><br>
    <label for="status">Статус: </label><br>
    <%if (estate.getStatus().isSold()){%>
    <input type="text" id="status" name="status" value="продан"><br>
    <%} else {%>
    <input type="text" id="status" name="status" value="в собственности"><br>
    <%}%>
    <label for="purchase">Дополнительная информация:<br>Куплена:</label><br>
    <input type="date" name="date_purchase" value="<%=estate.getStatus().getPurchaseDate()%>"><br>
    <input type="text" id="purchase" name="price_purchase" value="<%=estate.getStatus().getPurchasePrice()%>"><br>
    <label for="sold">Продана:</label><br>
    <%if(estate.getStatus().isSold()){%>
    <input type="date" name="date_sold" value="<%=estate.getStatus().getSoldDate()%>"><br>
    <input type="text" id="sold" name="price_sold" value="<%=estate.getStatus().getSoldPrice()%>"><br>
    <%}else{%>
    <input type="date" name="date_sold" ><br>
    <input type="text" id="sold" name="buy" placeholder="Сумма покупки"><br>
    <%}%><br>
    <input  type="file" name="file" accept="image/jpeg,image/png"><br>
    <p class="add_button2">
        <button type="submit" name="but_add_estate">ОК </button>
    </p>
</form>
</body>
</html>
