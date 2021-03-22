<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees Manager</title>
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <%
        if (session.getAttribute("username") != null) {
        %>
        <div class="header">
            <br>
            <h1 align="center">Product List</h1>
            <div class="menu bubplastic horizontal orange">
                <ul>
                    <li><span class="menu_r"><a href="login.jsp"><span class="menu_ar">Login</span></a></span></li>
                    <li class="highlight"><span class="menu_r"><a href="employeeManager.jsp"><span class="menu_ar">Product List</span></a></span></li>
                    <li><span class="menu_r"><a href="logout.jsp"><span class="menu_ar">logout</span></a></span></li>
                </ul>
                <br class="clearit" />
            </div>
        </div>
        <div class="content">
            <br><br>
            <table id="tb" width="100%" align="center">
                <tr>
                    <th colspan="11" height="50px"><h4>PRODUCT LIST</h4></th>
                </tr>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Details</th>
                    <th colspan="2"></th>
                </tr>

                <jsp:useBean id="ebo" class="com.example.bol.ProductBO" scope="request"/>
                <%
                    com.example.entities.Product[] arr=null;
            String option = request.getParameter("option");
            String value = request.getParameter("value");
            if (option == null || value == null) {
                arr = ebo.select();
            } else {
                if (option.equals("Name")) {
                    arr = ebo.find(0, value);
                } else if (option.equals("Details")) {
                    arr = ebo.find(1, value);
                }
            }
                    com.example.ConvertData convert = new com.example.ConvertData();
            if (arr.length > 0) {

                for (int i = 0; i < arr.length; i++) {
                    out.println("<tr><td>" + arr[i].getName() + " </td>");
                    out.println("<td>" + arr[i].getPrice() + "</td>");
                    out.println("<td>" + arr[i].getAmount() + "</td>");
                    out.println("<td>" + arr[i].getDetails() + "</td>");
                }
            }
                %>
            </table>
            <br>
            <%} else {
            %>
            <jsp:forward page="login.jsp"/>
            <%}%>
        </div>
    </body>
</html>