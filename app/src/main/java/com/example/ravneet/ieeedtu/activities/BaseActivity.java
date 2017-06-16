package com.example.ravneet.ieeedtu.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import com.example.ravneet.ieeedtu.infrasturcture.IEEEApplication;

/**
 * Created by ravneet on 16/6/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected IEEEApplication application;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);

        application = (IEEEApplication) getApplication();
    }

}
