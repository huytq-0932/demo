package com.tr4n.demolistadapter.java;

public class Photo {
    private int id;
    private String title;
    private String url ;

    public Photo(int id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
