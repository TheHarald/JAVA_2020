package com.company;

import java.util.ArrayList;

public class RightThradsCalc {

    static int totalSum;

    public  void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));

            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
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
            counter();
        }
        return a;
    }

    public static synchronized void counter() {
        totalSum++;
    }
}
