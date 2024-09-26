package com.example.a2124802010277_letuankiet_bth02;

public class ContentBt {
    String name;
    String content;
    Class<?> activity;

    public ContentBt(String name, String content, Class<?> activity) {
        this.name = name;
        this.content = content;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}