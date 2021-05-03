<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/29/2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mail box setting</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="submitSetting" method="post" modelAttribute="mailBox">
    <table>
        <tr>
            <td>Languages: </td>
            <td>
                <form:select path="language">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japanese" label="Japanese"/>
                    <form:option value="Chinese" label="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size: </td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5" label="5"/>
                    <form:option value="10" label="10"/>
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spam filter: </td>
            <td>
                <form:checkbox path="spamFilter" value="1"/>
                Enable spam filter
            </td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td><form:textarea path="signature" rows="9" cols="15"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="cancel" value="update"/></td>
            <td><input type="submit" name="cancel" value="cancel"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
