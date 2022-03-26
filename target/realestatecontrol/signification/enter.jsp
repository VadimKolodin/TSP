<%@ page import="dao.UserDao" %>
<%@ page import="dto.UserInfo" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %><%--
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
<form action = "${pageContext.request.contextPath}/treatment" method="post" enctype="multipart/form-data" class="enter" >

    <b> Логин: </b><Br>
    <input type="text" name="LOGIN" ><Br>
    <b> Пароль: </b> <Br>
    <input type = "password" name= "PASSWORD"  >
    <p class="ent_button enter_and_reg">
        <a  href = "registration"> Зарегистрироваться </a>
        <button type = "submit" name="but_enter" formaction="treatment" >Войти</button>
    </p>
</form>

</body>
</html>