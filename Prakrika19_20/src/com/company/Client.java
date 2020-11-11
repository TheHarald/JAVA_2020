package com.company;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Client {
    static DatagramSocket socket;

    static Scanner scanner = new Scanner(System.in);

    static {

        try {
            socket = new DatagramSocket(9087);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    static Runnable receiveThread = () -> {
        while (true) {
            try {
                receiveMessage();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    };


    static Runnable sendThread = () -> {

        String name = scanner.nextLine();
        String message;
        while(true){
            message = scanner.nextLine();
            try {
                sendMessage(name+" : "+message,"25.33.46.167",9087);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };




    public static void main(String[] args) throws InterruptedException {
        Thread send = new Thread(sendThread);
        Thread receive = new Thread(receiveThread);
        send.start();
        receive.start();
        send.join();
        receive.join();
    }


    public static void receiveMessage()throws IOException{
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        socket.receive(packet);
        String message = new String(buffer,0,packet.getLength());
        String time;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        time = dateFormat.format(date);

        message = time+" | "+message;
        System.out.println(message);


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("history.txt"), true)));
        writer.write(message+"\n");
        writer.close();

    }

    public static void sendMessage(
            String message,
            String address,
            int port) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        byte[] data = message.getBytes();

        DatagramPacket packet = new DatagramPacket(
                data,
                0, data.length,
                InetAddress.getByName(address),
                port
        );
        socket.send(packet);

    }
}