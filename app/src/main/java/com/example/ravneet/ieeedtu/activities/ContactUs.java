package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ravneet.ieeedtu.R;
import com.squareup.picasso.Picasso;

public class ContactUs extends AppCompatActivity {

    ImageView iv_Benifits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        iv_Benifits = (ImageView) findViewById(R.id.iv_Contactus);

        Picasso.with(ContactUs.this).load("https://firebasestorage.googleapis.com/v0/b/ieeedtu-381fd.appspot.com/o/trailer.png?alt=media&token=b518919d-968a-4886-a3b8-038baaa1aa2f").into(iv_Benifits);
    }
}
