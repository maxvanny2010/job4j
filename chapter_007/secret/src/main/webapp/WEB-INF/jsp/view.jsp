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
    <jsp:include page="/WEB-INF/jsp/fragments/link.jsp"/>
    <title>VIEW</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/header.jsp"/>
<section>
    <jsp:useBean id="user" type="web.model.User" scope="request"/>
    <div class="container" style="width: 800px">
        <div class="text-center" style="font-weight: bold">
            Данные ${user.name} перешедшего на сторону Java.
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
                <div class="row">${user.name}</div>
                <div class="row">${user.login}</div>
                <div class="row">${user.email}</div>
                <div class="row">
                    <img width="30px" height="30px"
                         src="data:image/jpeg;base64,${user.foto}" alt="foto"/>
                </div>
                <div class="row">
                    <label>
                        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                    </label>
                </div>
                <div class="row">
                    <label>
                        <span style="color:#DC3545">
                            <c:out value="${sessionScope.infoUpload}"/>
                        </span>
                    </label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="float-md-right">
                    <form action="<c:url value="/delete"/>" method="POST">
                        <input name="id" type="hidden" value="${user.id}"/>
                        <input class="del" type="submit" value="Удалить <c:out value="${user.name}"/>"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>

