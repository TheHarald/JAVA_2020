package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkJsonWithServer {
    static private final Gson gson = new Gson();
    static private final HttpClient httpClient = HttpClient.newHttpClient();
    static private final String urlTasks = "http://80.87.199.76:3000/tasks";
    static private final String urlReports = "http://80.87.199.76:3000/reports";
    static private List<Task> tasks;
    static private List<Report> reports= new ArrayList<>();
    static private final String name = "Surinov";
    static private final String path = "src/com/company/db.json";
    static File file = new File(path);

    public WorkJsonWithServer() {
        reports=getFromFile();
    }

    public void start(){
        while (true){
            getFromServer();
            calc();
            try {
                Thread.sleep((int)(Math.random()*1000+1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Report> getFromFile() {
        Type type = new TypeToken<ArrayList<Report>>(){}.getType();
        List<Report> items = null;
        try(FileReader fr = new FileReader(file)) {
            items = gson.fromJson(fr,type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    private void getFromServer(){
        Type collectionType = new TypeToken<Collection<Task>>() {}.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlTasks))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        tasks = gson.fromJson(response.body(),collectionType);
    }

    private double solveMath(String task)
    {
        double answer = 0;
        task=task.replace(" ","");
        Pattern pattern = Pattern.compile("([-]*\\d+)([*+/-])([-]*\\d+)");
        Matcher matcher = pattern.matcher(task);
        if (matcher.find()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(3));
            String symbol = matcher.group(2);
            if (symbol.contains("+"))
                answer = a + b;
            else if (symbol.contains("-"))
                answer = a - b;
            else if (symbol.contains("*"))
                answer = a * b;
            else if (symbol.contains("/"))
                answer = (double) a / (double)b;
        }
            answer = Math.ceil(answer * 100) / 100;
            return answer;
    }

    private void calc(){
        double res = 0;
        Report tempReport;
        for(Task task:tasks){
            if(checkTask(task)) {
                res = solveMath(task.getExpression());
                tempReport = new Report(0, task.getId(), name, res);
                reports.add(tempReport);
                addInFile(tempReport);
                postReport(tempReport);
                System.out.println("Новый репорт: "+tempReport.toString());
            }
        }
    }

    private void addInFile(Report report) {
        StringBuilder sb = new StringBuilder();
        String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                while (!line.equals("]") && line != null) {
                    sb.append(line);
                    if (line.endsWith("}"))
                        sb.append(",");
                    sb.append("\n");
                    line = reader.readLine();
                }
                sb.append(gson.toJson(report));
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.write(sb.toString() + "\n]");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private boolean checkTask(Task task){
        for (Report report:reports){
            if(report.getTaskId() == task.getId()){
                return false;
            }
        }
        return true;
    }


    private void postReport(Report report){
            String body = gson.toJson(report);
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .uri(URI.create(urlReports))
                    .setHeader("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = null;
            try {
                response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
    }
}
