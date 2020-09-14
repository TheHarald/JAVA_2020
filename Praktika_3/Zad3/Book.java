package com.company.Zad3;

public class Book {
    private String Author,name;
    private int year,pages;

    public Book(String author, String name, int year, int pages) {
        Author = author;
        this.name = name;
        this.year = year;
        this.pages = pages;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
