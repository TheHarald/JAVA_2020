package com.company.Zad4;



public class DogHouse {
    private int id=0;

  Dog[] mas = new Dog[3];

   void AddDog(Dog temp){
       mas[id]=temp;
       id++;
   }





    public void setMas(Dog[] mas) {
        this.mas = mas;
    }
}
