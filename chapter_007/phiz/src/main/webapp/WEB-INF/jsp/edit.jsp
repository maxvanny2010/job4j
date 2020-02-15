<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>EDIT</title>
</head>
<body>
<jsp:useBean id="fall" scope="request" type="java.lang.String"/>
<hr>
<div class="table-top">
    <div class="table-top-row">
        <div class="table-top-cell">
            <c:if test="${fall eq 'ok'}">
                <img src="img/obama.png" alt="arms">
                <img src="img/arms.png" alt="arms">
            </c:if>
            <c:if test="${fall ne 'ok'}">
                <img src="img/arms.png" alt="arms">
            </c:if>
        </div>
        <div class="table-top-cell-center">
            <p><b>TOP SECRET.</b></p>
            <p>Headquarters the Microsoft.</p>
        </div>
    </div>
</div>
<hr>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p class="font600">Редактирование данных программиста перешедшего на сторону Java.</p>
                <c:if test="${fall eq 'ok'}">
                    <div class="center">
                        <p class="font600" style="color: crimson">Вы не прошли проверку безопасности.</p>
                    </div>
                    <div class="center">
                        <p class="font600" style="color: crimson">Заполните все поля.</p>
                    </div>
                </c:if>
            </div>
            <div class="right">
                <p><a class="link" href="<c:url value="/index"/>">Назад к списку</a></p>
            </div>
        </div>
    </div>
    <div class="table-top">
        <div class="table-top-row">
            <form method="POST" action="<c:url value="/edit"/>">
                <jsp:useBean id="user" scope="request" type="web.model.User"/>
                <input type="hidden" name="id" value="${user.id}"/>
                <div class="input-container">
                    <i class="icon"><img alt="name" src="<c:url value="img/name.png"/>"></i>
                    <label>
                        <input class="input-field" name="name" placeholder="Name"
                               type="text" value="${user.name}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"><img alt="login" src="<c:url value="img/login.png"/>"></i>
                    <label>
                        <input class="input-field" name="login" placeholder="Login"
                               type="text" value="${user.login}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"><img alt="email" src="<c:url value="img/email.png"/>"></i>
                    <label>
                        <input class="input-field" name="email" placeholder="Email"
                               type="text" value="${user.email}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <button class="btn" type="submit"><b>Сохранить</b></button>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
