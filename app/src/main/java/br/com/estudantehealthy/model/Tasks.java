package br.com.estudantehealthy.model;

public class Tasks {

    private String name_task;
    private String date_task;
    private String task_description;

    public Tasks(String name_task, String date_task, String task_description) {
        this.name_task = name_task;
        this.date_task = date_task;
        this.task_description = task_description;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public String getDate_task() {
        return date_task;
    }

    public void setDate_task(String date_task) {
        this.date_task = date_task;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }
}
