package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;

public class LargeAchievement extends AppCompatActivity {

    TextView title,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_achievement);

        title = (TextView) findViewById(R.id.tv_LargeAchievementTitle);
        body = (TextView) findViewById(R.id.tv_LargeAchievementBody);

        String title1 = getIntent().getStringExtra("title");
        String body1 = getIntent().getStringExtra("body");

        title.setText(title1);
        body.setText(body1);

    }
}
