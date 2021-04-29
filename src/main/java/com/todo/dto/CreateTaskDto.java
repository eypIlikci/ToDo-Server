package com.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo.entity.Task;

import java.text.SimpleDateFormat;

public class CreateTaskDto {
    private String title;
    private String content;
    private boolean status;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm")
    private String startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm")
    private String dueDate;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Task cloneTask()  {
        Task task=new Task();
        task.setContent(this.content);
        task.setTitle(this.title);
        task.setStatus(this.status);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            task.setStartDate(sdf.parse(this.startDate));
            task.setDueDate(sdf.parse(this.dueDate));
        }catch (Exception e){
        }
        return task;
    }

}
