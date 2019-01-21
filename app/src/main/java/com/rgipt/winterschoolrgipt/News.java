package com.rgipt.winterschoolrgipt;

public class News {
    private String title;
    private String description;


    public News() {
        //empty constructor needed
    }

    public News(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
