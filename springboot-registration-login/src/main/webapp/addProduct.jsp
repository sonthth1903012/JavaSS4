<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="bootstrap.min.css" th:href="@{bootstrap.min.css}"/>
    <title>Add new User to T1811e</title>
</head>
<body>
<div class="col-3"></div>
<div class="container col-6">
    <h1>Create new User</h1>
    <div class="col-md-auto">
        <form th:object="${product}" th:action="@{save}" method="post">
            <div>
                <label th:text="Name" th:for="name"></label>
                <input type="text" class="form-control" th:field="*{name}" placeholder="Name"/>
            </div>
            <div style="clear: both; display: block; height: 10px"></div>
            <div>
                <label th:text="Email" th:for="email"></label>
                <input type="text" class="form-control" th:field="*{desc}" placeholder="Description"/>
            </div>
            <div>
                <label th:text="Phone" th:for="phone"></label>
                <input type="text" class="form-control" th:field="*{image}" placeholder="Image"/>
            </div>
            <div style="clear: both; display: block; height: 10px"></div>
            <input type="submit" value="Save" class="btn btn-success"/>
        </form>
    </div>
</div>
</body>
</html>