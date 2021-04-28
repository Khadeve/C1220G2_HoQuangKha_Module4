<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/27/2021
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>customer info</title>
</head>
<body>
<form action="update" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><c:out value="${updatedCustomer.name}"/></td>
        </tr>
        <tr>
            <td>email</td>
            <td><c:out value="${updatedCustomer.email}"/></td>
        </tr>
        <tr>
            <td>address</td>
            <td><c:out value="${updatedCustomer.address}"/></td>
        </tr>
        <tr>
            <input type="submit" value="update">
        </tr>
    </table>
</form>

</body>
</html>
