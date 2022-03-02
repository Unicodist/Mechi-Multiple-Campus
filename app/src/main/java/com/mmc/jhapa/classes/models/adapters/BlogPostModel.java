package com.mmc.jhapa.classes.models.adapters;

public class BlogPostModel {
    private final String imageLink;
    private final String title;
    private final String date;
    private final String postLink;

    public BlogPostModel(String url, String title, String date, String postLink){
        this.imageLink = url;
        this.title = title;
        this.date = date;
        this.postLink = postLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
