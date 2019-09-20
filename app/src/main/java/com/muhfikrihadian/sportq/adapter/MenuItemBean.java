package com.muhfikrihadian.sportq.adapter;

public class MenuItemBean {

    private int id;
    private int imageResource;
    private String title;

    public MenuItemBean(int id, int imageResource, String title) {
        this.id=id;
        this.imageResource = imageResource;
        this.title = title;
    }

    public MenuItemBean() {
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
