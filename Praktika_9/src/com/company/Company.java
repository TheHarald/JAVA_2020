package com.company;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> staff = new ArrayList<>();

    public void hire(Employee employee){
        staff.add(employee);
    }


    public void fire(int index){
        staff.remove(index);
    }

    public void outList(){
        for(Employee employee :staff){
            System.out.println(employee.toString());
        }
    }
    public void outList(Selector selector,Handler handler){
        int count=0;
        for(Employee employee :staff){
            if(selector.myBeHandled(employee)){
                handler.HandleEmployees(employee);
                System.out.println(employee.toString());
            }
        }
        count++;
    }

}
