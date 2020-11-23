<%--
  Created by IntelliJ IDEA.
  User: Lyn
  Date: 11/23/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Show Checkboxes</h1>

  <form action="condiments">
    <input type="checkbox" id="lettuce" name="condiment" value="Lettuce">
    <label for="lettuce"> Lettuce</label><br>
    <input type="checkbox" id="Tomato" name="condiment" value="Tomato">
    <label for="Tomato">Tomato</label><br>
    <input type="checkbox" id="Mustard" name="condiment" value="Mustard">
    <label for="Mustard">Mustard</label><br><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="Mustard">Mustard</label><br><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
