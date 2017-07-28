package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.SIGModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SIGInformationPost extends AppCompatActivity {

    Button btn_Post;
    EditText et_dateAndTime,et_Title,et_place,et_description;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siginformation);

        btn_Post = (Button) findViewById(R.id.btn_sigPost);
        et_dateAndTime = (EditText) findViewById(R.id.et_sigdate);
        et_Title = (EditText) findViewById(R.id.et_sigTitle);
        et_place = (EditText) findViewById(R.id.et_sigPlace);
        et_description = (EditText) findViewById(R.id.et_sigdescription);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("SIGInformation");


        // Making String Of EditText and than passing them in Model class data doesn't work for Firbase;

        btn_Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SIGModel thisSig = new SIGModel(et_Title.getText().toString(),et_dateAndTime.getText().toString(),et_place.getText().toString(),et_description.getText().toString());
                databaseReference.push().setValue(thisSig);

                Toast.makeText(SIGInformationPost.this, "Posting SIG Information", Toast.LENGTH_SHORT).show();

                et_dateAndTime.setText("");
                et_description.setText("");
                et_place.setText("");
                et_Title.setText("");
            }
        });





    }
}
