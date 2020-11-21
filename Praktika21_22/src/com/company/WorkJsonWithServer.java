package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.List;



public class WorkJsonWithServer implements ItemsStore {
    static Gson gson = new Gson();
    static HttpClient httpClient = HttpClient.newHttpClient();
    static String url = "http://80.87.199.76:3000/objects" ;



    @Override
    public List<Item> getAll() {
        Type collectionType = new TypeToken<Collection<Item>>() {}.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        List <Item> items = gson.fromJson(response.body(),collectionType);
        return items;
    }



    @Override
    public Item get(int id){

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url+"/"+id))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public Item addItem(Item item){
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response.body(),Item.class);

    }

    @Override
    public Item editItem(int id, Item item) {
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(item)))
                .uri(URI.create(url+"/"+id))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return get(item.getId());
    }
    @Override
    public void deleteItem(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(url+"/"+id))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

}
