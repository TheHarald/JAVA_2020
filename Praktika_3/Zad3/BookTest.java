package com.company.Zad3;

public class BookTest {
    public static void main(String[] args) {
        Book kniga = new Book("Alexander Sergeevich Pushkin","Talles",1734,34);
        System.out.println(kniga.getAuthor()+"\n"+kniga.getName()+"\nPages "+kniga.getPages()+"\nYear of book "+kniga.getYear());
    }
}
