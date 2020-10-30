package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Object currentState;

        State s1 = new State(1,2);
        State s2 = new State(4,6);
        State s3 = new State(6,2);
        State s4 = new State(3,5);
        State s5 = new State(5,3);

        s1.setPointers(s2,s5);
        s2.setPointers(s3,s4);
        s3.setPointers(s4,s5);
        s4.setPointers(s3,s5);
        s5.setPointers(s1,s3);

        Scanner scanner = new Scanner(System.in);
        currentState = s1;

        ArrayList<Integer> integers = new ArrayList<>();
        int temp;
        do {
            temp=scanner.nextInt();
            if(temp==-1)break;
            if(temp==1 || temp ==0)
            integers.add(temp);
        }while (true);

        for(Integer i:integers)
            currentState= ((State)currentState).working(i);

    }
}
