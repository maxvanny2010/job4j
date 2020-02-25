<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="">
<head>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <link href="img/favicon.png" rel="shortcut icon" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <title>EDIT</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <div class="table-top">
        <div class="table-top-row">
            <div class="center">
                <p class="font600">Редактирование данных программиста перешедшего на сторону Java.</p>
            </div>
            <div class="right">
                <p><a class="link" href="<c:url value="/list"/>">Назад к списку</a></p>
            </div>
        </div>
    </div>
    <div class="table-top">
        <div class="table-top-row">
            <form action="<c:url value="/edit"/>" method="POST">
                <jsp:useBean id="user" scope="request" type="web.model.User"/>
                <input type="hidden" name="id" value="${user.id}"/>
                <div class="input-container">
                    <i class="icon"><img alt="name" src="img/name.png"></i>
                    <label>
                        <input class="input-field" name="name" placeholder="Name"
                               required type="text" value="${user.name}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"><img alt="login" src="img/login.png"></i>
                    <label>
                        <input class="input-field" name="login" placeholder="Login"
                               required type="text" value="${user.login}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"><img alt="email" src="img/email.png"></i>
                    <label>
                        <input class="input-field" name="email" placeholder="Email"
                               required type="text" value="${user.email}"/>
                    </label>
                </div>
                <div class="input-container">
                    <i class="icon"></i>
                    <button class="btn" type="submit"><b>Сохранить</b></button>
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
                            <c:out value="${sessionScope.infoEdit}"/>
                        </span>
                    </label>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
