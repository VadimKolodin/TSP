<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 24.03.2022
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Изменение недвижимости</title>
</head>
<body>
    <form action="treatment"  method="post" enctype="multipart/form-data" class="addEstate">
        <b>Название:</b><Br>
        <input type="text" name="typeEstate"><Br>
        <b>Адрес:</b><Br>
        <input type="text" name="addressEstate"><Br><Br>
        <input  type="file" name="file" accept="image/jpeg,image/png">
        <Br>
        <p class="add_button2">
            <button type="submit" name="but_add_estate">ОК </button>
        </p>
</form>
</body>
</html>
