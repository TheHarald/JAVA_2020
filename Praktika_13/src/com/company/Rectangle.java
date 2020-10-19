package com.company;

public class Rectangle {
    private int width,length;
    private String name;

    public String getColor() {
        return name;
    }

    public void setName(String name) throws IncorrectNameException {
        if(name.length()!=4){
            throw new IncorrectNameException();
        }
        this.name = name;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) throws IncorrectSideException {
        if(width<0)
            throw new IncorrectSideException();
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) throws Exception{
        if (length<0)
            throw new Exception();
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", name='" + name + '\'' +
                '}';
    }


}
