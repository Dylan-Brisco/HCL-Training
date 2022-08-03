package com.dylan.controller;

import java.io.IOException;
import java.util.List;

import com.dylan.dao.EmployeeDAO;
import com.dylan.model.Employee;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmployeeController extends HttpServlet {

    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formAction = request.getServletPath();
        switch(formAction) {
            case "/registerEmployee":
                registerEmployee(request, response);
                break;
            case "/listEmployees":
                listEmployees(request, response);
                break;
            case "/updateEmployee":
                updateEmployee(request, response);
                break;
            case "/deleteEmployee":
                deleteEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void registerEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = getEmployee(request, response);
        try {
            employeeDAO.registerEmployee(employee);
        }
        catch(ClassNotFoundException e) {
            System.out.println("here");
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeDAO.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployees.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = getEmployee(request, response);
        employeeDAO.updateEmployee(employee);
        response.sendRedirect("index.jsp");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("index.jsp");
    }

    private Employee getEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        return new Employee(id, firstName, lastName, username, password, address, contact);//model object
    }
}