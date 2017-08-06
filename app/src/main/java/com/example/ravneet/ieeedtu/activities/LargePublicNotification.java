package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class LargePublicNotification extends AppCompatActivity {

    TextView title,body,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_public_notification);

        title = (TextView) findViewById(R.id.tv_notificationTitle);
        body = (TextView) findViewById(R.id.tv_notificationBody);
        date = (TextView) findViewById(R.id.tv_notificationDate);

        String title1 = getIntent().getStringExtra("title");
        String body1 = getIntent().getStringExtra("body");
        String date1 = getIntent().getStringExtra("date");
        String place1 = getIntent().getStringExtra("place");

        title.setText(title1);
        body.setText(body1);
        date.setText(date1+" "+place1);
    }
}
