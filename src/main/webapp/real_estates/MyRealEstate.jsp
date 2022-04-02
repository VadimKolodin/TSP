<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 24.03.2022
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- Настройка viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="/style.css"%></style>
    <title>Страница Недвижимости</title>
    <!-- Bootstrap CSS (Cloudflare CDN) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.1/css/bootstrap.min.css" integrity="sha512-T584yQ/tdRR5QwOpfvDfVQUidzfgc2339Lc8uBDtcp/wYu80d7jwBgAxbyMh0a9YM9F8N3tdErpFI8iaGx6x5g==" crossorigin="anonymous" referrerpolicy="no-referrer">
    <!-- jQuery (Cloudflare CDN) -->
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- Bootstrap Bundle JS (Cloudflare CDN) -->
    <script defer src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.1/js/bootstrap.min.js" integrity="sha512-UR25UO94eTnCVwjbXozyeVd6ZqpaAE9naiEUBK/A+QDbfSTQFhPGj5lOR6d8tsgbBk84Ggb5A3EkjsOgPRPcKA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<body>
<jsp:include page="/menu/menu.jsp"></jsp:include>
    <p class="enter_and_reg" align="right">
        <a href = "NewEstate">Редактировать</a>
    </p>
    <img src="real_estates/images/default.jpg" align="left" width="240" height="240"></a>
    <p>
        Дом
    </p>
    <p>
        ул. Петра Первого д. 65
    </p>
    <p>
        Статус: в собственности
    </p>
    <Br>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#income">Доходы</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#outcome">Расходы</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade show active" id="income">
            <form action="editSpending">
                <button type="submit" name="addIncome">Добавить</button>
            </form>
            <%for(int i=1; i<6;++i){%>
            <div class="flex-container">
                <div class = "flex-item">
                    <p class="tab-pane-text">Какие-то доходы <%=i%>...</p>
                </div>
                <div class = flex-item>
                    <div class = "flex-container-col">
                        <div class = "flex-item">
                            <form action="ChangeIncome" class="changeBut">
                                <button type="submit" name="changeIncome">Изменить</button>
                            </form>
                        </div>
                        <div class = "flex-item">
                            <form action="DeleteIncome" class="deleteBut">
                                <button type="submit" name="deleteIncome">Удалить</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <%}%>
        </div>
        <div class="tab-pane fade" id="outcome">
            <form action="NewEstate">
                <button type="submit" name="addOutcome">Добавить</button>
            </form>
            <%for(int i=1; i<6;++i){%>
            <div class="flex-container">
                <div class = "flex-item">
                    <p class="tab-pane-text">Какие-то расходы <%=i%>...</p>
                </div>
                <div class = flex-item>
                    <div class = "flex-container-col">
                        <div class = "flex-item">
                            <form action="ChangeOutcome" class="changeBut">
                                <button type="submit" name="changeOutcome">Изменить</button>
                            </form>
                        </div>
                        <div class = "flex-item">
                            <form action="DeleteOutcome" class="deleteBut">
                                <button type="submit" name="deleteOutcome">Удалить</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <%}%>
        </div>
    </div>
</body>
</html>
