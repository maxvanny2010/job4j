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
    <title>INDEX</title>
</head>
<body>
<div class="container">
    <div class="text-center" style="font-weight: bold">Список дтп</div>
    <br>
    <div class="row"><a href="<c:url value="/create"/>">Добавить инцидент</a></div>
    <div class="row">
        <table class="table table-condensed">
            <thead class="p-1 text-center">
            <tr>
                <c:forEach var="hat" items="${hats}">
                    <jsp:useBean id="hat" type="java.lang.String"/>
                    <th>
                        <c:if test="${hat eq 'fa'}">
                            <div><i class="fas fa-car-crash" style="color:red;"></i></div>
                        </c:if>
                        <c:if test="${hat eq 'id'}">
                            <div><i class="fas fa-cloud" style="color:dodgerblue;"></i></div>
                        </c:if>
                        <c:if test="${hat ne 'id' && hat ne 'fa'}">
                            <c:out value="${hat}"/>
                        </c:if>
                    </th>
                </c:forEach>
            </tr>
            </thead>
            <tbody class="p-1 text-center bg-white" id="list">
            <c:forEach var="entry" items="${map}">
                <tr>
                    <td>
                        <c:out value="${entry.key}"/>
                    </td>
                    <td>
                        <c:out value="${entry.value.name}"/>
                    </td>
                    <td>
                        <c:out value="${entry.value.number}"/>
                    </td>
                    <td>
                        <c:out value="${entry.value.address}"/>
                    </td>
                    <td>
                        <label for="area" class="sr-only">Описание</label>
                        <textarea id="area" style="background-color: lightblue; width: 300px; height:100px;
                        overflow: auto;" disabled>
                            <c:out value="${entry.value.desc}"/>
                        </textarea>
                    </td>
                    <td>
                        <img width="200px" height="100px"
                             src="data:image/jpeg;base64,${entry.value.image}" alt="foto"/>
                    </td>
                    <td>
                        <form action="<c:url value='/edit'/>" method="POST" title="редактировать">
                            <input name="id" type="hidden" value="${entry.value.id}"/>
                            <input class="btn btn-info btn-sm"
                                   style="background-color:dodgerblue; border-color:white; color: white; border-radius: 0;"
                                   type="submit" value="редактировать">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
