<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Loan Manager"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Loans Manager</h1>
                </div>
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a >Home</a></li>
                        <li class="breadcrumb-item active">Loans Manager</li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Loans List</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 10px">STT</th>
                                <th>Loan name</th>
                                <th>Total</th>
                                <th>Term</th>
                                <th>From</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="loan" varStatus="itr">
                                <tr>
                                    <td>${offset+itr.index+1}</td>
                                    <td>${loan.name}</td>
                                    <td>${loan.total}</td>
                                    <td>${loan.term}</td>
                                    <td>${loan.created}</td>
                                    <td>${loan.status}</td>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/editLoan?id=${loan.loan_id}" class="btn  btn-info btn-sm"><i class="fas fa-pencil-alt"> </i> Edit</a>
                                        <a href="${pageContext.request.contextPath}/deleteLoan?id=${loan.loan_id}" class="btn  btn-danger btn-sm"><i class="fas fa-trash"> </i> Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%-- <mytag:PaginatiomnTaglib steps="10" offset="${offset}" count="${count}" uri="/cateController/getAll.htm" next="&raquo;" previous="&laquo;"/> --%>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
            <div class="col-md-5">
                <!-- general form elements -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Add New Loan!</h3>
                        <div class="card-tools">
                            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="card-body" style="display: block;">
                        <!-- /.card-header -->
                        <!-- form start -->
                        <%--@elvariable id="loanNew" type=""--%>
                        <f:form action="${pageContext.request.contextPath}/saveLoan" method="POST" modelAttribute="loanNew">
                            <spring:bind path="loan_name">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">User name:</label>
                                    <f:input path="loan_name" type="text"  class="form-control  ${status.error ?'border border-danger':''} ${param.errorcatename !=null ?'border border-danger':''}" id="exampleInputEmail1"   placeholder="Enter User name..."/>
                                    <f:errors path="loan_name" class="text-danger"  ></f:errors>
                                    <p class="text-danger">${param.errorcatename}</p>
                                </div>
                            </spring:bind>
                            <spring:bind path="status">
                                <div class="form-group">
                                    <label>Status:</label>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="On" checked="true"  id="customRadio1" />
                                        <label for="customRadio1" class="custom-control-label">On</label>
                                    </div>
                                    <div class="custom-control custom-radio">
                                        <f:radiobutton class="custom-control-input" path="status" value="Pending" id="customRadio2" />
                                        <label for="customRadio2" class="custom-control-label">Pending</label>
                                    </div>
                                    <f:errors path="status" class="text-danger"  ></f:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="total">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Total:</label>
                                    <f:input path="total" type="text"  class="form-control  ${status.error ?'border border-danger':''} ${param.errorcatename !=null ?'border border-danger':''}" id="exampleInputEmail1"   placeholder="Enter total..."/>
                                    <f:errors path="total" class="text-danger"  ></f:errors>
                                    <p class="text-danger">${param.errorcatename}</p>
                                </div>
                            </spring:bind>
                            <spring:bind path="term">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Term:</label>
                                    <f:input path="term" type="text"  class="form-control  ${status.error ?'border border-danger':''} ${param.errorcatename !=null ?'border border-danger':''}" id="exampleInputEmail1"   placeholder="Enter term..."/>
                                    <f:errors path="term" class="text-danger"  ></f:errors>
                                    <p class="text-danger">${param.errorcatename}</p>
                                </div>
                            </spring:bind>
                            <div class="card-footer">
                                <button type="submit" class="btn btn-info">Add New</button>
                            </div>
                        </f:form>
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>


</body>
</html>