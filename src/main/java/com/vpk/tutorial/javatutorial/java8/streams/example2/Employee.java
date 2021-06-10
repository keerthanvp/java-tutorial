package com.vpk.tutorial.javatutorial.java8.streams.example2;

public class Employee {
    private int id;
    private String salary;
    private int age;
    private int deptId;

    public Employee() {}

    public Employee(int id, String salary, int age, int deptId) {
        this.id = id;
        this.salary = salary;
        this.age = age;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
