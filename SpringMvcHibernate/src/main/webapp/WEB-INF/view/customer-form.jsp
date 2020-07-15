<%--
  Created by IntelliJ IDEA.
  User: Onur
  Date: 13.07.2020
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

    <jsp:include page="header.jsp"/>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="post"  >
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>

                    <tr>
                        <td><label>Last Name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>

                    <tr>
                        <td><label>E-Mail:</label></td>
                        <td><form:input path="email"/></td>
                    </tr>

                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>

                </tbody>
            </table>
        </form:form>


    </div>


    <div style="clear: both"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>

</body>
</html>
