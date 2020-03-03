<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim Vanny
  Date: 9/21/2019
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h4 class="text-center">Fill forms</h4>
<div class="container">
    <div class="float-left" style="width: 300px;">
        <form action="<c:url value="/index"/>" method="post"
              enctype="application/x-www-form-urlencoded">
            <div class="form-group">
                <label class="sr-only" for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <label class="sr-only" for="pass">Password</label>
                <input type="text" class="form-control" id="pass" name="password" placeholder="Password">
            </div>
            <div class="form-group">
                <label class="sr-only" for="state">State</label>
                <select id="state" class="form-control" name="state">
                    <option selected>State...</option>
                    <option>female</option>
                    <option>male</option>
                </select>
            </div>
            <button style="background-color:#DC3545;border: black"
                    type="submit" class="btn">Sign in
            </button>
        </form>
    </div>
</div>
<br/>
<div class="container">
    <table class="table table-striped">
        <thead class="p-1 text-center bg-danger">
        <tr>
            <th>email</th>
            <th>password</th>
            <th>state</th>
        </tr>
        </thead>
        <tbody class="p-1 text-center bg-light">
        <jsp:useBean id="users" type="java.util.List" scope="request"/>
        <c:forEach var="user" items="${users}">
            <jsp:useBean id="user" type="web.present.BootsServlet.User"/>
            <tr>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.gender}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
</body>
</html>
