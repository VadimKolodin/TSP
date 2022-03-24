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
<form action = "treatment" method="post" enctype="multipart/form-data" class="enter reg_button" >
    <b> Логин: </b><Br>
    <input type="text" name="LOGIN" ><Br>
    <b> Пароль: </b> <Br>
    <input type = "password" name= "PASSWORD1" ><Br>
    <b> Повторите пароль: </b> <Br>
    <input type = "password" name= "PASSWORD2" ><Br>
    <!--ПРОВЕРКА НА КОРРЕКТНОСТЬ ПАРОЛЯ-->
    <b>ФИО: </b><Br>
    <input type = "text" name = "FIO" ><Br>
    <p>
        <button type = "submit" name="submit2" formaction="enter" >ОК</button>
    </p>
</form>

</body>
</html>