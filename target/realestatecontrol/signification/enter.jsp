<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 20.03.2022
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title> Вход </title>
</head>
<body>
<form action = "URL" >
    <b> Логин: </b><Br>
    <input type="text" name="LOGIN" size = "20"><Br>
    <b> Пароль: </b> <Br>
    <input type = "password" name= "PASSWORD" size = "10">
    <input type = "submit"  value = "ОК"> <Br>
    <!--Проверка на корректность-->
    <a href = "registration"> Зарегистрироваться </a>
</form>

</body>
</html>