<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 6/4/2020
  Time: 6:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="link.jsp"/>
    <title>Accident</title>
</head>
<body>
<div class="container">
    <div class="text-center">Список</div>
    <br>
    <div class="row">
        <table class="table table-condensed">
            <thead class="p-1 text-center">
            <jsp:useBean id="hats" scope="request" type="java.util.List"/>
            <tr>
                <c:forEach var="hat" items="${hats}">
                    <jsp:useBean id="hat" type="java.lang.String"/>
                    <th>
                        <c:if test="${hat eq 'id'}">
                            <div class="fa fa-cloud"></div>
                        </c:if>
                        <c:if test="${hat ne 'id'}">
                            <h6><c:out value="${hat}"/></h6>
                        </c:if>
                    </th>
                </c:forEach>
            </tr>
            </thead>
            <tbody class="p-1 text-center bg-white" id="list">
            <jsp:useBean id="list" type="java.util.List" scope="request"/>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>
                        <c:out value="${item.id}"/>
                    </td>
                    <td>
                        <c:out value="${item.name}"/>
                    </td>
                    <td>
                        <c:out value="${item.text}"/>
                    </td>
                    <td>
                        <c:out value="${item.address}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
