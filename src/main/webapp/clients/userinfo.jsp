<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 21.03.2022
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Информация о пользователе</title>
    <style><%@include file="/style.css"%></style>
</head>
<body>
    <jsp:include page="/menu/menu.jsp"></jsp:include>
    <button type="button"  class="user_info_but">
        <a href="changeUserInfo">Редактировать</a></button>
    <p class="user_info">
        <label for="name">ФИО</label><br>
        <input type="text" id="name" name="FIO" disabled="disabled" value="Иванов Иван Иванович"><br>
        <label for="description">О себе</label><br>
        <input type="text" id="description" name="depiction" disabled="disabled" height="200" value="О себе..."><br>
        <a href="estates">Недвижимость пользователя</a>
    </p>

</body>
</html>
