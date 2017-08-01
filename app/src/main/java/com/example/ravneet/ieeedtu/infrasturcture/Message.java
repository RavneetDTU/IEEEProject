package com.example.ravneet.ieeedtu.infrasturcture;

/**
 * Created by ravneet on 1/8/17.
 */

public class Message {

    private String text;
    private String name;
    private String photoUrl;

    public Message(){

    }

    public Message(String text, String name, String photoUrl) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
