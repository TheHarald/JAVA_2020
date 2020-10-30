package com.company;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Object currentState;

        ArrayList<State> states = new ArrayList<>();

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

        states.add(s1);
        states.add(s2);
        states.add(s3);
        states.add(s4);
        states.add(s5);

        Scanner scanner = new Scanner(System.in);
        currentState = s1;

        ArrayList<Integer> integers = new ArrayList<>();
        int temp;
        do {
            temp=scanner.nextInt();
            if(temp==-1)break;
            integers.add(temp);
        }while (temp!=-1);

        for(Integer i:integers)
            currentState= ((State) currentState).working(i);

    }
}
