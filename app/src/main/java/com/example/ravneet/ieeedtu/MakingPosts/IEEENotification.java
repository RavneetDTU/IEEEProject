package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEEEvent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IEEENotification extends AppCompatActivity {

    EditText title,date;
    Button btn_send;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeenotification);

        title = (EditText) findViewById(R.id.et_IEEENotfTitle);
        date = (EditText) findViewById(R.id.et_IEEENotfdate);
        btn_send = (Button) findViewById(R.id.btn_IEEENotf);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("MemberNotificatrions");

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IEEEEvent thisEvent = new IEEEEvent(title.getText().toString(),date.getText().toString());

                databaseReference.push().setValue(thisEvent);

                Toast.makeText(IEEENotification.this, "Posting Internal Notification", Toast.LENGTH_SHORT).show();

                title.setText("");
                date.setText("");
            }
        });


    }
}
