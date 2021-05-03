<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/29/2021
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>display employee info</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Id: </td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Contact number: </td>
        <td>${employee.contactNumber}</td>
    </tr>
</table>
</body>
</html>
