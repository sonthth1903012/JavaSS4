<%--
  Created by IntelliJ IDEA.
  User: jngst
  Date: 19/03/2021
  Time: 09:25 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384—ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbu-expand-md navbar-dark" style="">
        <div>
            <a href="" class="floybar-brand"> User
                Management App </a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br/>
<div class="row">
    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thread> <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
                </tr>
            </thread>
            <tbody>
            <c:forEach var="user" items="${listUser}">
             <tr>
                 <td>
                    <c:out value ="${user.id}"/>
                 </td>
                 <td>
                     <c:out value = "${user.name}"/>
                 </td>
                 <td>
                     <c:out value = "${user.email}"/>
                 </td>
                 <td>
                     <c:out value= "${user.country}"/>
                 </td>
                 <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                     <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                 </td>
             </tr>
            </c:forEach>
            <!-- } -->
            </tbody>
        </table>
    </div>
</div>
</body>
</html>


