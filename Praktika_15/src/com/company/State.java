package com.company;

public class State {
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
