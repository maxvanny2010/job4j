<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/23/2020
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<footer>
    <div>
        <c:out value="ID::${pageContext.session.id}"/>
        <br/>
        <c:out value="ROLE::${sessionScope.role}"/>
    </div>
</footer>
