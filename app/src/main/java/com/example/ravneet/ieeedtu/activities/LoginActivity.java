package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ravneet.ieeedtu.R;

/**
 * Created by ravneet on 16/6/17.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);

        setContentView(R.layout.activity_login);

    }

    public void doclick(View view) {
        application.getAuth().getUser().setLoggedIn(true);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
