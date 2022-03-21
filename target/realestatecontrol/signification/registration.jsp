<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 20.03.2022
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title> Регистрация </title>
</head>
<body>
<form action = "URL" >
    <b> Логин: </b><Br>
    <input type="text" name="LOGIN" size = "20"><Br>
    <b> Пароль: </b> <Br>
    <input type = "password" name= "PASSWORD1" size = "10"><Br>
    <b> Повторите пароль: </b> <Br>
    <input type = "password" name= "PASSWORD2" size = "10"><Br>
    <!--ПРОВЕРКА НА КОРРЕКТНОСТЬ ПАРОЛЯ-->
    <b>ФИО: </b><Br>
    <input type = "text" name = "FIO" size = "50"><Br>
    <input type = "submit"  value = "ОК"> <Br>
</form>

</body>
</html>