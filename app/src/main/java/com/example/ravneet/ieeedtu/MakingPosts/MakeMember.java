package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.PaidMember;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeMember extends AppCompatActivity {

    EditText name,year,email;
    Button giveMembership;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_member);

        name = (EditText) findViewById(R.id.et_MakeMemberName);
        year = (EditText) findViewById(R.id.et_MakeMemberYear);
        email = (EditText) findViewById(R.id.et_MakeMemberEmailID);
        giveMembership = (Button) findViewById(R.id.btn_MakeMember);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("IEEE Members");

        firebaseAuth = FirebaseAuth.getInstance();

        giveMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PaidMember thismember = new PaidMember(name.getText().toString(),year.getText().toString(),email.getText().toString(),firebaseAuth.getCurrentUser().getDisplayName());

                databaseReference.push().setValue(thismember);

                Toast.makeText(MakeMember.this, "Making this User IEEE Member", Toast.LENGTH_SHORT).show();

                name.setText("");
                year.setText("");
                email.setText("");
            }
        });


    }
}
