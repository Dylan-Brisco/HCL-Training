package com.hcl.assignment6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTestDriver {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(111, "emp1", 20, "male", "maintenance", 2022, 60000));
        list.add(new Employee(222, "emp2", 25, "male", "development", 2017, 80000));
        list.add(new Employee(333, "emp3", 34, "female", "maintenance", 2014, 70000));
        list.add(new Employee(444, "emp4", 19, "male", "security", 2021, 60000));
        list.add(new Employee(555, "emp5", 26, "female", "maintenance", 2016, 65000));
        list.add(new Employee(666, "emp6", 50, "male", "development", 2005, 100000));
        list.add(new Employee(777, "emp7", 44, "male", "development", 2009, 120000));
        list.add(new Employee(888, "emp8", 39, "female", "maintenance", 2012, 60000));
        list.add(new Employee(999, "emp9", 58, "male", "maintenance", 1999, 69000));

        List<Employee> males = getEmployeeListByGender(list, "male");
        List<Employee> females = getEmployeeListByGender(list, "female");

        // part1
        System.out.println("There are " + getNumEmployee(males) + " males and " + getNumEmployee(females) + " females");

        // part2
        System.out.println("Average male age " + getAvgAge(males).getAsDouble() +
                " average female age " + getAvgAge(females).getAsDouble());

        // part3
        System.out.println("Highest paid employee data: " + getHighestPaidEmployee(list).toString());

        // part4
        System.out.print("Employee names who have joined past 2015: ");
        printEmployeesAfter2015(list);
        System.out.println();

        // part5
        System.out.println("Senior most employee data (year of joining) " + getSeniorMostEmployee(list).toString());

        // part6
        List<String> departments = Arrays.asList("maintenance", "security", "development");
        for (String department : departments) {
            System.out.println("Number of employees in " + department + ": " + getNumEmpInDepartment(list, department));
        }

        //part7
        System.out.println("Males in maintenance " + getNumEmpInDepartment(males, "maintenance") +
                " Females in maintenance " + getNumEmpInDepartment(females, "maintenance"));

        //part8
        System.out.println("Average male salary is $" + getAvgSalary(males).getAsDouble()
                + " Average female salary is $" + getAvgSalary(females).getAsDouble());

        //part9
        System.out.println("Employee data for employees younger or equal to 30 " + getEmpByAge(list, 31, true).toString());
        System.out.println("Employee data for employees  older than 25 " + getEmpByAge(list, 25, false).toString());

        for(String department: departments) {
            List<Employee> empsInDept = getEmployeeListByDepartment(list, department);
            System.out.print("Employees in dept " + department + ": ");
            for(Employee e: empsInDept) {
                System.out.print(e.getName() + " ");
            }
            System.out.println();
        }
    }

    static List<Employee> getEmployeeListByGender(List<Employee> list, String gender) {
        Stream<Employee> stream = list.stream()
                .filter(e -> e.getGender().equalsIgnoreCase(gender));

        return stream.collect(Collectors.toList());
    }

    // method for part1
    static long getNumEmployee(List<Employee> list) {
        return list.stream().count();
    }

    // method for part2
    static OptionalDouble getAvgAge(List<Employee> list) {
        return list.stream()
                .mapToInt(e -> e.getAge())
                .average();
    }

    // method for part2
    static Employee getHighestPaidEmployee(List<Employee> list) {
        return list.stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }

    // method for part4
    static void printEmployeesAfter2015(List<Employee> list) {
        list.stream()
                .filter(e -> e.getYearofJoining() > 2015)
                .forEach(e -> System.out.print(e.getName() + " "));
    }

    // method for part5
    static Employee getSeniorMostEmployee(List<Employee> list) {
        return list.stream()
                .min(Comparator.comparingInt(e -> e.getYearofJoining()))
                .get();
    }

    //method for part6 and part8
    static long getNumEmpInDepartment(List<Employee> list, String department) {
        return list.stream()
                .filter(e -> e.getDept().equalsIgnoreCase(department))
                .count();
    }

    // method for part8
    static OptionalDouble getAvgSalary(List<Employee> list) {
        return list.stream()
                .mapToInt(e -> e.getSalary())
                .average();
    }

    // method for part9
    static List<Employee> getEmpByAge(List<Employee> list, int age, boolean younger) {
        Stream<Employee> stream;
        if (younger) {
            stream = list.stream()
                    .filter(e -> e.getAge() < age);

        } else {
            stream = list.stream()
                    .filter(e -> e.getAge() > age);

        }
        return stream.collect(Collectors.toList());
    }

    // method for part10
    static List<Employee> getEmployeeListByDepartment(List<Employee> list, String department) {
        Stream<Employee> stream = list.stream()
                .filter(e -> e.getDept().equalsIgnoreCase(department));
        return stream.collect(Collectors.toList());
    }
}