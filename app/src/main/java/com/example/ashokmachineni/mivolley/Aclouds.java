package com.example.ashokmachineni.mivolley;

public class Aclouds {
    private String name ;
    private String image_url;
    private String studio;

    public Aclouds(){

    }

    public Aclouds(String name, String image_url, String studio) {
        this.name = name;
        this.image_url = image_url;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
