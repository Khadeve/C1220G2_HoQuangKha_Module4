<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/29/2021
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h2>Enter An Account</h2>
<form:form action="checkLogin" method="post" modelAttribute="loginInf">
    <table>
        <tr>
            <td>Account: </td>
            <td><form:input path="account"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="submit">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
