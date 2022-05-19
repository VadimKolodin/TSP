<%@ page import="models.dto.RealEstate" %>
<%@ page import="control.Controller" %><%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 18.05.2022
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/style.css"%></style>
    <title>Страница Недвижимости</title>
</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
<%
    RealEstate estate = Controller.getInstance().getRealEstate(Integer.parseInt(request.getParameter("usid")), Integer.parseInt(request.getParameter("eid")));
%>
<p class="enter_and_reg" align="right">
    <a href = "NewEstate">Редактировать</a>
</p>
<img src="real_estates/images/default.jpg" align="left" width="240" height="240"></a>
<p><br>
    <%=estate.getType()%>
</p>
<p>
    Адрес: <%=estate.getAddress()%>
</p>
<p>
    Статус:
    <%if (estate.getStatus().isSold()){%>
    продан
    <%} else {%>
    в собственности
    <%}%>
</p>
<p>
    Дополнительная информация:<br>
    Куплена: <%=estate.getStatus().getPurchaseDate()%> за <%=estate.getStatus().getPurchasePrice()%> руб.
    <%
        if (estate.getStatus().isSold()){
    %>
    Продана: <%=estate.getStatus().getSoldDate()%> за <%=estate.getStatus().getSoldPrice()%> руб.
    <%
        }
    %>
</p>
<Br>
</body>
</html>
