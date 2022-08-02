<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: dylanbrisco
  Date: 8/1/22
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
  <head>
    <meta charset="UTF-8">
    <title>success</title>
  </head>
  <body>
    <%
      String username = request.getParameter("user");

      out.println("<html><body><b>Welcome " + username +
               "</b></body></html>");
    %>
  </body>
</html>