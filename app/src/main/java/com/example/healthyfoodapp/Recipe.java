package com.example.healthyfoodapp;

public class Recipe {

    private int id;
    private String name;
    private String description;
    private int imageResource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipe(){

    }

    public Recipe(String name, String description, int imageResource, int id){
        this.id=id;
        this.name=name;
        this.description=description;
        this.imageResource=imageResource;

    }

}
