<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<header>
    <hr>
    <div class="table-top">
        <div class="table-top-row">
            <div class="table-top-cell">
                <img src="img/arms.png" alt="arms">
            </div>
            <div class="table-top-cell-center">
                <form action="<c:url value="/logout"/>" method="POST" title="Выйти">
                    <input class="del" type="submit" value="Выйти">
                </form>
                <p><b>TOP SECRET.</b></p>
                <p>Headquarters the Microsoft.</p>
            </div>
        </div>
    </div>
    <hr>
</header>
