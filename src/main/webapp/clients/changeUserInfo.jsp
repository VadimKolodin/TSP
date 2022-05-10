<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 04.04.2022
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование Пользователя</title>
    <style><%@include file="/style.css"%></style>
</head>
<body>
    <jsp:include page="/menu/menu.jsp"></jsp:include>
    <form action="error" method="post" enctype="multipart/form-data">
        <p class="user_info">
            <label for = "name">ФИО</label><br>
            <input type="text" name="FIO" id="name" value="Иван Иванович"><br>
            <label for = "password1">Пароль</label><br>
            <input type="password" id="password1" name="Password1" ><br>
            <label for = "password2">Повторите пароль</label><br>
            <input type="password" id="password2" name="Password2" ><br>
            <label for="description">О себе</label><br>
            <textarea class="text_area" id="description" name="depiction" placeholder="О себе..."></textarea><br>
        </p>
        <button type="submit" name="EditInfo" class="edit_info_but">Сохранить изменения</button>
    </form>

</body>
</html>
