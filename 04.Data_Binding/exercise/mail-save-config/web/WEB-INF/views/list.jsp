<%--
  Created by IntelliJ IDEA.
  User: Lyn
  Date: 11/24/2020
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Config</title>
</head>
<body>
<h1>List Setting Config</h1>
    <form:form modelAttribute="mailConfig" action="/save" method="post">
        <table>
            <tr>
                <span>
                    languages:
                </span>
                <form:select path="language" items="${listLanguage}" id="role" ></form:select><br>
            </tr>
            <tr>
                <span>Page Size</span>
                <form:select path="pageSize" items="${listSizePage}"></form:select>
                <span> emails per page</span><br>
            </tr>
            <tr>
                <span>Spam Filter</span>
                <form:checkbox path="spamFilter"></form:checkbox>
                <span> Enable spams filter </span><br>
            </tr>
            <tr>
                <span>Signature</span>
                <form:textarea path="signature"></form:textarea>
            </tr>
        </table>
        <button type="submit">Save</button>
        <button type="submit" formaction="/" formmethod="get">Cancel</button>
    </form:form>
</body>
</html>
