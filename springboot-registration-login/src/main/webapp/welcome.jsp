<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css"
          th:href="@{bootstrap.min.css}"/>
    <title>User</title>
</head>
<body>
<div class="col-3"></div>
<div class="container col-6">
    <h1>Product CRUD actions</h1>
    <br/>
    <table class="table table-active">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Image</th>
            <th>CRUD</th>
        </tr>
<%--        <tr th:each="product: ${prodcut}">--%>
<%--            <td th:text="${product.name}"></td>--%>
<%--            <td th:text="${product.desc}"></td>--%>
<%--            <td th:text="${product.image}"></td>--%>
<%--            <td>--%>
<%--                <a th:href=@{/edit?id={id}(id=${product.id})}" class="btn btn-primary">Edit</a>--%>
<%--                <a th:href="@{/delete?id={id}(id=${product.id})}" class="btn btn-danger">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td>
                    <c:out value = "${product.name}"/>
                </td>
                <td>
                    <c:out value = "${product.desc}"/>
                </td>
                <td>
                    <c:out value= "${product.image}"/>
                </td>
                <td><a href="edit?id=<c:out value='${product.id}' />">Edit</a>
                    <a href="delete?id=<c:out value='${product.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/add" class="btn btn-success ">Create new product</a>
</div>
</body>
</html>
