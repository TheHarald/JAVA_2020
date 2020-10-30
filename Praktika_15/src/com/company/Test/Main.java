package com.company.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class State {
        private Object pointer0;
        private Object pointer1;
        private final int action1,action2;

        private static final String[] actions = new String[6];


        public State(int a,int b) {
            actions[0]="create_project";
            actions[1]="add_library";
            actions[2]="restart";
            actions[3]="test";
            actions[4]="deploy";
            actions[5]="drop_db";
            action1=a;
            action2=b;

        }

        public void setPointers(Object o1,Object o2){
            this.pointer0 = o1;
            this.pointer1 = o2;
        }


        public Object working(int action){
            if(action==0){
                System.out.println(actions[action1-1]);
                return pointer0;
            }
            if(action==1){
                System.out.println(actions[action2-1]);
                return pointer1;
            }
            return null;
        }

    }


    public static void main(String[] args) {



        Object currentState;

        ArrayList<State> states = new ArrayList<>();

        State s1 = new State(1, 2);
        State s2 = new State(4, 6);
        State s3 = new State(6, 2);
        State s4 = new State(3, 5);
        State s5 = new State(5, 3);

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
            if(temp==1 || temp ==0)
            integers.add(temp);
        }while (true);

        for(Integer i:integers)
            currentState= ((State)currentState).working(i);

    }
}
