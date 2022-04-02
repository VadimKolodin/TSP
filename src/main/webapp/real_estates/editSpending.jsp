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
<form action = "treatment" method="post" enctype="multipart/form-data" class="enter reg_button" >
    <b> Название: </b><br>
    <input type="text" name="name" ><br>
    <b> Сумма: </b> <br>
    <input type="text" name="value" ><br>
    <b> Описание: </b> <br>
    <input type="text" name="description"><br>
    <label for="date">Дата</label><br>
    <input type="date" name="date" id="date">
    <p>
        <button type = "submit" name="submit3" formaction="MyRealEstate" >ОК</button>
    </p>
</form>
</body>
</html>
