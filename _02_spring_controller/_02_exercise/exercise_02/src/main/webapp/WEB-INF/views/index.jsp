<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/28/2021
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="calculate" method="get">
    <input type="text" name="firstOperand" value="${firstOperand}">
    <input type="text" name="secondOperand" value="${secondOperand}">
    <br>
    <br>
    <input type="submit" name="operator" value="Addition">
    <input type="submit" name="operator" value="Subtraction">
    <input type="submit" name="operator" value="Multiplication">
    <input type="submit" name="operator" value="Division">
</form>
</body>
</html>
