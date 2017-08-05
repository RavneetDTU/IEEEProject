package com.example.ravneet.ieeedtu.MakingPosts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.google.firebase.auth.FirebaseAuth;

public class MakePosts extends AppCompatActivity {

    Button btn_SIGNotification,btn_PublicNotification,btn_IEEECouncil,btn_Achivements,btn_Membership,btn_makeAdmin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_posts);

        firebaseAuth = FirebaseAuth.getInstance();

        btn_SIGNotification = (Button) findViewById(R.id.btn_SIGNotification);
        btn_IEEECouncil = (Button) findViewById(R.id.btn_IEEECouncil);
        btn_Membership = (Button) findViewById(R.id.btn_membership);
        btn_PublicNotification = (Button) findViewById(R.id.btn_makepublicNotification);
        btn_Achivements = (Button) findViewById(R.id.btn_MakeAchievement);
        btn_makeAdmin = (Button) findViewById(R.id.btn_adminUser);

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

        btn_PublicNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MakePosts.this,NotificationPosting.class));
                finish();
            }
        });

        btn_Achivements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MakePosts.this,PostAchievement.class));
                finish();
            }
        });

        btn_makeAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firebaseAuth.getCurrentUser().getEmail().equals("ravneet.dtu@gmail.com")){
                    startActivity(new Intent(MakePosts.this,MakeAdmin.class));
                }
                else {
                    Toast.makeText(MakePosts.this, "For Developer Only", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
