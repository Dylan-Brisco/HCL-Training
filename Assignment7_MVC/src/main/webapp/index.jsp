<%--
  Created by IntelliJ IDEA.
  User: dylanbrisco
  Date: 8/2/22
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home</title>
</head>
<body>
<div class="btn-group">
    <input type="button" value="Register Employee" onclick="window.location='registerEmployee.jsp'" >
    <input type="button" value="Update Employee" onclick="window.location='updateEmployee.jsp'" >
    <input type="button" value="Delete Employee" onclick="window.location='deleteEmployee.jsp'" >
    <form action="${pageContext.request.contextPath}/listEmployees" method="post">
        <input type="submit" name="/listEmployees" value="List Employees" />
    </form>
</div>
</body>