package com.company.Zad2;

public class Hand {
    private double length,finger_length;

    public double getLength() {
        return length;
    }

    public Hand(double length, double finger_length) {
        this.length = length;
        this.finger_length = finger_length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getFinger_length() {
        return finger_length;
    }

    public void setFinger_length(double finger_length) {
        this.finger_length = finger_length;
    }

    void Take(){
        System.out.println("I am take Something");
    }
}
