package com.company;

public class SalarySelector implements Selector{

    private double maxSalary;

    public SalarySelector(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean myBeHandled(Employee employee) {
        return this.maxSalary<employee.getSalary();
    }
}
