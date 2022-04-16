<%@ page import="java.time.LocalDate" %>
<%@ page import="dto.UserInfo" %>
<%@ page import="dao.UserDao" %>
<%@ page import="dto.User" %><%--
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
<form action = "error" method="post" enctype="multipart/form-data" class="enter reg_button" >
    <label for = "login">Логин</label><br>
    <input type="text" id="login" name="Login"><br>
    <label for = "password1">Пароль</label><br>
    <input type="password" id="password1" name="Password1"><br>
    <label for = "password2">Повторите пароль</label><br>
    <input type="password" id="password2" name="Password2"><br>
    <label for = "name">ФИО</label><br>
    <input type="text" name="FIO" id="name"><br>
    <p>
        <button type = "submit" name="submit2" formaction="enter" >ОК</button>
    </p>
</form>

</body>
</html>