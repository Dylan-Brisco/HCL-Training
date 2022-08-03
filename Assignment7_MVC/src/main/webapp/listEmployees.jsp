<%--
Created by IntelliJ IDEA.
User: dylanbrisco
Date: 8/2/22
Time: 11:05 PM
To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.dylan.model.Employee" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% List<Employee> list = (List<Employee>)request.getAttribute("employeeList");
    for(Employee e: list) { %>
<td><%=e.getId()%></td>
<td><%=e.getFirstName()%></td>
<td><%=e.getLastName()%></td>
<td><%=e.getUsername()%></td>
<td><%=e.getPassword()%></td>
<td><%=e.getAddress()%></td>
<td><%=e.getContact()%></td>
<br>
<%
    }
%>
<input type="button" value="Back To Home" onclick="window.location='index.jsp'" >

