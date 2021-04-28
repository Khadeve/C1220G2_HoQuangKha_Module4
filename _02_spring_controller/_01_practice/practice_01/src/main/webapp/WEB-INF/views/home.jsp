<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/28/2021
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>
<form action="validate" method="post">
    <label>
        Email:
        <input type="text" name="email">
    </label><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
