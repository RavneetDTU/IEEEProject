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

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final int REQUEST_NARROW_LOGIN = 1;
    private View loginButton;
    Button btn_temp;

    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btn_ieeelogin);
        if(loginButton != null){
            loginButton.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        if(view == loginButton){
            startActivityForResult(new Intent(this,LoginNarrowActivity.class),REQUEST_NARROW_LOGIN);
        }

    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data){

        if(resultcode != RESULT_OK)
            return;

        if(requestcode == REQUEST_NARROW_LOGIN)
            finishlogin();
    }

    private void finishlogin(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    public void movetoApp(View view) {
        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
