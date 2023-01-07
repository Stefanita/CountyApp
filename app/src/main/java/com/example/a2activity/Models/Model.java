package com.example.a2activity.Models;

public class Model {

    private int image;
    private String title;
    private String description;
    private String URL;

    public Model(int image, String title, String desc, String URL) {
        this.image = image;
        this.title = title;
        this.description = desc;
        this.URL = URL;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
