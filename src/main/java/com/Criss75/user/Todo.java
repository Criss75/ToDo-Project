package com.Criss75.user;

public class Todo {
    private int user_id;
    private int todo_id;
    private String title;
    private boolean is_complete;
    private String active;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
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
                "user_id=" + user_id +
                ", todo_id=" + todo_id +
                ", title='" + title + '\'' +
                ", is_complete=" + is_complete +
                ", active='" + active + '\'' +
                '}';
    }
}
