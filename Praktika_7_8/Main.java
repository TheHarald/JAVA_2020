package com.company;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i <180 ; i++) {
            company.hire(new Employee("Operator"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+1000,new Operator()));
        }

        for (int i = 0; i <80 ; i++) {
            company.hire(new Employee("Manager"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+5000,new Manager()));
        }

        for (int i = 0; i <80 ; i++) {
            company.hire(new Employee("TopManager"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+20000,new TopManager(company)));
        }

        company.sortStaff();
        //company.outList();
        company.calcIncome();
        System.out.println();
        company.outList(company.getTopSalaryStaff(10));
        System.out.println();
        company.outList(company.getLowestSalaryStaff(30));
        for (int i = 0; i<company.getStaff().size()/2; i++) {
            company.fire((int)Math.random()*10);
        }

        System.out.println("//////////////////////////////");
        company.outList(company.getTopSalaryStaff(10));
        System.out.println();
        company.outList(company.getLowestSalaryStaff(30));





    }
}
