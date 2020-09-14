package com.company.Zad1;
import java.util.Scanner;
public class CircleTest {
    public static void main(String[] args) {
        Circle example = new Circle();
        Scanner in = new Scanner(System.in);
        double r,x,y;
        r = in.nextDouble();
        x = in.nextDouble();
        y = in.nextDouble();
        example.setPositionX(x);
        example.setPositionY(y);
        example.setRadius(r);
        System.out.println("X="+example.getPositionX()+"\nY="+example.getPositionY()+"\nRadius="+example.getRadius());

    }
}
