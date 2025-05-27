<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 25.05.2025
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <table>
        <tr>
            <th>Match number</th>
            <th>First Player</th>
            <th>Second player</th>
            <th>Winner</th>
        </tr>
        <c:forEach items="${matches}" var="match">
            <tr>
                <td>${match.id}</td>
                <td>${match.player1.name}</td>
                <td>${match.player2.name}</td>
                <td>${match.winner.name}</td>
            </tr>
        </c:forEach>
    </table>
</head>
<body>

</body>
</html>
