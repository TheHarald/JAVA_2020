package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Method> methods = Arrays.stream(invokerClass.getDeclaredMethods())
                .filter(a-> Arrays.stream(a.getAnnotations()).anyMatch(b -> b instanceof OperationType))
                .collect(Collectors.toList());


        for(Task task: tasks)
            getByAnnotationName(methods,task.getType()).invoke(invoker,task.getData());

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


    private static Method getByAnnotationName(List<Method> methods, String aName)
    {
        for(Method method : methods)
        {
            if(method.getAnnotation(OperationType.class).name().equals(aName))
            {
                return method;
            }
        }
        return null;
    }
}
