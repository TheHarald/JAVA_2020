package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        HashMapNew<Object, String> hMap = new HashMapNew<>();

        for (int i = 0; i < 30; i++) {
            hMap.add(randKeys(),randValues());
        }

        for (String s: hMap)
            System.out.println(s);

        System.out.println("=========================");

        for (String s: hMap)
            System.out.println(s);

    }

    public static int randKeys(){
        int key;
            key=(int)(Math.random()*2000);
            return key;
    }

    public static String randValues(){
        String value="";
            for (int j = 0; j < 6; j++) {
                value = value + randChar();
            }
            return value;
    }

    public static char randChar(){
        return (char)(97+(int)(Math.random()*27));
    }
}
