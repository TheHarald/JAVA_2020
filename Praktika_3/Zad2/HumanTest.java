package com.company.Zad2;

public class HumanTest {
    public static void main(String[] args) {
        Head head = new Head("Red",7.3,50.3);
        Leg leg = new Leg(50.34,35);
        Hand hand = new Hand(40.4,4.5);

        Human human = new Human(head,hand,leg);
        human.setName("Peter");


        human.getHead().Rotate();
        human.getLeg().Walk();
        human.getHand().Take();



    }
}
