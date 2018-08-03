package com.example.faruq.BiangFutsalApp;

//Buat Database

public class News {

    private String title, desc, image, url, cost, telp;

    public News() {
    }

    public News(String title, String desc, String image, String url, String cost, String telp) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.url = url;
        this.cost = cost;
        this.telp = telp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
