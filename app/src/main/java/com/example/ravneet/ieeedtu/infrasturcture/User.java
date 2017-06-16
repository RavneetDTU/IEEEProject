package com.example.ravneet.ieeedtu.infrasturcture;

/**
 * Created by ravneet on 16/6/17.
 */

public class User {

    private int id;
    private String username;
    private String avatarURL;
    private String displayname;
    private boolean isLoggedIn;
    private boolean hasPassword;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getDisplayname() {
        return displayname;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public String getEmail() {
        return email;
    }
}
