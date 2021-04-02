
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="content-body">
    <div class="container-fluid">
        <div class="page-titles">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="javascript:void(0)">Form</a></li>
                <li class="breadcrumb-item active"><a href="javascript:void(0)">Element</a></li>
            </ol>
        </div>
        <!-- row -->
        <div class="row">
            <div class="col-xl-6 col-lg-6">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Input Style</h4>
                    </div>
                    <div class="card-body">
                        <div class="basic-form">
                            <form:form action="/product/savePro" method="post" modelAttribute="pro" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="control_label" for="firstName">Product Name</label>
                                    <form:input id="firstName" class="form-control" path="pro_name"  autofocus="autofocus"/>
                                    <form:errors path="pro_name" cssClass="colorRed"/>
                                </div>
                                <div class="form-group">
                                    <label class="control_label" for="email">Description</label>
                                    <form:input id="email" class="form-control" path="pro_desc"   autofocus="autofocus"/>
                                    <form:errors path="pro_desc" cssClass="colorRed"/>
                                </div>
                                <div class="form-group">
                                    <label class="control_label" for="email">Image</label>
                                    <input id="email" class="form-control" type="file" name="uploadingfile"   autofocus="autofocus"/>

                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Add New</button>

                                </div>


                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
