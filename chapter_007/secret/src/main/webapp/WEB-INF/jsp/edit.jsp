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
    <jsp:include page="/WEB-INF/jsp/fragments/link.jsp"/>
    <script src="js/validateEdited.js"></script>
    <title>EDIT</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <div class="container" style="width: 800px">
        <div class="text-center" style="font-weight: bold">
            Редактирование данных программиста перешедшего на сторону Java.
        </div>
        <br>
        <div class="row">
            <div class="col-md-12">
                <div class="float-md-right">
                    <a class="link" href="<c:url value="/list"/>"> Назад к списку </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="float-right" style="width: 250px;">
                <form action="<c:url value="/edit"/>" method="POST" id="edited">
                    <jsp:useBean id="user" scope="request" type="web.model.User"/>
                    <input type="hidden" name="id" value="${user.id}"/>
                    <div class="form-group">
                        <label class="sr-only" for="name">Name</label>
                        <input class="form-control" value="${user.name}" id="name" name="name"
                               placeholder="Имя 3-20 букв" required type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="login">Login</label>
                        <input class="form-control" value="${user.login}" id="login" name="login"
                               placeholder="Логин 3-20 букв/цифр" required type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="email">Email</label>
                        <input class="form-control" value="${user.email}" id="email" name="email"
                               placeholder="Почта example@ex.com" required type="text">
                    </div>
                    <div class="form-group">
                        <button class="btn" style="background-color:#DC3545; font-weight: bold; width: 250px"
                                type="submit" form="edited">
                            Сохранить
                        </button>
                    </div>
                    <div class="form-group">
                        <label>
                            <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                        </label>
                    </div>
                    <div class="form-group">
                        <label>
                        <span style="color:#DC3545">
                            <c:out value="${sessionScope.infoEdit}"/>
                        </span>
                        </label>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
