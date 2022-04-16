<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 23.03.2022
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Моя недвижимость</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<h1 align="center" class="color_header_1">
    Моя недвижимость
</h1>
<form action="NewEstate" method="post" enctype="multipart/form-data">
    <p class = "add_button">
        <button type="submit" name="addEst1">Добавить</button>
    </p>
</form>
<ul class="list_estates">
    <li>
        <a href="estate"><img src="real_estates/images/default.jpg" align="middle" width="250" height="250"></a>
        <p>
            <a href="estate">Дом</a> <Br>
            ул. Петра Первого д. 65
        </p><Br>
        <form action = "error" method="get">
            <div align="right">
                <button type="submit" name="deleteEst">Удалить</button>
            </div>
        </form>
    </li>
    <li>
        <a href="estate"><img src="real_estates/images/apartment1.jpg" align="middle" width="250" height="250"></a>
        <p>
            <a href="estate">Квартира</a> <Br>
            ул. Съездовская д.8 кв.103
        </p><Br>
        <form action = "error" method="get">
            <div align="right">
                <button>Удалить</button>
            </div>
        </form>

    </li>
    <li>
        <a href="estate"><img src="real_estates/images/house1.jpg" align="middle" width="250" height="250"></a>
        <p>
            <a href="estate">Дом</a> <Br>
            пос. Курганский ул. Пушкина д.31
        </p><Br>
        <form action = "treatment" method="get">
            <div align="right">
                <button>Удалить</button>
            </div>
        </form>
    </li>
</ul>
</body>
</html>
