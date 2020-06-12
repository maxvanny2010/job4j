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
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-size: smaller; font-weight: bold; margin: 30px 0;">
                    ${errorMessage}
            </div>
        </c:if>
        <form name='login' action="<c:url value='/login'/>" method='POST'>
            <table>
                <tr>
                    <td>UserName:</td>
                    <td><label><input type='text' name='username'></label></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><label><input type='password' name='password'/></label></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="submit"/>
                    </td>
                </tr>
            </table>
            <%--   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </form>
    </div>
    <div class="d-flex flex-column">
        <div> login 1 pass 123456(c данными)</div><br/>
        <div> login 2 pass 123456(с данными)</div><br/>
        <div> или  <a href="<spring:url value="/registration"/>">регистрация</a> (таблица пустая)</div>
    </div>
</div>
</body>
</html>
