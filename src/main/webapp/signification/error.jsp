<%@ page import="dto.User" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="dto.UserInfo" %>
<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 21.03.2022
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>404</title>
</head>
<body>
    <h1  class="error">Страница не найдена</h1>
    <p class="error2">
        Ошибка 404. Данная страница не существует, либо была удалена.
    </p>
    <p align="center">
        <img src="cat404.jpg"  width="400" height="450" >
    </p>
    <p class="error3" align="center">
        <a href="index.jsp">Вернуться на главную страницу</a>
    </p>
</body>
</html>
