<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>TOP SECRET</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p class="font600">
                    Список программистов перешедших на сторону Java.
                </p>
            </div>
        </div>
    </div>
    <div class="table-top">
        <div class="table-top-row">
            <jsp:useBean id="hats" scope="request" type="java.util.List"/>
            <c:forEach var="hat" items="${hats}">
                <jsp:useBean id="hat" type="java.lang.String"/>
                <div class="table-top-cell-color">
                    <div class="center"><c:out value="${hat}"/>
                    </div>
                </div>
            </c:forEach>
        </div>
        <jsp:useBean id="store" type="java.util.List" scope="request"/>
        <c:forEach var="user" items="${store}">
            <jsp:useBean id="user" type="web.model.User"/>
            <div class="table-top-row">
                <div class="table-top-cell">
                    <div class="center">
                        <c:out value="${user.id}"/>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <c:out value="${user.createTime}"/>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <a href="<c:url value="/view?id=${user.id}"/>" title="Просмотреть запись">
                            <c:out value="${user.name}"/>
                        </a>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <c:out value="${user.login}"/>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <c:out value=" ${user.email}"/>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <a href="<c:url value="/edit?id=${user.id}"/>" title="Редактировать запись">
                            <img src="img/edit.png" alt="edit">
                        </a>
                    </div>
                </div>
                <div class="table-top-cell">
                    <div class="center">
                        <form action="<c:url value="/delete"/>" method="POST" title="Удалить запись">
                            <input name="id" type="hidden" value="${user.id}"/>
                            <input class="del" type="submit" value="delete">
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="footer">
        <div>
            <a href="<c:url value="/add"/>">
                <img src="img/name.png" alt="add" title="Добавить в список">
            </a>
        </div>
        <div>
            <a href="<c:url value="/clear"/>">
                <img src="img/clear.png" alt="trash" title="УДАЛИТЬ ВСЕ ДАННЫЕ">
            </a>
        </div>
    </div>
</section>
</body>
</html>
