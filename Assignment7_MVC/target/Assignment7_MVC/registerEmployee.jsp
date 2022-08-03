<%--
  Created by IntelliJ IDEA.
  User: dylanbrisco
  Date: 8/2/22
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employe Register Form</title>
</head>
<body>
<div align="center">
    <h1>Employee Register Form</h1>
    <form action="<%= request.getContextPath() %>/registerEmployee" method="post">
        <table style="width: 80%">
            <tr>
                <td>Employee ID</td>
                <td><input type="text" name="id" /></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" /></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>Contact No</td>
                <td><input type="text" name="contact" /></td>
            </tr>
        </table>
        <input type="submit" value="Register Employee" />
    </form>
</div>
<input type="button" value="Back To Home" onclick="window.location='index.jsp'" >
</body>
</html>