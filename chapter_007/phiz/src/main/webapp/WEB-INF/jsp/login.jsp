<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/20/2020
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>Authentication</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/headerGate.jsp"/>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p><b>Авторизация.</b></p>
            </div>
        </div>
        <div class="table-top-row">
            <form action="<c:url value="/login"/>" method="POST">
                <div class="input-container">
                    <i class="icon"></i>
                    <label for="role"></label>
                    <select id="role" name="role">
                        <option value="admin">admin</option>
                        <option value="user" selected>user</option>
                    </select>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="login" src="img/favicon.png" title="login"></i>
                    <label>
                        <input class="input-field" name="login" placeholder="Логин" required type="text">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="Пароль" src="img/favicon.png" title="Пароль"></i>
                    <label>
                        <input class="input-field" name="password" placeholder="Пароль" required type="password">
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <button class="btn" type="submit"><b>Войти</b></button>
                </div>
                <div class="input-container">
                    <i class="icon">
                        <img alt="Регистрация" src="img/name20.jpg" title="Регистрация">
                    </i>
                    <label>
                        <a href="<c:url value="/add"/>">Регистрация</a>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <label>
                        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <label>
                        <span style="color:red">
                            <c:out value="${sessionScope.infoGate}"/>
                        </span>
                    </label>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>

