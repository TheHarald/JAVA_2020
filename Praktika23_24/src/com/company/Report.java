package com.company;

public class Report {
    private int id,taskId;
    private String worker;
    private double result;

    public Report(int id, int taskId, String worker,double result ) {
        this.id = id;
        this.taskId = taskId;
        this.worker = worker;
        this.result = result;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getWorker() {
        return worker;
    }



    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", result=" + result +
                ", worker='" + worker + '\'' +
                '}';
    }
}
