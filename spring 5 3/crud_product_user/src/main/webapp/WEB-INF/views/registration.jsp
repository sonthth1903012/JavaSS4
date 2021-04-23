<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="${contextPath}layout/header.jsp"></jsp:include>
<br>
<br>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <c:if test="${param.success != null}">
                <div class="alert alert-info"> you've successfully registered to our awesome app!
                </div>
            </c:if>
            <h1> Registration </h1>
            <form:form action="registration" method="post" modelAttribute="user">
                <div class="form-group">
                    <label class="control_label" for="firstName">User Name</label>
                    <spring:bind path="username">
                        <form:input id="firstName" class="form-control" path="username" autofocus="autofocus"/>
                        <form:errors path="username" cssClass="colorRed"></form:errors>
                    </spring:bind>
                </div>
                <div class="form-group">

                    <label class="control_label" for="email">Email</label>
                    <spring:bind path="email">
                        <form:input id="email" class="form-control" path="email" autofocus="autofocus"/>
                        <form:errors path="email" cssClass="colorRed"></form:errors>
                    </spring:bind>
                </div>
                <div class="form-group">
                    <label class="control_label" for="password">Password</label>
                    <spring:bind path="username">
                        <form:input id="password" class="form-control" path="password" type="password"
                                    autofocus="autofocus"/>
                        <form:errors path="password" cssClass="colorRed"></form:errors>
                    </spring:bind>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Register</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<jsp:include page="${contextPath}layout/footer.jsp"/>
