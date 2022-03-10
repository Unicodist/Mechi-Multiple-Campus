package com.mmc.jhapa.services;

import com.mmc.jhapa.classes.models.adapters.BlogPostModel;
import com.mmc.jhapa.values.BlogValues;

import java.util.ArrayList;
import java.util.List;

public class BlogServices {
    private final String blogApi;

    public BlogServices() {
        blogApi = BlogValues.blogApiAddress;
    }

    public List<BlogPostModel> getPosts(int limit) {
        List<BlogPostModel> blogPosts = new ArrayList<>();

        for (int counter = 1; counter <= limit; counter++) {
            blogPosts.add(new BlogPostModel("https://i.natgeofe.com/k/5508021e-2814-42ef-87eb-8dccf24ea9ba/dolphin-communication-leaping.jpg?w=795&h=530", "Abra ka Dabra", "Demo Author", "2022-12-21", "http://ashishneupane.name.np"));
        }
        return blogPosts;
    }
}
