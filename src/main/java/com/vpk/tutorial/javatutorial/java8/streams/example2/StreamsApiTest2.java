package com.vpk.tutorial.javatutorial.java8.streams.example2;

import java.util.ArrayList;
import java.util.List;

public class StreamsApiTest2 {

    private static List<Employee> employees;

    public static void main(String[] args) {
        init();
        calculateTotalSalary();
        calculateTotalSalaryInADepartment();
    }

    private static void init(){
        employees = new ArrayList<>();
        employees.add(new Employee(1,"20000", 30,1));
        employees.add(new Employee(2,"25000", 32,1));
        employees.add(new Employee(3,"10000", 23,2));
    }

    private static void calculateTotalSalary(){
        Integer sum = employees.stream()
                .map(Employee::getSalary)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println("Total Salary: "+sum);
    }

    private static void calculateTotalSalaryInADepartment(){
        Integer deptTotalSalary = employees.stream()
                .filter(employee -> employee.getDeptId() == 1)
                .map(Employee::getSalary)
                .map(Integer::parseInt)
                .reduce(0,Integer::sum);
        System.out.println("Department 1 Total Salary: "+deptTotalSalary);
    }
}
