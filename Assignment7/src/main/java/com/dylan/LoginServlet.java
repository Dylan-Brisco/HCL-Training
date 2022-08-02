package com.dylan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isValidLogin(String username, String password) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
        PreparedStatement pst = con.prepareStatement("select * from web_users WHERE username = ? AND password = ?;");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            rs.close();
            pst.close();
            con.close();
            return true;
        }
        else {
            rs.close();
            pst.close();
            con.close();
            return false;
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.isEmpty() || password.isEmpty()) {
            res.sendRedirect("login.jsp");
        }
        try {
            if(isValidLogin(username, password)) {
                res.sendRedirect("success.jsp?user=" + username);
            }
            else {
                res.sendRedirect("addUser.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
