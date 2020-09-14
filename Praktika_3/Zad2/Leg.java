package com.company.Zad2;

public class Leg {
    private double length;
    int foot_size;

    public Leg(double length, int foot_size) {
        this.length = length;
        this.foot_size = foot_size;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getFoot_size() {
        return foot_size;
    }

    public void setFoot_size(int foot_size) {
        this.foot_size = foot_size;
    }

    void Walk(){
        System.out.println("I am Walking");
    }
}
