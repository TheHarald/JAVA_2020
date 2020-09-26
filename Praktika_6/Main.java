package com.company;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        //field.OutField();
        field.playAlt();
        System.out.println();
        //field.OutField();
        System.out.println("The sum is "+field.getField()[field.getFieldSize()-1][field.getFieldSize()-1]);
    }
}

