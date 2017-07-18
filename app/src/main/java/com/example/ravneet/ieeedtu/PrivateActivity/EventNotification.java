package com.example.ravneet.ieeedtu.PrivateActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.ieeedtu.R;

public class EventNotification extends AppCompatActivity {

    Button btn_postSigNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_notification);

        btn_postSigNotification = (Button) findViewById(R.id.btn_PostSigNotification);
        btn_postSigNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventNotification.this,SIGInformation.class));
            }
        });
    }
}
