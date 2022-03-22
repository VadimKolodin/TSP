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
    <title>Обработка</title>
</head>
<body>
<%
    String login=request.getParameter("LOGIN");
    String FIO=request.getParameter("FIO");
    String password1=request.getParameter("PASSWORD1");
    //String password2=request.getParameter("PASSWORD2");
    //if(password1!=password2)out.print("Error");
    User user=new User(null,login,(int)password1.hashCode());
    LocalDate regd=LocalDate.now();
    UserInfo userinfo=new UserInfo(null,FIO,regd,null);
    UserDao dao=new UserDao();
    if(!dao.createUserInfo(userinfo)||!dao.create(user)) {
        //новая страничка на которой Повторить и переход обратно либо сразу обратно
    }
    else{
        response.sendRedirect(request.getContextPath() + "/userInfo");
    }
%>
</body>
</html>
