package com.company;

public class Square extends Shape{
    protected double side;

    public Square() {
    }

    @Override
    double getArea() {
        return side*side;
    }

    @Override
    double getPerimeter() {
        return 4*side;
    }

    public Square(double side) {
        this.side=side;
    }

    public Square(double side, String color, boolean filled) {

        this.color=color;
        this.filled=filled;
        this.side=side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;

    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

