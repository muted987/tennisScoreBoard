<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 26.05.2025
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<%@ page isELIgnored="false" %>
<html>
<head><title>Error Page</title></head>
<body>
<h1>An error occurred</h1>
  ${pageContext.errorData.throwable.message}
</body>
</html>
