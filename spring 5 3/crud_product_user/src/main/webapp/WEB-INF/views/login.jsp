
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration and login</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/assets/bootstrap.css">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#" >Registration and LoginModule</a>
        </div>
    </div>
</nav>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <c:if test="${pageContext.request.userPrincipal.name != null}">

                <h1>Login Thành Công</h1>
                <a class="btn btn-primary" href="${contextPath}/product">Trang Product</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <h1> User Login Page </h1>
                <form:form action="/login" method="post">
                    <c:if test="${param.error != null}">
                        <div >
                            <div class="alert alert-danger">Invalid username or password.</div>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div >
                            <div class="alert alert-info">You have been logged out.</div>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <label for="username"> Email :</label>
                        <input type="email" class="form-control" id="username" name="username" placeholder="Enter Email "
                               autofocus="autofocus">
                    </div>
                    <div class="form-group">
                        <label for="password"> Password :</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter password "
                               autofocus="autofocus">
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <input type="submit" name="login-submit" id="Login-submit"
                                       class="form-control btn btn-primary" value="Login" >
                            </div>
                        </div>
                    </div>
                </form:form>
                <div class="form-group">
                    <span>New user? <a href="/registration" >Register here</a></span>
                </div>
            </c:if>


        </div>
    </div>
</div>

</body>
</html>