package com.Criss75.user;

public class Todo {
    private int userId;
    private int todoId;
    private String title;
    private boolean isComplete;
    private String active;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        this.isComplete = complete;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", todoId=" + todoId +
                ", title='" + title + '\'' +
                ", isComplete=" + isComplete +
                ", active='" + active + '\'' +
                '}';
    }
}
