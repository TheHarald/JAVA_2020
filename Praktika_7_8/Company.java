package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Company {

    private List <Employee> staff = new ArrayList<>();
    private double income=0;


    public void hire(Employee employee){
        staff.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        for(Employee employee :employeeList){
            hire(employee);
        }
    }

    public Employee search(String name, String surname){

        for(Employee employee: this.staff){
            if(employee.getName().equals(name) && employee.getSurname().equals(surname)){
                return employee;
            }
        }
        return null;
    }


    public List<Employee> getStaff() {
        return staff;
    }

    public void fire(String name, String surname){
        staff.remove(search(name,surname));
    }

    public void fire(int index){
        staff.remove(index);
    }




    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void sortStaff(){
        staff.sort(Comparator.comparing(Employee::getFinalSalary).reversed());
        
    }


    List<Employee> getTopSalaryStaff(int count){
        if(count>0 && staff.size()>count){

            this.sortStaff();
            return staff.subList(0,count);
        }
        else
            return null;

    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count>0 && staff.size()>count){

            this.sortStaff();
            return staff.subList(staff.size()-count,staff.size());
        }
        else
            return null;
    }

    public void outList(){
        for(Employee employee: staff){
            System.out.print(employee.getName()+" " +employee.getSurname()+" "+
                    employee.getEmployeePosition().getJobTitle() +" ");
            System.out.print((int)employee.getEmployeePosition().calcSalary(employee.getSalary())+" руб.");
            System.out.println();
        }
    }

    public void outList(List<Employee> list){
        for(Employee employee: list){
            System.out.print(employee.getName()+" " +employee.getSurname()+" "+
                    employee.getEmployeePosition().getJobTitle() +" ");
            System.out.print((int)employee.getEmployeePosition().calcSalary(employee.getSalary())+" руб.");
            System.out.println();
        }
    }


    public void calcIncome(){
        for(Employee employee: staff){
            if(employee.getEmployeePosition().getJobTitle().equals("Manager")) {
                income+=(employee.getFinalSalary()-employee.getSalary())*20-employee.getFinalSalary();
            }
            if(employee.getEmployeePosition().getJobTitle().equals("Operator")){
                income-=employee.getFinalSalary();
            }
            if(employee.getEmployeePosition().getJobTitle().equals("TopManager")){
                income-=employee.getFinalSalary();
            }
        }
    }




}
