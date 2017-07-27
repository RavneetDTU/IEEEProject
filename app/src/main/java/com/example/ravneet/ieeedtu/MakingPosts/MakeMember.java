package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.R;

public class MakeMember extends AppCompatActivity {

    EditText name,year,email;
    Button giveMembership;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_member);

        name = (EditText) findViewById(R.id.et_MakeMemberName);
        year = (EditText) findViewById(R.id.et_MakeMemberYear);
        email = (EditText) findViewById(R.id.et_MakeMemberEmailID);
        giveMembership = (Button) findViewById(R.id.btn_MakeMember);

        giveMembership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MakeMember.this, "Making this User IEEE Member", Toast.LENGTH_SHORT).show();

                name.setText("");
                year.setText("");
                email.setText("");
            }
        });


    }
}
