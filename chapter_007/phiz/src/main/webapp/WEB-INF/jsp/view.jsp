<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="img/favicon.png" type="image/png">
    <title>VIEW</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>
<section>
    <jsp:useBean id="user" type="web.model.User" scope="request"/>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p class="font600">
                    Данные ${user.name} перешедшего на сторону Java.
                </p>
            </div>
            <div class="right">
                <p>
                    <a class="link" href="<c:url value="/index"/>"> Назад к списку </a>
                </p>
            </div>
            <div class="table-top-row">${user.name}</div>
            <div class="table-top-row">${user.login}</div>
            <div class="table-top-row">${user.email}</div>
            <div class="right">
                <form action="<c:url value="/delete"/>" method="POST">
                    <input name="id" type="hidden" value="${user.id}"/>
                    <input class="del" type="submit" value="delete<c:out value="${user.name}"/>"/>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>

