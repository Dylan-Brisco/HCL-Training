package com.hcl.assignment5;

public class Employee {
    int id;
    String name;
    int age;
    String gender;
    String dept;
    int yearofJoining;
    int salary;

    public Employee(int id, String name, int age, String gender, String dept, int yearofJoining, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.yearofJoining = yearofJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getYearofJoining() {
        return yearofJoining;
    }

    public void setYearofJoining(int yearofJoining) {
        this.yearofJoining = yearofJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept='" + dept + '\'' +
                ", yearofJoining=" + yearofJoining +
                ", salary=" + salary +
                '}';
    }
}
