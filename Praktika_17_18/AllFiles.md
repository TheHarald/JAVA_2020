###### C:\Users\Рома\IdeaProjects\Praktika6upd\src\com\company/Field.java
```java
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





```
###### C:\Users\Рома\IdeaProjects\Praktika6upd\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();
        //field.OutField();
        field.playAlt();
        System.out.println();
        //field.OutField();
        System.out.println("The sum is "+field.getField()[field.getFieldSize()-1][field.getFieldSize()-1]);
    }
}

```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/Company.java
```java
package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Company {

    private List <Employee> staff = new ArrayList<>();
    private double income=0;


    public void hire(Employee employee){
        staff.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        for(Employee employee :employeeList){
            hire(employee);
        }
    }

    public Employee search(String name, String surname){

        for(Employee employee: this.staff){
            if(employee.getName().equals(name) && employee.getSurname().equals(surname)){
                return employee;
            }
        }
        return null;
    }


    public List<Employee> getStaff() {
        return staff;
    }

    public void fire(String name, String surname){
        staff.remove(search(name,surname));
    }

    public void fire(int index){
        staff.remove(index);
    }




    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void sortStaff(){
        staff.sort(Comparator.comparing(Employee::getFinalSalary).reversed());
        
    }


    List<Employee> getTopSalaryStaff(int count){
        if(count>0 && staff.size()>count){

            this.sortStaff();
            return staff.subList(0,count);
        }
        else
            return null;

    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count>0 && staff.size()>count){

            this.sortStaff();
            return staff.subList(staff.size()-count,staff.size());
        }
        else
            return null;
    }

    public void outList(){
        for(Employee employee: staff){
            System.out.print(employee.getName()+" " +employee.getSurname()+" "+
                    employee.getEmployeePosition().getJobTitle() +" ");
            System.out.print((int)employee.getEmployeePosition().calcSalary(employee.getSalary())+" руб.");
            System.out.println();
        }
    }

    public void outList(List<Employee> list){
        for(Employee employee: list){
            System.out.print(employee.getName()+" " +employee.getSurname()+" "+
                    employee.getEmployeePosition().getJobTitle() +" ");
            System.out.print((int)employee.getEmployeePosition().calcSalary(employee.getSalary())+" руб.");
            System.out.println();
        }
    }


    public void calcIncome(){
        for(Employee employee: staff){
            if(employee.getEmployeePosition().getJobTitle().equals("Manager")) {
                income+=(employee.getFinalSalary()-employee.getSalary())*20-employee.getFinalSalary();
            }
            if(employee.getEmployeePosition().getJobTitle().equals("Operator")){
                income-=employee.getFinalSalary();
            }
            if(employee.getEmployeePosition().getJobTitle().equals("TopManager")){
                income-=employee.getFinalSalary();
            }
        }
    }




}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/Employee.java
```java
package com.company;

public class Employee {
    private String surname,name;
    private double salary;
    private double finalSalary;

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    private EmployeePosition employeePosition;

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public Employee(String surname, String name, double salary, EmployeePosition employeePosition) {
        this.surname = surname;
        this.name = name;
        this.salary = salary;
        this.employeePosition = employeePosition;
        this.finalSalary=employeePosition.calcSalary(salary);

    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/EmployeePosition.java
```java
package com.company;

public interface EmployeePosition {
    String getJobTitle();
    double calcSalary(double baseSalary);


}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i <1800 ; i++) {
            company.hire(new Employee("Operator"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+1000,new Operator()));
        }

        for (int i = 0; i <800 ; i++) {
            company.hire(new Employee("Manager"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+5000,new Manager()));
        }

        for (int i = 0; i <80 ; i++) {
            company.hire(new Employee("TopManager"+Integer.toString(i),"Ded" +Integer.toString(i),
                    Math.random()*10000+20000,new TopManager(company)));
        }

        company.sortStaff();
        //company.outList();
        company.calcIncome();
        System.out.println();
        company.outList(company.getTopSalaryStaff(10));
        System.out.println();
        company.outList(company.getLowestSalaryStaff(30));
        for (int i = 0; i<company.getStaff().size()/2; i++) {
            company.fire((int)Math.random()*10);
        }

        System.out.println("\n//////////////////////////////\n");
        company.outList(company.getTopSalaryStaff(10));
        System.out.println();
        company.outList(company.getLowestSalaryStaff(30));

        System.out.println(company.getIncome());





    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/Manager.java
```java
package com.company;

public class Manager implements EmployeePosition {


    public Manager() {

    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {

        return baseSalary+0.05*((Math.random()*25000)+115000);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/Operator.java
```java
package com.company;

public class Operator implements EmployeePosition {
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika7_8\src\com\company/TopManager.java
```java
package com.company;

public class TopManager implements EmployeePosition{

    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome()>10000000)
            return baseSalary*2.5;
        else
            return baseSalary;

    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_10\src\com\company/Main.java
```java
package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            Window window = new Window();

        });
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_10\src\com\company/Window.java
```java
package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Window extends JFrame {

    static class ImagePanel extends JComponent {
        private Image image;
        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }



    private JTextField textField1;
    private JTextField textField2;
    private JLabel label;
    private JLabel label2;
    private JTextField result;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;


    public Window() {
        try {
            BufferedImage myImage = ImageIO.read(new File("res/img.png"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }


        setTitle("Calc");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        addFields();
        setResizable(false);


        setListener(button3, '+');
        setListener(button4, '-');
        setListener(button5, '*');
        setListener(button6, ':');


    }

    private void setListener(JButton btn, char smb) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp=0, temp2 = 0;
                playSound();
                try {
                    temp = Double.parseDouble(textField1.getText());
                    temp2 = Double.parseDouble(textField2.getText());
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Вы ввели неверные значения.");
                    return;
                }
                result.setText(calc(temp, temp2, smb));
            }
        });
    }


    private String calc(double a, double b, char c) {
        double result = 0;
        switch (c) {
            case '+':
                result = a + b;
                break;

            case '-':
                result = a - b;
                break;

            case '*':
                result = a * b;
                break;
            case ':':
                try {
                    result = a / b;
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Деление на ноль");
                    result = 0;
                    break;
                }

        }

        return String.format("%.4f", result);
    }

    private void addFields() {
        textField1 = new JTextField();
        textField2 = new JTextField();
        label = new JLabel("Число 1");
        label2 = new JLabel("Число 2");
        result = new JTextField();
        button3 = new JButton("+");
        button4 = new JButton("-");
        button5 = new JButton("*");
        button6 = new JButton(":");
        int x=50,y=10;

        label.setBounds(x+10, y+10, 50, 25);
        label.setForeground(Color.WHITE);

        textField1.setBounds(x+60, y+10, 100, 25);

        label2.setBounds(x+170, y+10, 50, 25);
        label2.setForeground(Color.WHITE);
        textField2.setBounds(x+220, y+10, 100, 25);
        add(label);
        add(textField1);
        add(label2);
        add(textField2);
        button3.setBounds(x+70, y+55, 50, 50);
        button4.setBounds(x+130, y+55, 50, 50);
        button5.setBounds(x+190, y+55, 50, 50);
        button6.setBounds(x+250, y+55, 50, 50);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        result.setBounds(x+100, y+120, 150, 25);
        add(result);
    }


    public static void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res/sound.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/Dop/Main.java
```java
package com.company.Dop;

