package com.company.Zad1;

public class Shape{
    double radius;
    String color;
    int positionX,positionY;

    public Shape(String color,double radius,int x,int y) {
        this.color = color;
        this.radius=radius;
        this.positionX=x;
        this.positionY=y;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
