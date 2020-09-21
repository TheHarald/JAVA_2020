package com.company;

public class MovableRectangle extends Rectangle implements Movable{
    private MovablePoint topleft, bottomright;

    public MovableRectangle(double x1, double y1, double x2, double y2, double xSpeed, double ySpeed) {
        topleft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomright = new MovablePoint(x2, y2, xSpeed, ySpeed);
        super.setWidth(x2-x1);
        super.setLength(y2-y1);

    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topleft=" + topleft.toString() +
                ", bottomright=" + bottomright.toString() +
                '}';
    }



    public double getWidth() {

        return super.getWidth();
    }

    public void setWidth(double width) {

        bottomright.x=topleft.x+width;
        super.setWidth(width);
    }

    public double getLength() {
        return super.getLength();
    }

    public void setLength(double length) {
        bottomright.y=topleft.y+length;
        super.setLength(length);
    }


    @Override
    public void moveUp() {
        topleft.moveUp();
        bottomright.moveUp();
    }

    @Override
    public void moveDown() {
        topleft.moveDown();
        bottomright.moveDown();
    }

    @Override
    public void moveLeft() {
        topleft.moveLeft();
        bottomright.moveLeft();
    }

    @Override
    public void moveRight() {
        topleft.moveRight();
        bottomright.moveRight();
    }
}
