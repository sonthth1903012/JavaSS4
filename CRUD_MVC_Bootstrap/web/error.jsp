<%--
  Created by IntelliJ IDEA.
  User: jngst
  Date: 19/03/2021
  Time: 10:48 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0.1 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>Error:</h1>
<h2><%=exception.getMessage()%><br/></h2>
</body>
</html>
