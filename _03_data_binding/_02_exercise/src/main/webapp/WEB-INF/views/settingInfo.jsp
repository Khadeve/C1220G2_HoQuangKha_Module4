<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/29/2021
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting Info</title>
</head>
<body>
<table>
    <tr>
        <td>Language: </td>
        <td>${mailBox.language}</td>
    </tr>
    <tr>
        <td>Page size: </td>
        <td>${mailBox.pageSize} pages</td>
    </tr>
    <tr>
        <td>Spam filter: </td>
        <td>${mailBox.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${mailBox.signature}</td>
    </tr>
</table>
</body>
</html>
