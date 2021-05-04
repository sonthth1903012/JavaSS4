<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Product Manager"/>
<%@include file="/WEB-INF/views/layout/admin/header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Product Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Product Manager</li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="card card-warning collapsed-card">
                        <div class="card-header">
                            <h3 class="card-title">Look Up Products</h3>

                            <div class="card-tools">

                                <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-plus"></i>
                                </button>

                                <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body" style="display: none; color: #FFF">
                            <div class="col-md-12" style="margin-top: 10px;margin-bottom: 10px;">
                                <div class="row">
                                    <div class="col-md-3 col-sm-6 col-12">
                                        <a href="${pageContext.request.contextPath}/admin/product" class="btn btn-block btn-primary">All</a>
                                    </div>
                                    <div class="col-md-3 col-sm-6 col-12">
                                        <a href="${pageContext.request.contextPath}/admin/product/show" class="btn btn-block btn-success">Show</a>
                                    </div>
                                    <div class="col-md-3 col-sm-6 col-12">
                                        <a  href="${pageContext.request.contextPath}/admin/product/hidden" class="btn btn-block btn-danger">Hidden</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- /.card-footer-->
                    </div>
                </div>
                <div class="col-12">
                    <div class="row">
                        <div class="col-2">
                            <a class="btn btn-block btn-info btn-sm" href="${pageContext.request.contextPath}/admin/product/insertProduct">Insert Product</a>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">

            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Product List</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body p-0">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">No.</th>

                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>

                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="pro" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}</td>

                                    <td>${pro.product_name}</td>
                                    <td><fmt:formatNumber>${pro.price}</fmt:formatNumber> $</td>
                                    <td>${pro.description}</td>

                                    <td class="project-actions ">
                                        <a href="${pageContext.request.contextPath}/admin/product/detailPro?id=${pro.product_id}" class="btn btn-primary btn-sm"><i class="fas fa-folder"> </i>Detail</a>
                                        <a href="${pageContext.request.contextPath}/admin/product/deleteProducts?id=${pro.product_id}" class="btn btn-danger btn-sm"><i class="fas fa-trash"></i> Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                    <div class="card-footer clearfix">

                    </div>
                </div>
                <!-- /.card -->
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/layout/admin/footer.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<%@include file="/WEB-INF/views/layout/admin/infoActionc.jsp" %>

</body>
</html>



