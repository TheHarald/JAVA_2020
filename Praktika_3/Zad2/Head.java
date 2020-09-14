package com.company.Zad2;

public class Head {
   private String Hair_Color;
   private double radius,size;

    public String getHair_Color() {
        return Hair_Color;
    }

    public Head(String hair_Color, double radius, double size) {
        Hair_Color = hair_Color;
        this.radius = radius;
        this.size = size;
    }

    public void setHair_Color(String hair_Color) {
        Hair_Color = hair_Color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    void Rotate(){
        System.out.println("I am rotate");
    }

}
