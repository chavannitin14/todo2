package com.tintin.todo2.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
    private @Id @GeneratedValue Long taskId;
    private Long userId;
    private String title;
    private String description;
    private Date dueDate;
    private Date reminderDate;
    private boolean reminder;
    
    public Task() {
    }

    public Task( String title, String description, Date dueDate, Date reminderDate, boolean reminder) {
        
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.reminder = reminder;
    }

    public Task(Long taskId, Long userId, String title, String description, Date dueDate, Date reminderDate,
            boolean reminder) {
        this.taskId = taskId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
        this.reminder = reminder;
    }

    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getReminderDate() {
        return reminderDate;
    }
    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }
    public boolean isReminder() {
        return reminder;
    }
    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }
    
}
