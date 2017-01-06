package com.example.admin.basicproject.litepal.model;


import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by admin on 2017/1/5.
 */

public class Comment extends DataSupport {

    private int id;

    private String content;

    private Date publishDate;

    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
