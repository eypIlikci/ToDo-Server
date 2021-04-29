package com.todo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo.entity.Task;
import com.todo.util.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TaskDto {
    private Long id;
    private String title;
    private String content;
    private boolean status;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm",timezone = "CET")
    private String startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm",timezone = "CET")
    private String dueDate;

    public Long getId() {
        return id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean getStatus() {
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

    public Task cloneTask(){
        Task task=new Task();
        task.setId(id);
        task.setContent(this.content);
        task.setTitle(this.title);
        task.setStatus(this.status);
        return task;
    }

    public static TaskDto taskConvertToTaskDto(Task task){
         TaskDto taskDto=new TaskDto();
         taskDto.setId(task.getId());
         taskDto.setContent(task.getContent());
         taskDto.setTitle(task.getTitle());
         taskDto.setStatus(task.getStatus());
         if(task.getStartDate()!=null)taskDto.setStartDate(DateFormat.getFormat().format(task.getStartDate()));
         if(task.getDueDate()!=null)taskDto.setDueDate(DateFormat.getFormat().format(task.getDueDate()));
        return taskDto;
    }
}
