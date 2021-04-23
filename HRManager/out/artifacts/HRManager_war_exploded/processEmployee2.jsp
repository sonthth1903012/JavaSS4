<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
taglib prefix="c" uri="http://java.sun.rom/jcp/jstl/rore" %>
age contentType="text/html" pageEncoding="UTF-8"96> CTYPE HTML PUBLIC "—//W3C//DTD HTML 4.01 Transitional//EN" "http://www.wl.org/TR/htm14/lonse.dtd">
=lead>
<meta http—equiv="Content—Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link href="css/menu_style.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<script src="script/valid_data.js"></script>
</head>
<body> ‹c:choose> <c:when test="${empty sessionScope.usernamel}">
    <jsp:forward page="login.jsp"/>
</c:when> <c:when test="Vnot empty sessionScope.usernamel">
    <c:set var="1B" value="" scope="request"/> <c:choose/>
    <c:when test="Vempty requestScope.action or requestScope.action eq 'add'}">

    </c:when> <c:set var="1B" scope="request" value="Add New"/>
</c:when> <c:when test="${requestScope.action eq 'delete'}">
    <c:set var="1B" scope="request" value="Delete"/>
</c:when> <c:when test="${requestScope.action eq 'edit'}">
    <c:set var="1B" scope="request" value="Update"/>
</c:when>