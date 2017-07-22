package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.SIGModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SIGInformationPost extends AppCompatActivity {

    Button btn_Post;
    TextView et_dateAndTime,et_Title,et_place,et_description;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siginformation);

        btn_Post = (Button) findViewById(R.id.btn_sigPost);
        et_dateAndTime = (TextView) findViewById(R.id.et_sigdate);
        et_Title = (TextView) findViewById(R.id.et_sigTitle);
        et_place = (TextView) findViewById(R.id.et_sigPlace);
        et_description = (TextView) findViewById(R.id.et_sigdescription);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("SIGInformation");

         final String SIGTitle = et_Title.getText().toString();
         final String dateAndTime = et_dateAndTime.getText().toString();
         final String SIGPlace = et_place.getText().toString();
         final String SIGDescription = et_description.getText().toString();

        btn_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SIGModel thisSig = new SIGModel(SIGTitle,dateAndTime,SIGPlace,SIGDescription);
                databaseReference.push().setValue(thisSig);

                Toast.makeText(SIGInformationPost.this, "Posting SIG Information", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
