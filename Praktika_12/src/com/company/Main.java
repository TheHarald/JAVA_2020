package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        text = scanner.nextLine();
        print(text, Colors.BRIGHT_YELLOW);
        print(text);
        System.out.println();


    }

    public static void print(String text, Colors color) {
        System.out.println(color.getCode() + text);
    }

    public static void print(String text) {
        for (Colors color : Colors.values())
            System.out.println(color.getCode() + text);
    }
}