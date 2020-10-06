package com.company;

import java.time.LocalDate;

public class Employee {
    private String name,surname,address,number;
    private final LocalDate year;
    private double salary;

    public Employee(String name, String surname, String address, String number, LocalDate year, double salary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.year = year;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getYear() {
        return year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n"+"Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", salary=" + salary +
                '}';
    }
}
