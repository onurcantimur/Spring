<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Welcome to My Home Page</h2>


	<p>
		User: <security:authentication property="principal.username"/> <br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>

	<br><br>

	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip meeting (Only for Manager peeps)</a><br>

	</security:authorize>
	<br><br>
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/systems">Systems meeting (Only for Admin peeps)</a><br>
	</security:authorize>




	<hr>

	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>

	
</body>
</html>