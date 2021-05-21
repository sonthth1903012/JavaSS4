<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron">
    <h1 class="display-4">Employee</h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <hr class="my-4">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <from>
                <input type="hidden" value="0" id="id_employee"/>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter employee name"/>
                </div>
                <button type="button" class="btn btn-primary" id="save">Save/Update</button>
            </from>
        </div>
        <div class="col-lg-8">
            <div class="">
                <table class="table">
                    <thead>
                    <tr>
                        <th>offset+itr.index+1</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                    </tr>

                    </thead>
                    <tbody class="tbl_employee">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>



<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
    const _host ='http://localhost:8080/api/';
    $(function () {
        resetData();
        loadData();

        $("#save").click(function () {
            if ($("#id_employee").val()==0) {
                var employee = {
                    "name":$("#name").val(),
                }
                //console.log(employee);
                saveDate(employee);
            }else{
                _id = $("#id_employee").val();
                var employee = {
                    "id":_id,
                    "name":$("#name").val(),
                }
                updateEmployee(_id,employee);
            }
        })
    })
    function resetData() {
        $("#name").val("");
        $("#id_employee").val(0)
    }
    function loadData() {
        $.ajax({
            type:"GET",
            url:_host+"v1/employees",
            success:function (response) {
                var rows = '';
                $.each(response.content, function (idx,item) {
                    rows += "<tr >";
                    rows +=" <td>"+item.id+"</td>";
                    rows +=" <td>"+item.name+"</td>";
                    rows +="   <td onclick='editEmployee("+item.id+")' class='btn btn-primary m-3'>Edit</td>";
                    rows +="   <td onclick='deleteEmployee("+item.id+")' class='btn btn-danger m-3'>Delete</td>";
                    rows +=" </tr>";
                });
                $(".tbl_employee").html(rows);
            }
        });
    }

    function saveDate(_employee) {
        $.ajax({
            type:"POST",
            url:_host+"v1/employees",
            data:JSON.stringify(_employee),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
                resetData();
            }
        })
    }

    function editEmployee(_id) {
        $.ajax({
            type:"GET",
            url:_host+"v1/employees/"+_id,
            success:function (res) {
                $("#name").val(res.name),
                    $("#id_employee").val(res.id).each(function () {
                        if ($(this).val()!=res.employee.id)
                        {
                            $(this).removeAttr('selected');
                        }
                    });
            }
        })
    }
    function updateEmployee(_id,_employee) {
        $.ajax({
            type:"PUT",
            url:_host+"v1/employees/"+_id,
            data:JSON.stringify(_employee),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
                resetData();
            }
        })
    }
    function deleteEmpployee(_id) {
        $.ajax({
            type:"DELETE",
            url:_host+"v1/employee/"+_id,
            success:function (res) {
                loadData();
                resetData();
            }
        })
    }
</script>
</body>
</html>