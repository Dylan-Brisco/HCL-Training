package com.dylan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dylan.model.Employee;

public class EmployeeDAO {
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees" +
            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";
    private static final String GET_ALL_EMPLOYEES_SQL = "SELECT * FROM employees;";
    private static final String DELETE_EMPLOYEE_BY_ID_SQL = "DELETE FROM employees WHERE id = ?;";
    private static final String UPDATE_EMPLOYEE_BY_ID_SQL = "UPDATE employees SET first_name = ?," +
           "last_name = ?, username = ?, password = ?, address = ?, contact = ? WHERE id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "root");
        } catch (SQLException e) {
           printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int registerEmployee(Employee employee) throws ClassNotFoundException {

        int result = 0;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);) {

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getUsername());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getAddress());
            preparedStatement.setString(7, employee.getContact());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public List<Employee> selectAllEmployees() {
        List<Employee> users = new ArrayList();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMPLOYEES_SQL);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String username = rs.getString(4);
                String password = rs.getString(5);
                String address = rs.getString(6);
                String contact = rs.getString(7);
                Employee employee = new Employee(id, first_name, last_name, username, password, address, contact);
                users.add(employee);
            }
        } catch(SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteEmployee(int id) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID_SQL);) {
            preparedStatement.setInt(1, id);
            int result = preparedStatement.executeUpdate();
            if(result == 1) {
                return true;
            }
            return false;
        }
        catch(SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID_SQL);) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
            preparedStatement.setInt(7, employee.getId());
            int result = preparedStatement.executeUpdate();
            if(result == 1) {
                System.out.println("update employee dao");
                return true;
            }
            return false;
        }
        catch(SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}