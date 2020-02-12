<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link rel="shortcut icon" href="img/favicon.png" type="image/png">
    <title>TOP SECRET</title>
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jsp"/>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p class="font600">Список программистов перешедших на сторону Java.</p>
            </div>
            <div class="table-top-row">
                <div class="table-top-cell">
                    <div>Список в данный момент пуст.</div>
                </div>
                <div class="table-top-cell">
                    <div><a href="<c:url value="/add"/>">Добавить в список</a></div>
                </div>
            </div>
            <div class="right"><img alt="the finger of GOD" src="img/arms_2.png" title="the finger of GOD"></div>
        </div>
    </div>
</section>
</body>
</html>
