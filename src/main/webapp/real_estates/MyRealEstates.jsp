<%@ page import="models.dto.User" %>
<%@ page import="control.Controller" %>
<%@ page import="models.dto.UserInfo" %>
<%@ page import="models.dto.RealEstate" %><%--
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
    <p align="right" class = "add_button">
        <button type="submit" name="addEst1">Добавить</button>
    </p>
</form>
<%
    User user = Controller.getInstance().getUser(Integer.parseInt(pageContext.getRequest().getParameter("usid")));
    UserInfo info= Controller.getInstance().getUserInfo(user.getUid());

%>
<ul class="list_estates">
    <% for(RealEstate estates:Controller.getInstance().getAllEstateUser(user.getUid())){%>
    <li>
        <a href="estate?eid=<%=estates.getEid()%>"><img src="<%=Controller.getInstance().getEstateImage(estates.getEid())%>" align="middle" width="250" height="250"></a>
        <p>
            <a href="estate?eid=<%=estates.getEid()%>"><%=estates.getType()%></a> <Br>
            <%=estates.getAddress()%>
        </p><Br>
            <div align="right">
                <button type="submit" value="<%=estates.getEid()%>" onclick="deleteEstate(this)">Удалить</button>
            </div>
    </li>
    <%}%>
</ul>
<script>
    function deleteEstate(element){
        element.parentNode.parentNode.hidden=true;
    }
</script>
</body>
</html>
