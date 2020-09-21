package com.company;

public class Main {

    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(3,6,2,2,5);
        //System.out.println(circle.center.toString());
            circle.moveDown();
        //System.out.println(circle.center.toString());

        MovableRectangle rectangle = new MovableRectangle(1,2,4,7,1,1);
        //System.out.println(rectangle.toString());
        rectangle.moveDown();
        rectangle.moveRight();


        System.out.println(rectangle.toString());
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());
        rectangle.setWidth(3.4);
        rectangle.setLength(1.2);

        System.out.println(rectangle.getWidth());

        System.out.println(rectangle.toString());

        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());

    }
}
