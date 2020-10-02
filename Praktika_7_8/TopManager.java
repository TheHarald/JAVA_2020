package com.company;

public class TopManager implements EmployeePosition{

    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome()>10000000)
            return baseSalary*1.5;
        else
            return baseSalary;

    }
}
