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
    <div class="container" style="width: 800px">
        <div class="row">
            <hr>
            <div class="col-md-6">
                <img src="img/swiss.png" alt="arms">
            </div>
            <div class="col-md-6">
                <div class="float-md-right">
                    <div style="float: right; font-weight: bold">TOP SECRET</div>
                    <br>
                    <div style="float: right">Headquarters the Microsoft</div>
                    <br>
                    <div style="float: right">
                        <form action="<c:url value="/logout"/>" method="POST" title="Выйти">
                            <input class="del" type="submit" value="Выйти">
                        </form>
                    </div>
                    <br style="clear:both">
                </div>
            </div>
            <hr>
        </div>
    </div>
</header>
