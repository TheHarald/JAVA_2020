package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();


        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(
                    "Ivan"+Integer.toString(i),
                    "Ivanov",
                    Integer.toString(118232+i)+"Moscow",
                    "+0_000_000_00_00",
                    LocalDate.of(2001,3,12+i),
                    Math.random()*10000));
        }

        //company.outList();

        company.outList(new Selector() {
            @Override
            public boolean myBeHandled(Employee employee) {

                return employee.getSalary()<5_000;
            }
        },employee -> employee.getSalary());

        System.out.print("\n###################################################\n");
        company.outList(new SalarySelector(8000),employee -> employee.getSalary());


    }


}
