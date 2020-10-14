package com.company;


public class SimpleCalc {


    public  void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();


        for (int i = 0; i < 10; i++) {
            work(i);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));

    }

    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 10_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);

        }
        return a;
    }

}
