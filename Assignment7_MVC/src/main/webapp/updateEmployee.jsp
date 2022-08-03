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
  <title>Employee Update Form</title>
</head>
<body>
<div align="center">
  <h1>Employee Update Form</h1>
  <form action="<%= request.getContextPath() %>/updateEmployee" method="post">
    <table style="with: 80%">
      <tr>
        <td>ID of Employee To Update</td>
        <td><input type="text" name="id" /></td>
      </tr>
      <tr>
        <td>New First Name</td>
        <td><input type="text" name="firstName" /></td>
      </tr>
      <tr>
        <td>New Last Name</td>
        <td><input type="text" name="lastName" /></td>
      </tr>
      <tr>
        <td>New Username</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>New Password</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr>
        <td>New Address</td>
        <td><input type="text" name="address" /></td>
      </tr>
      <tr>
        <td>New Contact No</td>
        <td><input type="text" name="contact" /></td>
      </tr>
    </table>
    <input type="submit" value="Update Employee" />
  </form>
</div>
<input type="button" value="Back To Home" onclick="window.location='index.jsp'" >
</body>
</html>