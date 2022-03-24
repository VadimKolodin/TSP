<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 23.03.2022
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Меню</title>
</head>
<body>

    <ul class="start_menu">
        <li><a href = "${pageContext.request.contextPath}/"> Главная страница </a></li>
        <li><a href = "${pageContext.request.contextPath}/estates"> Моя недвижимость </a></li>
        <li><a href = "${pageContext.request.contextPath}/statistics"> Статистика </a></li>
        <li><a href = "${pageContext.request.contextPath}/users"> Пользователи </a></li>
    </ul>

    <!-- сделать отступ с ксс-->

</body>
</html>
