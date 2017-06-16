package com.example.ravneet.ieeedtu.infrasturcture;

import android.app.Application;

/**
 * Created by ravneet on 16/6/17.
 */

public class IEEEApplication extends Application {

    private Auth auth;

    @Override
    public void onCreate(){
        super.onCreate();
        auth = new Auth(this);
    }

    public Auth getAuth(){
        return auth;
    }

}
