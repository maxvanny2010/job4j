<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Accident</title>
</head>
<body>
<div class="container">
    <div class="row">
        <jsp:useBean id="errorMessage" scope="request" class="java.lang.String"/>
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-size: smaller; font-weight: bold; margin: 30px 0;">
                    ${errorMessage}
            </div>
        </c:if>
        <form name='login' action="<c:url value="/login"/>" method='POST'>
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
    </div
    <form name='logout' action="<c:url value="/logout"/>" method='POST'>
        <input name="logout" type="submit" value="logout"/>
    </form>
</div>
</body>
</html>
