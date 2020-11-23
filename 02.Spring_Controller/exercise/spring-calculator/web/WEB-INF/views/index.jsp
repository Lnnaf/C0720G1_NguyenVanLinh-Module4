
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
  <h1>Super Calculator </h1>

  <form>
    <label for="num1">First number:</label>
    <input type="text" id="num1" name="num1"><br><br>
    <label for="num2">Second number:</label>
    <input type="text" id="num2" name="num2"><br><br>
    <button type="submit" formaction="/plus">Addition(+)</button>
    <button type="submit" formaction="/sub">Subtraction(-)</button>
    <button type="submit" formaction="/multi">Multiplication(X)</button>
    <button type="submit" formaction="/division">Division(/)</button>
  </form>
  <h2>Result ${operator} : ${result}</h2>
  </body>
</html>
