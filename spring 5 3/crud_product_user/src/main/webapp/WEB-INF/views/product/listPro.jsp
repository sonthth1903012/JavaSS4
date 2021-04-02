<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="jumbotron">
                <h1 class="display-4">Product Manager!</h1>
                <hr class="my-4">
                <a class="btn btn-primary btn-lg" href="${contextPath}/product/create" role="button">Create New Product</a>
                <div style="margin-top: 20px">

                </div>

            </div>
        </div>
    </div>

</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <!-- As a heading -->
            <nav class="navbar navbar-light bg-light">
                <form action="${contextPath}/product/searchPro" class="form-inline my-2 my-lg-0 mt-4">
                    <input class="form-control mr-sm-2" type="text" name="keyword" placeholder="Search Product Name" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </nav>
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

            <h1>List Product</h1>
            <table class="table table-active">
                <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>desc</th>
                    <th>image</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="pro">
                    <tr>
                        <td>${pro.id}</td>
                        <td>${pro.pro_name}</td>
                        <td>${pro.pro_desc}</td>
                        <td><img src="${contextPath}${pro.image}" width="50px"/></td>
                        <td>
                            <a href="${contextPath}/product/edit?id=${pro.id}" class="btn btn-primary">Edit</a>
                            <a href="${contextPath}/product/deletePro?id=${pro.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>


&lt;%&ndash;<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>&ndash;%&gt;
&lt;%&ndash;<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>&ndash;%&gt;
<jsp:include page="../layout/footer.jsp"/>--%>
<%----%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp"></jsp:include>
<div class="content-body">
    <div class="container-fluid">
        <div class="page-titles">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="javascript:void(0)">Table</a></li>
            </ol>
        </div>
        <!-- row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-header">
                        <a class="card-title" href="${contextPath}/product/create" role="button">Create New Product</a>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-responsive-md">
                                <thead>
                                <tr>
                                    <th><strong>Stt</strong></th>
                                    <th><strong>Name</strong></th>
                                    <th><strong>Desc</strong></th>
                                    <th><strong>Image</strong></th>
                                    <th><strong>Action</strong></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="pro">
                                <tr>
                                    <td><strong>${pro.id}</strong></td>
                                    <td>${pro.pro_name}</td>
                                    <td>${pro.pro_desc}</td>
                                    <td><img src="${contextPath}${pro.image}" width="50px"/></td>
                                    <td>
                                        <div class="dropdown">
                                            <button type="button" class="btn btn-success light sharp" data-toggle="dropdown">
                                                <svg width="20px" height="20px" viewBox="0 0 24 24" version="1.1"><g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"><rect x="0" y="0" width="24" height="24"/><circle fill="#000000" cx="5" cy="12" r="2"/><circle fill="#000000" cx="12" cy="12" r="2"/><circle fill="#000000" cx="19" cy="12" r="2"/></g></svg>
                                            </button>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${contextPath}/product/edit?id=${pro.id}">Edit</a>
                                                <a class="dropdown-item" href="${contextPath}/product/deletePro?id=${pro.id}">Delete</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>