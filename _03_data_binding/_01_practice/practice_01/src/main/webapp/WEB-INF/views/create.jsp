<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/29/2021
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create employee</title>
</head>
<body>
<h3>Welcome, Enter The New Employee Details</h3>
<form:form action="addEmployee" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Employee contact number: </form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
