<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 02.04.2022
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить доходы/расходы</title>
    <style><%@include file="/style.css"%></style>
</head>
<body>
<form action = "error" method="post" enctype="multipart/form-data" class="user_info spend_button" >
    <label for="type">Название:</label><br>
    <input type="text" id="type" name="name" ><br>
    <label for="summa"> Сумма: </label> <br>
    <input type="text" id="summa" name="value" ><br>
    <label for="desc_come"> Описание: </label> <br>
    <input type="text" id="desc_come"name="description_come"><br>
    <label for="date">Дата</label><br>
    <input type="date" name="date" id="date">
    <p>
        <button type = "submit" name="submit3" formaction="MyRealEstate" >ОК</button>
    </p>
</form>
</body>
</html>
