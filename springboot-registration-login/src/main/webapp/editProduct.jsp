<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>
    <title>Title</title>
</head>
<body>
<div class="col-3"></div>
<div class="container col-6"><h1>Edit User</h1>
    <form th:object="${product}" th:action="@{save}" method="post">
        <input type="hidden" th:field="*{id}">
        <div>
            <label th:text="Name" th:for="name"></label>
            <input type="text" class="form-control" th:field="*{name}" placeholder="Name"/>
        </div>
        <div style="clear: both; display: block; height: 10px">
        </div>
        <div>
            <label th:text="Email" th:for="email"></label>
            <input type="text" class="form-control" th:field="*{desc}" placeholder="Email"/>
        </div>
        <div style="clear: both; display: block; height: 10px"></div>
        <div>
            <label th:text="Phone" th:for="phone"></label>
            <input type="text" th:field="*{image}" class="form-control" placeholder="Phone"/>
        </div>
        <div style="clear: both; display: block; height: 10px"></div>
        <input type="submit" value="Save" class="btn btn-success"/>
    </form>
</div>
</body>
</html>
