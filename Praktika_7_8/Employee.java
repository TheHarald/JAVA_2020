package com.company;

public class Employee {
    private String surname,name;
    private double salary;
    private double finalSalary;

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    private EmployeePosition employeePosition;

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public Employee(String surname, String name, double salary, EmployeePosition employeePosition) {
        this.surname = surname;
        this.name = name;
        this.salary = salary;
        this.employeePosition = employeePosition;
        this.finalSalary=employeePosition.calcSalary(salary);

    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
