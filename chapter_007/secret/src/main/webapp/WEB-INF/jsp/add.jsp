<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 2/11/2020
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <jsp:include page="/WEB-INF/jsp/fragments/link.jsp"/>
    <script src="js/validateAdded.js"></script>
    <title>ADD</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/fragments/headerGate.jsp"/>
<section>
    <div class="container" style="width: 800px">
        <div class="text-center" style="font-weight: bold">
            Добавление в список программиста перешедшего на сторону Java.
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="float-md-right">
                    <a class="link" href="<c:url value="/gate"/>">Главная</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="float-right" style="width: 250px;">
                <form action="<c:url value="/upload"/>" method="POST" enctype="multipart/form-data" id="added">
                    <div class="form-group">
                        <label class="sr-only" for="name">Name</label>
                        <input class="form-control" id="name" name="name" placeholder="Имя 3-20 букв" required
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="login">Login</label>
                        <input class="form-control" id="login" name="login" placeholder="Логин 3-20 букв/цифр" required
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="email">Email</label>
                        <input class="form-control" id="email" name="email" placeholder="Почта example@ex.com" required
                               type="text">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="password">Password</label>
                        <input class="form-control" id="password" name="password" placeholder="Пароль 1-5 букв/цифр"
                               required
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="confPassword">Password</label>
                        <input class="form-control" id="confPassword" name="confPassword"
                               placeholder="Пароль подтвердить"
                               required type="text"/>
                    </div>

                </form>
                <div class="form-group">
                    <label class="sr-only" for="file">Выберите аватар</label>
                    <input accept="image/*" class="required" id="file" name="file"
                           onchange="encodeImageFileAsURL(this)"
                           type="file" form="added"/>
                </div>
                <div class="form-group">
                    <button class="btn" style="background-color:#DC3545; font-weight: bold; width: 250px"
                            type="submit" form="added">
                        Сохранить
                    </button>
                </div>
                <div class="form-group">
                    <label>
                        <jsp:include page="/WEB-INF/jsp/fragments/footer.jsp"/>
                    </label>
                </div>
                <div class="form-group">
                    <label>
                        <span style="color:#DC3545">
                            <c:out value="${sessionScope.infoUpload}"/>
                        </span>
                    </label>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>



