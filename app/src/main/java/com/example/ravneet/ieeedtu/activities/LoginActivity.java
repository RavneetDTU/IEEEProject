package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.ieeedtu.R;

/**
 * Created by ravneet on 16/6/17.
 */

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_NARROW_LOGIN = 1;
    private View loginButton;
    Button btn_IEEElogin;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);

        setContentView(R.layout.activity_login);


    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(resultCode != RESULT_OK){
            return;
        }
        if(requestCode == REQUEST_NARROW_LOGIN){
            finishLogin();
        }
    }
    private void finishLogin(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    public void gotoLoginNarrowActivity(View view) {

        Intent i = new Intent(LoginActivity.this,LoginNarrowActivity.class);
        startActivity(i);
        finish();
    }
}
