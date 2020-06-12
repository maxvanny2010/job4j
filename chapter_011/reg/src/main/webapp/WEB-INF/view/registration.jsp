<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 6/10/2020
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="link.jsp"/>
    <title>Registration</title>
</head>
<body>
<div class="container">
    <div class="row">
        <form name='registration' action="<spring:url value="/registration"/>" method='POST'>
            <table>
                <tr>
                    <td><label>
                        <input type='text' name='username' required placeholder="введите имя">
                    </label></td>
                </tr>
                <tr>
                    <td><label>
                        <input type='password' name='password' required placeholder="введите пароль"/>
                    </label></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="Регистрация"/>
                    </td>
                </tr>
            </table>
            <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </form>
    </div>
</div>
</body>
</html>
