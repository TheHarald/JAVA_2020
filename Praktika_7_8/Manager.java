package com.company;

public class Manager implements EmployeePosition {


    public Manager() {

    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {

        return baseSalary+0.05*((Math.random()*25000)+115000);
    }
}
