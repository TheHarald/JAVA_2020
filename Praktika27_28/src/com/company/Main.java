package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static String url = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    static HttpClient httpClient = HttpClient.newBuilder().build();
    private static Gson gson = new Gson();
    private static ArrayList<Task> tasks;
    private static Type taskType = new TypeToken<ArrayList<Task>>(){}.getType();
    public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Invoker invoker = new Invoker();
        Class<Invoker> invokerClass= Invoker.class;
        getTasks();

        for(Task task: tasks)
            invokerClass.getDeclaredMethod(task.getType(), Data.class).invoke(invoker,task.getData());

    }


    private static void getTasks() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        tasks = gson.fromJson(response.body(),taskType);
    }
}
