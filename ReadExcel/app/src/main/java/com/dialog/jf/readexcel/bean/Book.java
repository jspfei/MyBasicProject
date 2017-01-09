package com.dialog.jf.readexcel.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/1/9.
 */

public class Book implements Serializable {
    private String title;
    private String txt;
    private String mp3;

    private String content;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
