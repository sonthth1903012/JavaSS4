<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="${contextPath}layout/header.jsp"></jsp:include>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1> User Login Page </h1>
        </div>
        <h1>day la trang home</h1>
    </div>
</div>
<jsp:include page="${contextPath}layout/footer.jsp"/>