import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> totalSums= new ArrayList<>();


    public static void main(String[] args) throws InterruptedException{

        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i <  4; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            totalSums.add(0);
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " +totalSum(totalSums) );
    }
    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000,i);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private  static long doHardWork(int start, int count,int index) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            totalSums.set(index, totalSums.get(index)+1);
        }
        return a;
    }

    public static int totalSum(ArrayList<Integer> arrayList){
        int temp = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            temp = temp + arrayList.get(i);
        }
        return temp;
    }
}

```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/Main.java
```java
package com.company;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Создать метод, который будет выполнять некую сложную логику,
        // например – множество математических операций.
        new SimpleCalc().start();
        System.out.println();

        //Выполнить этот метод в 10-и отдельных потоках
        new ThreadsCalc().start();
        System.out.println();

        //Пронаблюдать, что общий ресурс может неверно обрабатываться несколькими потоками.
        new SimpleThreadsCalc().start();
        System.out.println();


        //Применить один из трех способов решения ситуации гонки ресурсов
        new RightThradsCalc().start();

    }
}


```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/RightThradsCalc.java
```java
package com.company;

import java.util.ArrayList;

public class RightThradsCalc {

    static int totalSum;

    public  void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));

            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 10_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            counter();
        }
        return a;
    }

    public static synchronized void counter() {
        totalSum++;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/SimpleCalc.java
```java
package com.company;


public class SimpleCalc {


    public  void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();


        for (int i = 0; i < 10; i++) {
            work(i);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));

    }

    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 10_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);

        }
        return a;
    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/SimpleThreadsCalc.java
```java
package com.company;

import java.util.ArrayList;

public class SimpleThreadsCalc {

    static int totalSum;

    public  void start() throws InterruptedException {

        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));

            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i) {

        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 10_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime - startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            counter();
        }
        return a;
    }

    public static void counter() {
        totalSum++;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_11\src\com\company/ThreadsCalc.java
```java
package com.company;

import java.util.ArrayList;

public class ThreadsCalc {

        public  void start() throws InterruptedException {

            long startTime = System.currentTimeMillis();
            ArrayList<Thread> threads = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                final int localI = i;
                Thread thread = new Thread(() -> work(localI));

                thread.start();
                threads.add(thread);
            }

            for (Thread t : threads) {
                t.join();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("total time: " + (endTime - startTime));

        }

        private static void work(int i) {

            long startTime = System.currentTimeMillis();
            long result = doHardWork(i * 1000, 10_000_000);
            long endTime = System.currentTimeMillis();
            System.out.println(i + ": " + result + " | " + (endTime - startTime));
        }

        private static long doHardWork(int start, int count) {
            long a = 0;
            for (int i = 0; i < count; i++) {
                a += (start + i) * (start + i) * Math.sqrt(start + i);

            }
            return a;
        }
    }


```
###### C:\Users\Рома\IdeaProjects\Praktika_12\src\com\company/Colors.java
```java
package com.company;

public enum Colors {
    DEFAULT("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN ( "\u001B[32m"),
    YELLOW ( "\u001B[33m"),
    BLUE ( "\u001B[34m"),
    MAGENTA ( "\u001B[35m"),
    CYAN ( "\u001B[36m"),
    WHITE ( "\u001B[37m"),
    BRIGHT_BLACk( "\u001B[90m"),
    BRIGHT_RED( "\u001B[91m"),
    BRIGHT_GREEN( "\u001B[92m"),
    BRIGHT_YELLOW( "\u001B[93m"),
    BRIGHT_BLUE( "\u001B[94m"),
    BRIGHT_MAGENTA( "\u001B[95m"),
    BRIGHT_CYAN( "\u001B[96m"),
    BRIGHT_WHITE( "\u001B[97m");

private final String code;

    public String getCode() {
        return code;
    }

    Colors(String code) {
        this.code = code;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_12\src\com\company/Main.java
```java
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        text = scanner.nextLine();
        print(text, Colors.BRIGHT_YELLOW);
        print(text);
        System.out.println();


    }

    public static void print(String text, Colors color) {
        System.out.println(color.getCode() + text);
    }

    public static void print(String text) {
        for (Colors color : Colors.values())
            System.out.println(color.getCode() + text);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_13\src\com\company/IncorrectNameException.java
```java
package com.company;

public class IncorrectNameException extends RuntimeException{
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_13\src\com\company/IncorrectSideException.java
```java
package com.company;

public class IncorrectSideException extends Exception {
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_13\src\com\company/Main.java
```java
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle= new Rectangle();
        Scanner scanner = new Scanner(System.in);

        rectangle.setName(scanner.next());
        try {
            rectangle.setWidth(scanner.nextInt());
            rectangle.setLength(scanner.nextInt());

        }
        catch (IncorrectSideException use){
            System.out.println("Некоррекные данные");
        }
        catch (Exception e){
            System.out.println("Некорректные данные");
        }
        finally {
            System.out.println(rectangle.toString());
        }


    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_13\src\com\company/Rectangle.java
```java
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
```
###### C:\Users\Рома\IdeaProjects\Praktika_14\src\com\company/Main.java
```java
package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {


         class Changer {

            private final String text;
            private int countRules;

            ArrayList<Rules> rules = new ArrayList<>();

            class Rules{
                String first,second;
                public Rules(String first, String second) {
                    this.first = first;
                    this.second = second;
                }
            }

            public Changer() {
                Scanner scanner = new Scanner(System.in);
                countRules = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < countRules; i++) {
                    rules.add(new Rules(scanner.next(),scanner.next()));
                }
                text = scanner.next();
            }


            public void withRegex() {
                String tempText = text;
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < rules.size(); i++) {
                    stringBuilder.append(rules.get(i).first);
                    if(i!= rules.size() -1)
                        stringBuilder.append("|");
                }

                HashMap<String, String> replaceMap = new HashMap<String, String>();

                for (int i = 0; i < rules.size(); i++)
                    replaceMap.put(rules.get(i).first,rules.get(i).second);


                Pattern pattern = Pattern.compile(stringBuilder.toString());
                Matcher matcher = pattern.matcher(tempText);
                tempText= matcher.replaceAll(x -> replaceMap.get(x.group()));
                System.out.println(tempText);
            }


            public void withoutRegex() {
                String tempText = text;
                for (int i = 0; i < tempText.length(); i++) {
                    for (int j = 0; j < rules.size(); j++) {
                        if (i + rules.get(j).first.length() <= tempText.length() &&
                                tempText.substring(i, i + rules.get(j).first.length()).equals(rules.get(j).first)) {
                            tempText = tempText.replace(rules.get(j).first,rules.get(j).second + " ");
                            i += rules.get(j).second.length();
                            break;
                        }
                    }
                }
                System.out.println(tempText.replaceAll(" ", ""));
            }
        }



        Changer changer = new Changer();
        changer.withRegex();
        //changer.withoutRegex();
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_15\src\com\company/Main.java
```java
package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Object currentState;

        State s1 = new State(1,2);
        State s2 = new State(4,6);
        State s3 = new State(6,2);
        State s4 = new State(3,5);
        State s5 = new State(5,3);

        s1.setPointers(s2,s5);
        s2.setPointers(s3,s4);
        s3.setPointers(s4,s5);
        s4.setPointers(s3,s5);
        s5.setPointers(s1,s3);

        Scanner scanner = new Scanner(System.in);
        currentState = s1;

        ArrayList<Integer> integers = new ArrayList<>();
        int temp;
        do {
            temp=scanner.nextInt();
            if(temp==-1)break;
            if(temp==1 || temp ==0)
            integers.add(temp);
        }while (true);

        for(Integer i:integers)
            currentState= ((State)currentState).working(i);

    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_15\src\com\company/State.java
```java
package com.company;

public class State {
    private Object pointer0;
    private Object pointer1;
    private final int action1,action2;

    private static final String[] actions = new String[6];


    public State(int a,int b) {
        actions[0]="create_project";
        actions[1]="add_library";
        actions[2]="restart";
        actions[3]="test";
        actions[4]="deploy";
        actions[5]="drop_db";
        action1=a;
        action2=b;

    }
    public void setPointers(Object o1,Object o2){
        this.pointer0 = o1;
        this.pointer1 = o2;
    }

    public Object working(int action){
        if(action==0){
            System.out.println(actions[action1-1]);
            return pointer0;
        }
        if(action==1){
            System.out.println(actions[action2-1]);
            return pointer1;
        }
        return null;
    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_15\src\com\company/Test/Main.java
```java
package com.company.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static class State {
        private Object pointer0;
        private Object pointer1;
        private final int action1,action2;

        private static final String[] actions = new String[6];


        public State(int a,int b) {
            actions[0]="create_project";
            actions[1]="add_library";
            actions[2]="restart";
            actions[3]="test";
            actions[4]="deploy";
            actions[5]="drop_db";
            action1=a;
            action2=b;

        }

        public void setPointers(Object o1,Object o2){
            this.pointer0 = o1;
            this.pointer1 = o2;
        }


        public Object working(int action){
            if(action==0){
                System.out.println(actions[action1-1]);
                return pointer0;
            }
            if(action==1){
                System.out.println(actions[action2-1]);
                return pointer1;
            }
            return null;
        }

    }


    public static void main(String[] args) {



        Object currentState;

        ArrayList<State> states = new ArrayList<>();

        State s1 = new State(1, 2);
        State s2 = new State(4, 6);
        State s3 = new State(6, 2);
        State s4 = new State(3, 5);
        State s5 = new State(5, 3);

        s1.setPointers(s2,s5);
        s2.setPointers(s3,s4);
        s3.setPointers(s4,s5);
        s4.setPointers(s3,s5);
        s5.setPointers(s1,s3);

        states.add(s1);
        states.add(s2);
        states.add(s3);
        states.add(s4);
        states.add(s5);

        Scanner scanner = new Scanner(System.in);
        currentState = s1;

        ArrayList<Integer> integers = new ArrayList<>();
        int temp;
        do {
            temp=scanner.nextInt();
            if(temp==-1)break;
            if(temp==1 || temp ==0)
            integers.add(temp);
        }while (true);

        for(Integer i:integers)
            currentState= ((State)currentState).working(i);

    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_17_18\src\com\company/Main.java
```java
package com.company;


import java.io.*;

public class Main {
    static PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter("AllFiles.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getFiles(String path){
        File file = new File(path);
        if(file.isDirectory()){
            String[] contents = file.list();
            for (String s:contents) {
                getFiles(path+"/"+s);
            }
        }
        if(file.isFile() ) {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    printWriter.write("###### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        printWriter.write(line + "\n");
                        line = reader.readLine();
                    }
                    printWriter.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {

        String basePath = "C:\\Users\\Рома\\IdeaProjects";
        File file = new File(basePath);

        String[] files = file.list();
        String[]  filePaths = new String[files.length];

        for (int i = 0; i <files.length ; i++) {
            filePaths[i]=basePath+"\\"+files[i]+"\\src\\com\\company";
            getFiles(filePaths[i]);
        }

        printWriter.close();
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_4\src\com\company/Circle.java
```java
package com.company;

public class Circle extends Shape{
    protected double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius=radius;
    }

    public Circle(double radius,String color, boolean filled ) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return 3.14*radius*radius;
    }

    @Override
    double getPerimeter() {
        return 2*3.14*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_4\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
        
        Circle krug = new Circle(3.2,"Red",false);
        Rectangle pram = new Rectangle(3.4,4.5,"Red",true);
        Square kvad = new Square(4,"Blue",true);

        System.out.print(krug.toString()+"\n"+ pram.toString()+"\n"+kvad.toString());
        
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_4\src\com\company/Rectangle.java
```java
package com.company;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
    }



    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length,String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return length*width;
    }

    @Override
    double getPerimeter() {
        return 2*(length+width);
    }

    @Override

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_4\src\com\company/Shape.java
```java
package com.company;

abstract public class Shape {
    protected String color;
    protected boolean filled;

    public Shape() { }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   public boolean isFilled(){
        return this.filled;
   }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();
    abstract double getPerimeter();
   // abstract String toString();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_4\src\com\company/Square.java
```java
package com.company;

public class Square extends Shape{
    protected double side;

    public Square() {
    }

    @Override
    double getArea() {
        return side*side;
    }

    @Override
    double getPerimeter() {
        return 4*side;
    }

    public Square(double side) {
        this.side=side;
    }

    public Square(double side, String color, boolean filled) {

        this.color=color;
        this.filled=filled;
        this.side=side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;

    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
        MovableCircle circle = new MovableCircle(3,6,2,2,5);
        //System.out.println(circle.center.toString());
            circle.moveDown();
        //System.out.println(circle.center.toString());

        MovableRectangle rectangle = new MovableRectangle(1,2,4,7,1,1);
        //System.out.println(rectangle.toString());
        rectangle.moveDown();
        rectangle.moveRight();


        System.out.println(rectangle.toString());
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());
        rectangle.setWidth(3.4);
        rectangle.setLength(1.2);

        System.out.println(rectangle.getWidth());

        System.out.println(rectangle.toString());

        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());

    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/Movable.java
```java
package com.company;

public interface Movable {
   public void moveUp();
   public void moveDown();
   public void moveLeft();
   public void moveRight();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/MovableCircle.java
```java
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
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/MovablePoint.java
```java
package com.company;

public class MovablePoint implements Movable {
    protected double x,y,xSpeed,ySpeed;

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }


    @Override
    public void moveUp() {
        y+=ySpeed;
    }

    @Override
    public void moveDown() {
        y-=ySpeed;
    }

    @Override
    public void moveLeft() {
        x-=xSpeed;
    }

    @Override
    public void moveRight() {
        x+=xSpeed;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/MovableRectangle.java
```java
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
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/Rectangle.java
```java
package com.company;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }



    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length,String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return length*width;
    }

    @Override
    double getPerimeter() {
        return 2*(length+width);
    }

    @Override

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_5\src\com\company/Shape.java
```java
package com.company;

abstract public class Shape {
    protected String color;
    protected boolean filled;

    public Shape() { }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   public boolean isFilled(){
        return this.filled;
   }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();
    abstract double getPerimeter();
   // abstract String toString();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
	MovableRectangle rectangle = new MovableRectangle(1,2,4,7,1,1);
        System.out.println(rectangle.toString());
        rectangle.moveDown();
        rectangle.moveRight();
        System.out.println(rectangle.toString());

    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/Movable.java
```java
package com.company;

public interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/MovableRectangle.java
```java
package com.company;
import com.company.Rectangle_Praktika_5.*;

public class MovableRectangle implements Movable {
    private MovablePoint topleft, bottomright;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topleft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomright = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topleft=" + topleft.toString() +
                ", bottomright=" + bottomright.toString() +
                '}';
    }

    public boolean isEqual() {
        if (topleft.getxSpeed() == bottomright.getxSpeed() &&
                        topleft.getySpeed() == bottomright.getySpeed()){
            return true;
        }
        else
            return false;
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
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/Rectangle_Praktika_5/MovablePoint.java
```java
package com.company.Rectangle_Praktika_5;

import com.company.Movable;

public class MovablePoint implements Movable {
    private int x,y,xSpeed,ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }


    @Override
    public void moveUp() {
        y+=ySpeed;
    }

    @Override
    public void moveDown() {
        y-=ySpeed;
    }

    @Override
    public void moveLeft() {
        x-=xSpeed;
    }

    @Override
    public void moveRight() {
        x+=xSpeed;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/Rectangle_Praktika_5/Rectangle.java
```java
package com.company.Rectangle_Praktika_5;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
    }



    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length,String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return length*width;
    }

    @Override
    double getPerimeter() {
        return 2*(length+width);
    }

    @Override

    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6\src\com\company/Rectangle_Praktika_5/Shape.java
```java
package com.company.Rectangle_Praktika_5;

abstract public class Shape {
    protected String color;
    protected boolean filled;

    public Shape() { }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   public boolean isFilled(){
        return this.filled;
   }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();
    abstract double getPerimeter();
   // abstract String toString();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_6New\src\com\company/Field.java
```java
package com.company;

import java.util.Scanner;



public class Field {
    private int fieldSize;
    private  int field[][];
    private int fieldTemp[][];
    private int path[][];
    int sum;
    public int[][] getFieldTemp() {
        return fieldTemp;
    }
    public int getFieldSize() {
        return fieldSize;
    }
    int x,y;
    public int sumStorka(int x,int y){
        int sum = 0;
        if(y>=fieldSize)
            return 0;

        for(int i=x;i<fieldSize;i++)
            sum+=field[y][i];

        return sum;
    }

    public int sumStolbec(int x,int y){
        int sum = 0;
        if(x>=fieldSize)
            return 0;

        for(int i=y;i<fieldSize;i++)
            sum+=field[i][x];

        return sum;
    }

    public void play(){
        this.x=0;
        this.y=0;
        this.sum=field[this.y][this.x];
        this.path[this.y][this.x]=1;


       for(int i =0;i<2*fieldSize-2;i++){
           if(sumStorka(this.x+1,this.y)+sumStolbec(this.x+1,this.y)>=sumStorka(this.x,this.y+1)+sumStolbec(this.x,this.y+1))
               (this.x)++;
           else
               (this.y)++;

           this.sum+=field[this.y][this.x];
           this.path[this.y][this.x]=1;
       }

    }

    public void playAlt(){
        this.x=0;
        this.y=0;
        this.sum=field[y][x];
        this.path[y][x]=1;
        this.fieldTemp[y][x]=field[y][x];

        x++;
        for(int j=x;j<fieldSize;j++){
            fieldTemp[0][j]=fieldTemp[0][j-1]+field[0][j];
        }
        y++;
        for (int j = y; j<fieldSize; j++) {
            fieldTemp[j][0]=fieldTemp[j-1][0]+field[j][0];
        }

        for(int i =1;i<fieldSize;i++){

            if(fieldTemp[y][x-1]>fieldTemp[y-1][x])
                fieldTemp[y][x]=field[y][x]+fieldTemp[y][x-1];
            else
                fieldTemp[y][x]=field[y][x]+fieldTemp[y-1][x];

            x++;
            for(int j=x;j<fieldSize;j++){

                if(fieldTemp[i][j-1]>fieldTemp[i-1][j])
                    fieldTemp[i][j]=field[i][j]+fieldTemp[i][j-1];
                else
                    fieldTemp[i][j]=field[i][j]+fieldTemp[i-1][j];
            }

            y++;
            for (int j = y; j<fieldSize; j++) {
                if(fieldTemp[j][i-1]>fieldTemp[j-1][i])
                    fieldTemp[j][i]=field[j][i]+fieldTemp[j][i-1];
                else
                    fieldTemp[j][i]=field[j][i]+fieldTemp[j-1][i];
            }
        }
    }



    public Field() {
        Scanner scanner = new Scanner(System.in);
        this.fieldSize = scanner.nextInt();
        field = new int[fieldSize][fieldSize];
        fieldTemp = new int[fieldSize][fieldSize];
        path = new int[fieldSize][fieldSize];
        for (int i=0; i<fieldSize;i++){
            for (int j=0; j<fieldSize;j++){
                field[i][j]=(int)(Math.random()*10);
                path[i][j]=0;
                fieldTemp[i][j]=0;

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


    public void OutFieldTemp(){
        for (int i=0; i<fieldSize;i++){
            for (int j=0; j<fieldSize;j++) {

                System.out.printf("%5d",fieldTemp[i][j]);
            }
            System.out.print("\n");
        }
    }




    public void OutPath(){
        for (int i=0; i<fieldSize;i++){
            for (int j=0; j<fieldSize;j++) {

                System.out.print(path[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}





```
###### C:\Users\Рома\IdeaProjects\Praktika_6New\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args) {
        Field field = new Field();

        /*field.play();
        System.out.println("Sum is "+field.sum);
        field.OutPath();*/



        field.playAlt();

        /*field.OutField();
        System.out.println();
        field.OutFieldTemp();*/

        System.out.println(field.getFieldTemp()[field.getFieldSize()-1][field.getFieldSize()-1]);





    }
}

```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad1/Cup.java
```java
package com.company.Zad1;

public class Cup extends Dish {
    private int fingersize;

    public Cup(String material, int size, int deepth, double capacity, int fingersize) {
        super(material, size, deepth, capacity);
        this.fingersize = fingersize;
    }

    @Override
    public void Fill(double capacity) {
        if(this.getCapacity()<=capacity)
            System.out.println("A cup cannot filled");
        else
            System.out.println("A cup filled and remaining space is " + (this.getCapacity() - capacity) );
    }

    @Override
    public int Break() {

        return (this.getSize()*5);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad1/Dish.java
```java
package com.company.Zad1;

abstract public class Dish {

    private String material;
    private int size;
    private int deepth;
    private double capacity;

    public Dish() {
    }

    public Dish(String material, int size, int deepth, double capacity) {
        this.material = material;
        this.size = size;
        this.deepth = deepth;
        this.capacity = capacity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDeepth() {
        return deepth;
    }

    public void setDeepth(int deepth) {
        this.deepth = deepth;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    abstract public void Fill(double capacity);
    abstract public int Break();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad1/Main.java
```java
package com.company.Zad1;

public class Main {
    public static void main(String[] args) {
        Cup cup = new Cup("Farfor",4,3,2.4,5);
        cup.Fill(2);
        Plane plane = new Plane("Farfor",7,2,3.1,"Round");
        plane.Fill(3.1);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad1/Plane.java
```java
package com.company.Zad1;

public class Plane extends Dish {
    private String form;

    public Plane(String form) {
        this.form = form;
    }

    public Plane( String form,int size, int deepth, double capacity, String material) {
        super(material, size, deepth, capacity);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public void Fill(double capacity) {
        if(this.getCapacity()<=capacity)
            System.out.println("A plane cannot filled");
        else
            System.out.println("A plane filled and remaining space is " + ((this.getCapacity()*2) - capacity) );
    }

    @Override
    public int Break() {
        return (this.getSize()*10);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad2/Dog.java
```java
package com.company.Zad2;

public abstract class Dog {
   private int age;
   private String color;
   private int size;

    public Dog() {
    }

    public Dog(int age, String color, int size) {
        this.age = age;
        this.color = color;
        this.size = size;
    }

    public void Walk(){
       System.out.println("I an walking");
   }

   public abstract void Tell();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad2/Korgi.java
```java
package com.company.Zad2;

public class Korgi extends Dog {

    public Korgi() {

    }

    public Korgi(int age, String color, int size) {
        super(age, color, size);
    }

    @Override
    public void Tell() {
        System.out.println("I am Korgi");
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad2/Labrador.java
```java
package com.company.Zad2;

public class Labrador extends Dog{

    public Labrador() {
    }

    public Labrador(int age, String color, int size) {
        super(age, color, size);
    }

    @Override
    public void Tell() {
        System.out.println("I am Labrador");
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad2/Main.java
```java
package com.company.Zad2;

public class Main {

    public static void main(String[] args) {
        Korgi korgi = new Korgi();
        Labrador labrador = new Labrador();
        korgi.Tell();
        labrador.Tell();
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Bed.java
```java
package com.company.Zad3;

public class Bed extends Furniture{

    private int capacity;

    public Bed() {

    }

    public Bed(int price, double weight, String material,int count, int capacity) {
        super(price, weight, material,count);
        this.capacity = capacity;
        super.setName("Bed");
    }

    @Override
    public String toString() {
        return
                super.toString()+
                ",\ncapacity=" + capacity ;
    }

    @Override
    public void getInfo() {
        System.out.println("Bed info:\n"+ this.toString());
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Chair.java
```java
package com.company.Zad3;

public class Chair extends Furniture {
    public Chair() {
    }

    public Chair(int price, double weight, String material,int count) {
        super(price, weight, material,count);
        super.setName("Chair");

    }

    @Override
    public void getInfo() {
        System.out.println("Chair info:\n"+ super.toString());
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Furniture.java
```java
package com.company.Zad3;

public abstract class Furniture {
    private int price;
    private double weight;
    private String material;
    private String name;
    private int count;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Furniture() {
    }

    public Furniture(int price, double weight, String material, int count) {
        this.price = price;
        this.weight = weight;
        this.material = material;
        this.count = count;
    }

    @Override
    public String toString() {
        return
                "price=" + price +
                ", \nweight=" + weight  +
                ", \nmaterial=" + material ;
    }

    public abstract void getInfo();

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/FurnitureShop.java
```java
package com.company.Zad3;
import java.util.Scanner;

public class FurnitureShop {
    Bed bed;
    Sofa sofa;
    Table table;
    Chair chair;

    public FurnitureShop(Bed bed, Sofa sofa, Table table, Chair chair) {
        this.bed = bed;
        this.sofa = sofa;
        this.table = table;
        this.chair = chair;
    }

    public Furniture Search(String name){
        switch (name){
            case ("bed")->{ return this.bed;}
            case ("table")->{ return this.table;}
            case ("sofa")->{ return this.sofa;}
            case ("chair")->{ return this.chair;}
            default->{ return null;}
        }
    }

   public boolean isInStock(String name,int count){

        if(Search(name).getCount()>=count && Search(name)!=null)
            return true;
        else {

            return false;
        }
    }

    public void Sell(String name,int count) {
        if (isInStock(name, count)){
            Search(name).setCount(Search(name).getCount()-count);
            System.out.println(count+" "+name+" is sold");
        }
        else
            System.out.println("This furnitura is not in stock");

    }

    public void WeHave()
    {
        System.out.println("We have:\n"+bed.getCount() + " Bed\n" + chair.getCount() + " Chair\n"
                + sofa.getCount() + " Sofa\n" + table.getCount() + " Table\nexit for left");
    }

    public void Start() {
        System.out.println("Welcome to our Shop.");
        WeHave();

        Scanner in = new Scanner(System.in);
        String name;
        int count;
        do {
            name = in.next();
            if (name.equals("exit")) {
                break;
            } else {
                count = in.nextInt();
                Sell(name, count);
            }
            WeHave();

        } while (!name.equals("exit"));


    }
}

```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Main.java
```java
package com.company.Zad3;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(3000,5.7,"Wood",3);
        //table.getInfo();
        Sofa sofa = new Sofa(10000,50,"Wood",1,4,"White");
       // sofa.getInfo();
        Bed bed = new Bed(10000,30,"Iron",2,2);
        Chair chair = new Chair(1000,1,"Wood",2);
       // bed.getInfo();

        FurnitureShop fs = new FurnitureShop(bed,sofa,table,chair);

        fs.Start();


    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Sofa.java
```java
package com.company.Zad3;

public class Sofa extends Furniture {

    private int capacity;
    private String color;

    public Sofa() {

    }

    public Sofa(int price, double weight, String material,int count, int capacity, String color) {
        super(price, weight, material,count);
        this.capacity = capacity;
        this.color = color;
        super.setName("Sofa");
    }

    @Override
    public String toString() {
        return
                super.toString()+
                ",\ncapacity=" + capacity +
                ", \ncolor='" + color ;
    }

    @Override
    public void getInfo() {
        System.out.println("Sofa info:\n"+ this.toString());
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_7\src\com\company/Zad3/Table.java
```java
package com.company.Zad3;

public class Table extends Furniture {

    public Table() {
    }

    public Table(int price, double weight, String material,int count) {
        super(price, weight, material,count);
        super.setName("Table");
    }

    @Override
    public void getInfo() {
        System.out.println("Table info:\n"+ super.toString());
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/Circle.java
```java
package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    public Circle(Color color, /*String colorName,*/ int x, int y) {
        super(color, /*colorName,*/ x, y);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(getxPosition(), getyPosition(), 40, 40);

        g2d.setColor(getColor());
        g2d.fill(circle);
    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/DynamicShapes.java
```java
package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DynamicShapes extends JPanel implements ActionListener {
    private final int delay = 100;
    private int current;
    private Timer timer;

    private List<Shape> shapes = new ArrayList<>();
    private Random random = new Random(System.currentTimeMillis());

    public DynamicShapes(String shape) {
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(400, 400));

        switch (shape) {
            case "Circle":
                // addCircle(Color.GRAY, 390, 390);
                addCircle(Color.GRAY, 0, 0);
                break;
            case "Square":
                // addSquare(Color.BLUE, 380, 380);
                addSquare(Color.BLUE, 0, 0);
                break;
            case "Ellipse":
                // addEllipse(Color.BLUE, 380, 380);
                addEllipse(Color.BLUE, 0, 0);
                break;
        }

        //startAnimation();
    }

    private void startAnimation() {
        if (timer == null) {
            current = 0;
            timer = new Timer(delay, this);
            timer.start();
        } else if (!timer.isRunning()) {
            timer.restart();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            getRootPane().setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            s.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            s.draw(g);
        }
    }

    public void addCircle(Color color, int maxX, int maxY) {
        shapes.add(new Circle(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()), maxX, maxY));
        repaint();
    }

    public void addSquare(Color color, int maxX, int maxY) {
        shapes.add(new Square(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()), maxX, maxY));
        repaint();
    }

    public void addEllipse(Color color, int maxX, int maxY) {
        shapes.add(new Ellipse(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()), maxX, maxY));
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/Ellipse.java
```java
package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Shape {
    public Ellipse(Color color, /*String colorName,*/ double xPosition, double yPosition) {
        super(color,/* colorName,*/ xPosition, yPosition);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Ellipse2D.Double ellipse = new Ellipse2D.Double(getxPosition(), getyPosition(), 30, 50);

        graphics2D.setColor(getColor());
        graphics2D.fill(ellipse);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/Main.java
```java
package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.spi.AudioFileReader;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        int amount = 20;

        String shapes[] = {"Square", "Circle", "Ellipse"};

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(4, 5));
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        for(int i = 0; i<amount; i++)
            frame.add(new DynamicShapes(shapes[(int) (Math.random()*3)]));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //playSound();
    }

    public static void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Resourses/kurabane2.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/Shape.java
```java
package com.company;

import java.awt.*;

public abstract class Shape {
    private Color color;
    // private String colorName;

    private double xPosition;
    private double yPosition;

    public Shape(Color color, /*String colorName,*/ double xPosition, double yPosition) {
        this.color = color;
        // this.colorName = colorName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public abstract void draw(Graphics g);

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_8\src\com\company/Square.java
```java
package com.company;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape {
    public Square(Color color, /*String colorName,*/ double xPosition, double yPosition) {
        super(color,/* colorName,*/ xPosition, yPosition);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(getxPosition(), getyPosition(), 60, 60);

        graphics2D.setColor(getColor());
        graphics2D.fill(rect);
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/Company.java
```java
package com.company;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> staff = new ArrayList<>();

    public void hire(Employee employee){
        staff.add(employee);
    }


    public void fire(int index){
        staff.remove(index);
    }

    public void outList(){
        for(Employee employee :staff){
            System.out.println(employee.toString());
        }
    }
    public void outList(Selector selector,Handler handler){
        int count=0;
        for(Employee employee :staff){
            if(selector.myBeHandled(employee)){
                handler.HandleEmployees(employee);
                System.out.println(employee.toString());
            }
        }
        count++;
    }

}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/Employee.java
```java
package com.company;

import java.time.LocalDate;

public class Employee {
    private String name,surname,address,number;
    private final LocalDate year;
    private double salary;

    public Employee(String name, String surname, String address, String number, LocalDate year, double salary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.year = year;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getYear() {
        return year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\n"+"Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", salary=" + salary +
                '}';
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/Handler.java
```java
package com.company;

public interface Handler {
    void HandleEmployees(Employee employee);
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/Main.java
```java
package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();


        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(
                    "Ivan"+Integer.toString(i),
                    "Ivanov",
                    Integer.toString(118232+i)+"Moscow",
                    "+0_000_000_00_00",
                    LocalDate.of(2001,3,12+i),
                    Math.random()*10000));
        }

        //company.outList();

        company.outList(new Selector() {
            @Override
            public boolean myBeHandled(Employee employee) {

                return employee.getSalary()<5_000;
            }
        },employee -> employee.getSalary());

        System.out.print("\n###################################################\n");
        company.outList(new SalarySelector(8000),employee -> employee.getSalary());


    }


}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/SalarySelector.java
```java
package com.company;

public class SalarySelector implements Selector{

    private double maxSalary;

    public SalarySelector(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean myBeHandled(Employee employee) {
        return this.maxSalary<employee.getSalary();
    }
}
```
###### C:\Users\Рома\IdeaProjects\Praktika_9\src\com\company/Selector.java
```java
package com.company;

public interface Selector {
    boolean myBeHandled(Employee employee);
}
```
###### C:\Users\Рома\IdeaProjects\Test\src\com\company/Main.java
```java
package com.company;

public class Main {

    public static void main(String[] args)
    {
        for(int i=0;i< args.length;i++)
            System.out.println(args[i]);
    }
}
```
###### C:\Users\Рома\IdeaProjects\test14\src\com\company/Main.java
```java
package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str;
        String[] oldRules;
        String[] newRules;
        int numRules;
        Scanner scanner = new Scanner(System.in);

        numRules = scanner.nextInt();
        oldRules = new String[numRules];
        newRules = new String[numRules];
        for (int i = 0; i < numRules; i++) {
            oldRules[i] = scanner.next();
            newRules[i] = scanner.next();
        }
        str = scanner.next();
        System.out.println("Замена без регулярных выражений\n" + replaceDefault(oldRules, newRules, str));
        System.out.println("Замена через регулярные выражения\n" + replaceRegex(oldRules, newRules, str));

    }

    public static String replaceDefault(String[] oldR, String[] newR, String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < oldR.length; j++) {
                if (i + oldR[j].length() < str.length() && str.substring(i, i + oldR[j].length()).equals(oldR[j])) {
                    str = str.replace(oldR[j], newR[j] + " ");
                    i += newR[j].length();
                    break;
                }
            }
        }
        str = str.replaceAll(" ", "");
        return str;
    }

    public static String replaceRegex(String[] oldR, String[] newR, String str) {
        Pattern pattern;
        Matcher matchers;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < oldR.length; j++) {
                if (i + oldR[j].length() < str.length()) {
                    pattern = Pattern.compile(oldR[j]);
                    matchers = pattern.matcher(str.substring(i, i + oldR[j].length()));
                    if (matchers.find()) {
                        str = str.substring(0, i) + matchers.replaceFirst(newR[j] + " ") + str.substring(i + oldR[j].length());
                        i += newR[j].length();
                        break;
                    }
                }
            }
        }
        pattern = Pattern.compile(" ");
        matchers = pattern.matcher(str);
        str = matchers.replaceAll("");
        return str;
    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/Circle.java
```java
package com.company;

import java.awt.*;

public class Circle extends Shape{


    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, width, height);
    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/DrawingPanel.java
```java
package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    List<Shape> shapes = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape: shapes) {
            shape.draw(g);
        }
    }
    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/Main.java
```java
package com.company;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();
    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/Rectangle.java
```java
package com.company;
import java.awt.*;

public class Rectangle extends Shape{

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.fill3DRect(x,y,width,height,true);

    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/Shape.java
```java
package com.company;

import java.awt.*;

public abstract class Shape{
    int x, y, width, height;

    public Shape(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public abstract void draw(Graphics g);
}
```
###### C:\Users\Рома\IdeaProjects\untitled\src\com\company/Window.java
```java
package com.company;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Window {

    private final DrawingPanel panel = new DrawingPanel();

    public Window() {
        JFrame frame = new JFrame();
        frame.add(panel);
        JButton button = new JButton("Add Circle");
        frame.add(button, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 10; i++) {
                    int temp = (int)(Math.random()*500);
                    panel.addShape(new Circle(i*50+temp,i*2,i*3,i*3));
                    panel.addShape(new Rectangle(temp+200,temp-30,100,temp/4));
                }
            }
        });
    }








}
```
###### C:\Users\Рома\IdeaProjects\untitled1\src\com\company/Main.java
```java
package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int val = rand.nextInt(20);
        Window w = new Window();
        w.setVal(val);
    }
}
```
###### C:\Users\Рома\IdeaProjects\untitled1\src\com\company/Window.java
```java
package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Window extends JFrame {
    int val;

    public void setVal(int val) {
        this.val = val;
    }

    Window() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label1 = new JLabel("Ваш ответ");
        JLabel label2 = new JLabel("Результат");

        JTextField text = new JTextField();
        JTextField message = new JTextField();

        JButton button = new JButton("Ответить");

        label1.setBounds(100, 100, 50, 25);
        label2.setBounds(200, 100, 50, 25);
        text.setBounds(100, 150, 100, 25);
        message.setBounds(200, 150, 100, 25);
        button.setBounds(200, 300, 50, 50);

        add(label1);
        add(label2);
        add(text);
        add(message);
        add(button);
    }
    private void setListener(JButton button, JTextField text, JTextField message) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int temp = Integer.parseInt(text.getText());
                    String msg = game(temp);
                    message.setText(msg);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "wrong value");
                    return;
                }

            }
        });
    }
    private String game(int x) {
        if (val == x) {
            return "guessed";
        }
        else if (val > x) {
            return "more";
        }
        else {
            return "less";
        }
    }
}
```
###### C:\Users\Рома\IdeaProjects\VichMAt\src\com\company/Main.java
```java
package com.company;



public class Main {

    public static void main(String[] args) {
       fxNuton(2.926);
    }

    public static double fX(double xn) {

        return 1.5 * (Math.pow(xn, 3) + 3.54 * Math.pow(xn, 2) - xn - 3.54);
    }

    public static double fshX(double xn) {

        return 6 * Math.pow(xn, 2) + 17.72 * xn - 2;
    }

    public static void sekush() {
        double xn = 0, x = -1, a = -1.0031, b = -0.5;
        xn = a;

            System.out.print("xn" + " = ");
            System.out.printf("%.4f", xn);
            System.out.print(" - ");
            System.out.printf("%.4f",fX(xn));

            System.out.print(" * ");
            System.out.printf("%.4f",(b - a) / (fX(b) - fX(a)));
            System.out.print(" xn"+" = ");
            xn = xn - fX(xn) * (b - a) / (fX(b) - fX(a));
            System.out.printf("%.4f", xn);
            System.out.println();




    }

    public static void iteracia() {
        double xn = 0, x = -4.43, a = -5.43, b = -3;

        xn = a;

        for (int i = 0; i < 7; i++) {

            System.out.print("x" + (i + 1) + " = ");
            System.out.printf("%.3f", xn);
            System.out.print(" - ");
            System.out.printf("%.3f",fX(xn));

            System.out.print(" * ");
            System.out.printf("%.3f",(b - a) / (fX(b) - fX(a)));
            System.out.print(" x"+(i+1)+" = ");
            xn = xn - fX(xn) * (b - a) / (fX(b) - fX(a));
            System.out.printf("%.3f", xn);
            System.out.println();
        }



    }

    public static void nuton() {
        double xn = 0, x = 1, a = 0.1, b = 2;
        xn = b;
        for (int i = 0; i < 20; i++) {

            System.out.print("x" + (i + 1) + " = ");
            System.out.printf("%.3f", xn);
            System.out.print(" - ");
            System.out.printf("%.3f", fX(xn));
            System.out.print(" / ");
            System.out.printf("%.3f", fshX(xn));
            xn = xn - fX(xn) / fshX(xn);
            System.out.print("  x" + (i + 1) + "= ");
            System.out.printf("%.3f", xn);
            System.out.println();
        }
    }

    public static void fxNuton(double ...args){
        for (int i = 0; i < args.length; i++) {

            //args[i]=2.25+1.75*args[i];

            System.out.println((args[i]+1.8)/(args[i]*args[i]+args[i]+2.8));
        }
    }


    public static void gauss(int n){
        int a,b;

        for (int i = 0; i < n; i++) {

        }


    }
}
```
