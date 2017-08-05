package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Admins;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeAdmin extends AppCompatActivity {

    EditText name, email, year;
    Button send;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_admin);

        name = (EditText) findViewById(R.id.et_makeAdminName);
        email = (EditText) findViewById(R.id.et_makeAdminEmail);
        year = (EditText) findViewById(R.id.et_makeAdminYear);
        send = (Button) findViewById(R.id.btn_makeadmin);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("admins");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Admins thisAdmin = new Admins(email.getText().toString(),email.getText().toString(),year.getText().toString());
                databaseReference.push().setValue(thisAdmin);

                Toast.makeText(MakeAdmin.this, "Admin Added....", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
