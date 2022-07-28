package com.hcl.assignment6;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static Connection con;
    static Scanner scan;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root");
        scan = new Scanner(System.in);
        boolean isFinished = false;

        while(!isFinished) {
            System.out.println("---------------------------");
            System.out.println("|1: Get List Of Employees |");
            System.out.println("|2: Update Employee By ID |");
            System.out.println("|3: Delete Employee By ID |");
            System.out.println("|4: Get Employee By ID    |");
            System.out.println("|5: Add Employee          |");
            System.out.println("|6: Quit                  |");
            System.out.println("---------------------------");
            System.out.print("Enter Your Choice: ");
            int userChoice = getSafeInt();
            switch(userChoice) {
                case 1:
                    getEmployeeList();
                    break;
                case 2:
                    System.out.print("Please Enter The ID Of The Employee You Would Like To Update: ");
                    int updateID = getSafeInt();
                    updateEmployee(updateID);
                    break;
                case 3:
                    System.out.println("Please Enter The ID Of The Employee You Would Like To Delete: ");
                    int delID = getSafeInt();
                    deleteEmployee(delID);
                    break;
                case 4:
                    System.out.print("Please Enter The ID Of The Employee You Would Like To Find: ");
                    int getEmpID = getSafeInt();
                    getEmployee(getEmpID);
                    break;
                case 5:
                    addEmployee();
                    break;
                case 6:
                    System.out.println("Goodbye");
                    isFinished = true;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void getEmployeeList() throws SQLException {
        PreparedStatement pst = con.prepareStatement("select * from emp");
        ResultSet rs = pst.executeQuery();
        printResultSet(rs);
        pst.close();
    }

    private static void updateEmployee(int id) throws SQLException {
        boolean exists = doesEmpExist(id);
        if (exists) {
            System.out.print("Enter New Name For Employee: ");
            String newName = scan.next();
            System.out.print("Enter New Age For Employee: ");
            int newAge = getSafeInt();

            PreparedStatement pst = con.prepareStatement("UPDATE emp SET name = ?, age = ? WHERE id = ?;");
            pst.setString(1, newName);
            pst.setInt(2, newAge);
            pst.setInt(3, id);
            pst.executeUpdate();
            pst.close();

            getEmployee(id);
        }
        else {
            System.out.println("EMPLOYEE ID NOT FOUND");
        }
    }

    private static void deleteEmployee(int id) throws SQLException {
        boolean exists = doesEmpExist(id);
        if (exists) {
            PreparedStatement pst = con.prepareStatement("DELETE FROM emp WHERE id = ?;");
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            getEmployeeList();
        }
        else {
            System.out.println("EMPLOYEE ID NOT FOUND");
        }
    }

    private static void getEmployee(int id) throws SQLException {
        boolean exists = doesEmpExist(id);
        if (exists) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM emp WHERE id = ?;");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            printResultSet(rs);
            pst.close();
        }
        else {
            System.out.println("EMPLOYEE ID NOT FOUND");
        }
    }

    private static void addEmployee() throws SQLException {
        System.out.print("Enter Employee ID: ");
        int id = getSafeInt();
        boolean exists = doesEmpExist(id);
        if (!exists) {
            System.out.print("Enter Employee Name: ");
            String name = scan.next();
            System.out.print("Enter Employee Age: ");
            int age = getSafeInt();
            PreparedStatement pst = con.prepareStatement("INSERT INTO emp VALUES(?,?,?);");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, age);
            pst.executeUpdate();
            getEmployeeList();
        }
        else {
            System.out.println("PLEASE ENTER A UNIQUE EMPLOYEE ID");
        }
    }

    private static void printResultSet(ResultSet rs) throws SQLException {
        System.out.println("ID\tNAME\tAGE");
        while(rs.next()) {
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
                    + "\t" + rs.getInt(3));
        }
        rs.close();
    }

    private static boolean doesEmpExist(int id) throws SQLException {
        boolean exists = false;
        PreparedStatement pst = con.prepareStatement("select * from emp");
        ResultSet rs = pst.executeQuery();
        while (rs.next() && !exists) {
            if (rs.getInt(1) == id) {
                exists = true;
            }
        }
        return exists;
    }

    public static int getSafeInt() { // error proof int input from user
        boolean invalidInput = true;
        int num = 0;

        while (invalidInput) {
            invalidInput = false; // if remains false we break
            try {
                num = scan.nextInt(); //asks user for input
                scan.nextLine();
                if (num <= 0){ // if input is out of bounds throw exception
                    throw new InputOutOfBoundsException();
                }
            } catch (InputOutOfBoundsException e) {
                System.out.print("Input Not In Range, Please Enter a Value >= 0: "); // what user sees if they aren't in bounds
                invalidInput = true; // so we can reloop
            } catch (Exception e) {
                System.out.print("Invalid Input, Integers Only. Please Enter Again: "); //if they enter double/string/etc.
                scan.nextLine(); //prevent errors
                invalidInput = true; //reloop
            }
        }
        return num;
    }
    public static class InputOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}
