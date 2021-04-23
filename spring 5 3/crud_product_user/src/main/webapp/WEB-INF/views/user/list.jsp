<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <h1 class="display-4">User Manager!</h1>
                <hr class="my-4">
                <p>trungpvth1807021@fpt.edu.vn</p>
            </div>
        </div>
    </div>

</div>
<div class="container">
    <div class="row">

        <div class="col-md-12 col-md-offset-3">
            <c:if test="${param.success != null}">
                <div class="alert alert-success" role="alert">
                    thanh cong
                </div>
            </c:if>
            <c:if test="${param.error!=null}">
                <div class="alert alert-danger" role="alert">
                    that bai
                </div>
            </c:if>

            <h1>List User</h1>
            <table class="table table-active">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>User name</th>
                    <th>Email</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>


<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>--%>
<jsp:include page="../layout/footer.jsp"/>