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
    <title>Главная страница</title>
</head>
<body>
<p align="right" class="enter_and_reg">
    <a href = "enter">Вход</a> |
    <a href = "userinfo"><nobr>Моя страница</nobr></a>
</p>
<jsp:include page="menu/menu.jsp"></jsp:include>
    <Br>
    <h1 align="center">Главная страница</h1>
</body>
</html>