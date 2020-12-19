package com.company;

public class Invoker {

    @OperationType(name = "sum")
    public void sum(Data data){
        int sum=0;
        for(Integer i:data.getNumbers())
            sum+=i;
        System.out.println(sum);
    }

    @OperationType(name = "print")
    public void print(Data data){
        StringBuilder result= new StringBuilder();
        for( String s : data.getWords()){
            result.append(s).append(data.getDelimeter());

        }
        System.out.println(result.toString().replaceFirst(".$", ""));
    }

}
