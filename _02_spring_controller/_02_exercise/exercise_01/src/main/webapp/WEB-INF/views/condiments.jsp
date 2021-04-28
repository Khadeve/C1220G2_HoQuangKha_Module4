<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/28/2021
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>condiments</title>
</head>
<body>
<h3>Chosen Condiments</h3>
<ul>
    <c:forEach var="condiment" items="${condiments}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
