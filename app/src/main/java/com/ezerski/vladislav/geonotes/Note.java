package com.ezerski.vladislav.geonotes;

import android.graphics.Color;

import java.io.Serializable;

public class Note implements Serializable {

    private String id;
    private String body;
    private int color;

    public Note() {
    }

    public Note(String id, String body, String  color) {
        this.id = id;
        this.body = body;
        this.color = Color.parseColor(color.replace("0x", "#"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
