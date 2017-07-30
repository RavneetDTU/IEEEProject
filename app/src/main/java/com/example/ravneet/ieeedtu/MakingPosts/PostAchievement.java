package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Achievement;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostAchievement extends AppCompatActivity {

    EditText title,description;
    Button btn_postAchievement;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_achievement);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Achievement");

        title = (EditText) findViewById(R.id.et_achievementTitle);
        description = (EditText) findViewById(R.id.et_achievementBody);
        btn_postAchievement = (Button) findViewById(R.id.btn_PostAchievement);

        btn_postAchievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Achievement thisAchivement = new Achievement(title.getText().toString(),description.getText().toString());

                databaseReference.push().setValue(thisAchivement);

                Toast.makeText(PostAchievement.this, "Posting Achievement......", Toast.LENGTH_SHORT).show();

                title.setText("");
                description.setText("");
            }
        });
    }
}
