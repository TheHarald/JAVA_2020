package com.company;

public class Invoker {

    public void sum(Data data){
        int sum=0;
        for(Integer i:data.getNumbers())
            sum+=i;
        System.out.println(sum);
    }

    public void print(Data data){
        String result="";
        for( String s : data.getWords()){
            result+=s+data.getDelimeter();

        }
        System.out.println(result.replaceFirst(".$", ""));
    }

}
