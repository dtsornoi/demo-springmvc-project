<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dmitr
  Date: 4/4/2021
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <form:hidden path="id" />
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><form:input path="firstName" /></td>
                    </tr>
                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><form:input path="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email: </label></td>
                        <td><form:input path="email" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save" class="save"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; both;">
            <p>
                <a href="/customer/list">Back to List</a>
            </p>
        </div>
    </div>
</body>
</html>
