<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>UserView</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr valign="top">
                <td>${user.name}</td>
                <td>${user.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
