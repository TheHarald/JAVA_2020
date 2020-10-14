package com.company.Dop;

import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> totalSums= new ArrayList<>();


    public static void main(String[] args) throws InterruptedException{

        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i <  4; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            totalSums.add(0);
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " +totalSum(totalSums) );
    }
    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000,i);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private  static long doHardWork(int start, int count,int index) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            totalSums.set(index, totalSums.get(index)+1);
        }
        return a;
    }

    public static int totalSum(ArrayList<Integer> arrayList){
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            temp = temp + arrayList.get(i);
        }
        return temp;
    }
}

