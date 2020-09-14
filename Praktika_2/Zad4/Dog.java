package com.company.Zad4;

public class Dog {
   private String name;
   private int age;
    public Dog (int age,String name){
        this.age=age;
        this.name=name;
    }
     String GetName(){
        return this.name;
     }
     int GetAge(){
        return this.age;
     }
     void SetName(String name){
        this.name=name;
     }
     void SetAge(int age){
        this.age=age;
     }
     int AgeToHuman(){
        return this.age*7;
     }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
