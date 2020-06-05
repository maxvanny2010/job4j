<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 6/5/2020
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="">
<head>
    <jsp:include page="/WEB-INF/view/link.jsp"/>
    <title>EDIT</title>
</head>
<body>
<section>
    <div class="container" style="width: 800px">
        <div class="text-center" style="font-weight: bold">
            Редактирование данных водителя.
        </div>
        <br>
        <jsp:include page="/WEB-INF/view/back.jsp"/>
        <div class="row">
            <div class="float-right" style="width: 250px;">
                <form action="<c:url value="/update"/>" enctype="multipart/form-data" method="POST" id="update">
                    <jsp:useBean id="axe" scope="request" type="accident.model.Accident"/>
                    <input type="hidden" name="id" value="${axe.id}"/>
                    <div class="form-group">
                        <label class="sr-only" for="name">Имя</label>
                        <input class="form-control" value="${axe.name}" id="name" name="name"
                               placeholder="имя" required type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="number">Номер</label>
                        <input class="form-control" value="${axe.number}" id="number" name="number"
                               placeholder="номер авто" required type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="address">Адрес</label>
                        <input class="form-control" value="${axe.address}" id="address" name="address"
                               placeholder="адрес" required type="text">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="desc">Описание</label>
                        <textarea class="form-control" id="desc" name="desc" rows="10" cols="1"
                                  placeholder="описание дтп" required type="text">${axe.desc}
                        </textarea>
                    </div>
                    <div class="form-group">
                        <button class="btn" style="background-color:#DC3545; font-weight: bold; width: 250px"
                                type="submit" form="update">
                            Сохранить
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
