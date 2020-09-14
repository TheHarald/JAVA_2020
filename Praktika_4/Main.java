package com.company;

public class Main {

    public static void main(String[] args) {
        
        Circle krug = new Circle(3.2,"Red",false);
        Rectangle pram = new Rectangle(3.4,4.5,"Red",true);
        Square kvad = new Square(4,"Blue",true);

        System.out.print(krug.toString()+"\n"+ pram.toString()+"\n"+kvad.toString());
        
    }
}
