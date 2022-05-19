<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 24.03.2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Изменение недвижимости</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<form action="AddEstateServlet"  method="post" class="user_info">
        <label for="type">Название:</label><br>
        <input type="text" id="type" name="typeEstate"><br>
        <label for="address">Адрес:</label><br>
        <input type="text" id="address" name="addressEstate"><br><br>
        <input  type="file" name="file" accept="image/jpeg,image/png"><br>
        <p class="add_button2">
            <button type="submit" name="but_add_estate">ОК </button>
        </p>
</form>
</body>
</html>
