package com.company.Zad4;

public class Main {
    public static void main(String[] args) {

        Dog first= new Dog(5,"Rex");
        Dog second= new Dog(7,"Barsik");

        DogHouse home= new DogHouse();
        home.AddDog(first);
        home.AddDog(second);

        for(int i=0;i<2;i++) {
            System.out.print(home.mas[i].toString()+"\n");
        }

    }
}
