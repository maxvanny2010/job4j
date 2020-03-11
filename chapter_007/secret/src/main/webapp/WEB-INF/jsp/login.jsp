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
    <jsp:include page="/WEB-INF/jsp/fragments/link.jsp"/>
    <title>Authentication</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/headerGate.jsp"/>
<section>
    <div class="container" style="width: 800px">
        <div class="text-center" style="font-weight: bold">Авторизация.</div>
        <div class="row">
            <div class="float-right" style="width: 250px;">
                <form action="<c:url value="/login"/>" method="POST" id="credentials">
                    <div class="form-group">
                        <label for="role"></label>
                        <select class="form-control" id="role" name="role">
                            <option value="admin">admin</option>
                            <option value="user" selected>user</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="login">Login</label>
                        <input class="form-control" id="login" name="login" placeholder="Логин"
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="password">Password</label>
                        <input class="form-control" id="password" name="password" placeholder="Пароль"
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <button class="btn"
                                style="background-color:#DC3545; font-weight: bold; width: 250px" type="submit">
                            Войти
                        </button>
                    </div>
                </form>
                <div class="form-group">
                    <label>
                        <a href="<c:url value="/add"/>">Регистрация</a>
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        <span style="color:#DC3545">
                            <c:out value="${sessionScope.infoGate}"/>
                        </span>
                    </label>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>

