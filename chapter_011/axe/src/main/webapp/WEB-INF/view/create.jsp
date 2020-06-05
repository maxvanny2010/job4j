<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 6/5/2020
  Time: 3:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="link.jsp"/>
    <title>CREATE</title>
</head>
<body>
<div class="container" style="width: 800px;">
    <div class="text-center" style="font-weight: bold">
        Добавление данных водителя.
    </div>
    <br>
    <jsp:include page="/WEB-INF/view/back.jsp"/>
    <div class="row">
        <div class="container">
            <div class="float-left" style="width: 250px;">
                <form action="<c:url value='/save'/>" enctype="multipart/form-data" id="dtp" method="post">
                    <div class="form-group">
                        <label class="sr-only" for="name">Имя</label>
                        <input class="form-control" id="name" name="name" placeholder="имя" required
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="number">Номер</label>
                        <input class="form-control" id="number" name="number" placeholder="номер машины"
                               required type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="address">Адрес</label>
                        <input class="form-control" id="address" name="address" placeholder="адрес" required
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="desc">Описание</label>
                        <textarea class="form-control" id="desc" name="desc" rows="10" cols="30"
                                  placeholder="описание дтп" required></textarea>
                    </div>
                    <div class="form-group">
                        <label for="file">Фото дтп</label>
                        <input accept="image/*" class="required" id="file" name="file" type="file"/>
                    </div>
                    <div class="form-group">
                        <input class="btn" style="background-color:#DC3545; font-weight: bold; width: 250px"
                               type="submit"
                               value="Сохранить"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
