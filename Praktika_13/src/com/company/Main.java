package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle= new Rectangle();
        Scanner scanner = new Scanner(System.in);

        rectangle.setName(scanner.next());
        try {
            rectangle.setWidth(scanner.nextInt());
            rectangle.setLength(scanner.nextInt());

        }
        catch (IncorrectSideException use){
            System.out.println("Некоррекные данные");
        }
        catch (Exception e){
            System.out.println("Некорректные данные");
        }
        finally {
            System.out.println(rectangle.toString());
        }


    }
}