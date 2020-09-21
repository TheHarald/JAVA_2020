package com.company;

public class MovableCircle  implements Movable{

    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed,int radius) {
        this.center= new MovablePoint(x,y,ySpeed,xSpeed);
        this.radius = radius;

    }

    @Override
    public void moveUp() {
        (center.y)+= center.ySpeed;
    }

    @Override
    public void moveDown() {
        (center.y)-= center.ySpeed;
    }

    @Override
    public void moveLeft() {
        (center.x)-= center.xSpeed;
    }

    @Override
    public void moveRight() {
        (center.x)+= center.xSpeed;
    }


}
