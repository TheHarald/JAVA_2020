package com.company;

import java.util.Scanner;


public class Field {
    private int fieldSize;
    private  int field[][];
    public int[][] getField() {
        return field;
    }
    public int getFieldSize() {
        return fieldSize;
    }
    private int x,y;

    public void playAlt(){
        this.x=0;
        this.y=0;
        this.field[y][x]=field[y][x];

        x++;
        for(int j=x;j<fieldSize;j++){
            field[0][j]=field[0][j-1]+field[0][j];
        }
        y++;
        for (int j = y; j<fieldSize; j++) {
            field[j][0]=field[j-1][0]+field[j][0];
        }

        for(int i =1;i<fieldSize;i++){

            if(field[y][x-1]>field[y-1][x])
                field[y][x]=field[y][x]+field[y][x-1];
            else
                field[y][x]=field[y][x]+field[y-1][x];

            x++;
            for(int j=x;j<fieldSize;j++){

                if(field[i][j-1]>field[i-1][j])
                    field[i][j]=field[i][j]+field[i][j-1];
                else
                    field[i][j]=field[i][j]+field[i-1][j];
            }

            y++;
            for (int j = y; j<fieldSize; j++) {
                if(field[j][i-1]>field[j-1][i])
                    field[j][i]=field[j][i]+field[j][i-1];
                else
                    field[j][i]=field[j][i]+field[j-1][i];
            }
        }
    }

    public Field() {
        Scanner scanner = new Scanner(System.in);
        this.fieldSize = scanner.nextInt();
        field = new int[fieldSize][fieldSize];
        for (int i=0; i<fieldSize;i++){
            for (int j=0; j<fieldSize;j++){
                field[i][j]=(int)(Math.random()*10);

            }
        }


    }
    public void OutField(){
        for (int i=0; i<fieldSize;i++){
            for (int j=0; j<fieldSize;j++) {

                System.out.printf("%5d",field[i][j]);
            }
            System.out.print("\n");
        }
    }
}





