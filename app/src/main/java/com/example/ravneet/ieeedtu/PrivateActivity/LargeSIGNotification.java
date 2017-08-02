package com.example.ravneet.ieeedtu.PrivateActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;

public class LargeSIGNotification extends AppCompatActivity {

    TextView title,date,place,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_signotification);

        title = (TextView) findViewById(R.id.tv_SIGtitle);
        date = (TextView) findViewById(R.id.tv_SIGDate);
        place = (TextView) findViewById(R.id.tv_SIGPlace);
        body = (TextView) findViewById(R.id.tv_SIGDescription);

        String title1 = getIntent().getStringExtra("title");
        String date1 = getIntent().getStringExtra("date");
        String place1 = getIntent().getStringExtra("place");
        String body1 = getIntent().getStringExtra("body");

        title.setText(title1);
        date.setText(date1);
        place.setText(place1);
        body.setText(body1);
    }
}
