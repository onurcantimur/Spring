<%--
  Created by IntelliJ IDEA.
  User: Onur
  Date: 27.07.2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">

        <c:if test="${param.error != null}">
            <i>Sorry !   You Entered invalid username/password.</i>
        </c:if>
        
        
        <p>User Name: <input type="text" name="username"/> </p>
        <p>Password: <input type="text" name="password"/> </p>

        <input type="submit" value="Login">

    </form:form>

</body>
</html>
