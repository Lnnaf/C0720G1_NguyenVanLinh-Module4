<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lyn
  Date: 11/23/2020
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Choice is </h1>
<h1>${false}</h1>
    <ul>
        <c:forEach items="${list_condiment}" var="condiment">
        <li>${condiment}</li>
</c:forEach>
    </ul>

</body>
</html>
