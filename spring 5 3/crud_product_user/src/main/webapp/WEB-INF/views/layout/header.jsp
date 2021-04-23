    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="UTF-8">
        <title>Registration and login</title>
        <link type="text/css" rel="stylesheet" href="${contextPath}/assets/bootstrap.css">
        <style>
        .colorRed{
        color: red;
        }
        </style>
        </head>
        <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            <a class="nav-link" href="${contextPath}/home">Home</a>
            </li>
            <li class="nav-item ">
            <a class="nav-link" href="${contextPath}/product">Product Manager</a>
            </li>
            <li class="nav-item ">
            <a class="nav-link" href="${contextPath}/usermodel">User Manager</a>
            </li>

            </ul>
        </c:if>
        <ul class="nav justify-content-end ">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle btn btn-secondary" href="#" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            ${pageContext.request.userPrincipal.name}</a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="btn btn-block" href="/logout">Logout</a>
            </div>
            </li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item dropdown">
            <a class="btn btn-block" href="/login">Login</a>
            </li>
        </c:if>

        </ul>
        </div>
        </div>

        </nav>