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
    <title>Employee Delete Form</title>
</head>
<body>
<div align="center">
    <h1>Employee Delete Form</h1>
    <form action="<%= request.getContextPath() %>/deleteEmployee" method="post">
        <table style="with: 80%">
            <tr>
                <td>Employee ID</td>
                <td><input type="text" name="id" /></td>
            </tr>
        </table>
        <input type="submit" value="Delete Employee" />
    </form>
</div>
<input type="button" value="Back To Home" onclick="window.location='index.jsp'" >
