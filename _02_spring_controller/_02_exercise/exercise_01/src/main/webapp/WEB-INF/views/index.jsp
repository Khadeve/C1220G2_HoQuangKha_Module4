<%--
  Created by IntelliJ IDEA.
  User: Kha
  Date: 4/28/2021
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Choose condiments</title>
  </head>
  <body>
  <h3>Sandwich Condiments</h3>
  <form action="condiment" method="get">
    <input type="checkbox" name="condiments" value="lettuce" id="lettuce">
    <label for="lettuce">Lettuce</label>

    <input type="checkbox" name="condiments" value="tomato" id="tomato">
    <label for="tomato">Tomato</label>

    <input type="checkbox" name="condiments" value="mustard" id="mustard">
    <label for="mustard">Mustard</label>

    <input type="checkbox" name="condiments" value="sprouts" id="sprouts">
    <label for="sprouts">Sprouts</label>
    <hr>
    <input type="submit" value="save">
  </form>
  </body>
</html>
