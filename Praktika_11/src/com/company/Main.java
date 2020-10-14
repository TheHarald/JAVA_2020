package com.company;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Создать метод, который будет выполнять некую сложную логику,
        // например – множество математических операций.
        new SimpleCalc().start();
        System.out.println();

        //Выполнить этот метод в 10-и отдельных потоках
        new ThreadsCalc().start();
        System.out.println();

        //Пронаблюдать, что общий ресурс может неверно обрабатываться несколькими потоками.
        new SimpleThreadsCalc().start();
        System.out.println();


        //Применить один из трех способов решения ситуации гонки ресурсов
        new RightThradsCalc().start();

    }
}


