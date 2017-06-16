package com.example.ravneet.ieeedtu.infrasturcture;

import android.content.Context;

/**
 * Created by ravneet on 16/6/17.
 */

public class Auth {

    private final Context context;
    private User user;

    public User getUser() {
        return user;
    }

    public Auth(Context context) {
        this.context = context;
        user = new User();
    }
}
