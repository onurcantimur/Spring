<%--
  Created by IntelliJ IDEA.
  User: Onur
  Date: 13.07.2020
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>CRM Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <jsp:include page="header.jsp"/>



<div id="container">
        <div id="content">

            <input type="button" value="Add Customer" onclick="window.location.href='showFormAdd';return false;" class="add-button"/>



            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>

                </tr>


                <c:forEach items="${customers}" var="tempCustomer">

                    <c:url  var="updateLink" value="/customer/showFormUpdate">
                        <c:param  name="customerId" value="${tempCustomer.id}"/>
                    </c:url>


                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>

                        <td><a href="${updateLink}">update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">delete</a></td>

                    </tr>

                </c:forEach>


            </table>


        </div>
    </div>

</body>
</html>
