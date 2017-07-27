package com.example.ravneet.ieeedtu.MakingPosts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.ieeedtu.R;

public class MakePosts extends AppCompatActivity {

    Button btn_SIGNotification,btn_PublicNotification,btn_IEEECouncil,btn_Achivements,btn_Membership;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_posts);

        btn_SIGNotification = (Button) findViewById(R.id.btn_SIGNotification);
        btn_IEEECouncil = (Button) findViewById(R.id.btn_IEEECouncil);
        btn_Membership = (Button) findViewById(R.id.btn_membership);


        btn_SIGNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MakePosts.this,SIGInformationPost.class));
                finish();
            }
        });

        btn_IEEECouncil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MakePosts.this,IEEECouncilPost.class));
                finish();
            }
        });

        btn_Membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MakePosts.this,MakeMember.class));
            }
        });
    }
}
