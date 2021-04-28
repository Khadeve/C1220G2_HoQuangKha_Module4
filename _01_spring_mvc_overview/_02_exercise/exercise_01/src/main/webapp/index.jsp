<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/27/2021
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculate" method="get">
    <table>
      <tr>
        <td>first operand</td>
        <td><input type="text" name="firstOperand"></td>
      </tr>
      <tr>
        <td>operator</td>
        <td>
          <select name="operator">
            <option value="add">add</option>
            <option value="minus">minus</option>
            <option value="multiply">multiply</option>
            <option value="divide">divide</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>first operand</td>
        <td><input type="text" name="secondOperand"></td>
      </tr>
      <tr>
        <td><input type="submit" value="calculate"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
