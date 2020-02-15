<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/15/2020
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>TOP SECRET 404</title>
</head>
<body>
<hr>
<div class="table-top">
    <div class="table-top-row">
        <div class="table-top-cell"><img alt="arms" src="img/arms.png"></div>
        <div class="table-top-cell-center">
            <p><b>404 not found</b></p>
            <p>Headquarters the Microsoft.</p>
        </div>
    </div>
</div>
<hr>
<div class="table-top">
    <div class="table-top-row">
        <div class="table-top-cell">
            <img alt="" src="img/404.png">
        </div>
        <div class="table-top-cell-center">
            <p><b>Осознать свою ошибку и
                <a href="<c:url value="/index"/>"> Вернуться</a> ещё не поздно</b></p>
        </div>
    </div>
</div>
</body>
</html>
