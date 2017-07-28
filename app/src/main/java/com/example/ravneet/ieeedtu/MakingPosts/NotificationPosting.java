package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Notification;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotificationPosting extends AppCompatActivity {

    EditText title,date,body;
    Button btn_PostNotification;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);

        title = (EditText) findViewById(R.id.et_notificationTitle);
        date = (EditText) findViewById(R.id.et_notificationdate);
        body = (EditText) findViewById(R.id.et_notificationbody);
        btn_PostNotification = (Button) findViewById(R.id.btn_postnotification);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("PublicNotification");

        btn_PostNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Notification thisnotification = new Notification(title.getText().toString(),body.getText().toString(),date.getText().toString());

                databaseReference.push().setValue(thisnotification);

                Toast.makeText(NotificationPosting.this, "Posting Notification", Toast.LENGTH_SHORT).show();

                title.setText("");
                date.setText("");
                body.setText("");


            }
        });


    }
}
