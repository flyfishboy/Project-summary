package com.nchu.model;

import java.io.Serializable;
import java.util.List;

public class ContentCategory implements Serializable {
    private Long id;

    private String name;

    private List<Content> contentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return "ContentCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentList=" + contentList +
                '}';
    }
}