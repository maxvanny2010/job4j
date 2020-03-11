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
    <jsp:include page="/WEB-INF/jsp/fragments/link.jsp"/>
    <title>TOP SECRET 404</title>
</head>
<body>
<div class="container" style="width: 800px">
    <div class="row">
        <hr>
        <div class="col-md-6">
            <img src="img/arms.png" alt="arms">
        </div>
        <div class="col-md-6">
            <div class="float-md-right">
                <div style="float:right; font-weight: bold">404 not found</div>
                <div style="clear:both">Headquarters the Microsoft</div>
            </div>
        </div>
        <hr>
    </div>
    <section>
        <div class="row">
            <div class="col-md-6">
                <img alt="" src="img/404.png">
            </div>
            <div class="col-md-6">
                <div class="float-md-right">
                    Осознать ошибку и
                    <a href="<c:url value="/444"/>">Вернуться</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
            </div>
            <hr>
        </div>
    </section>
</div>
</body>
</html>
