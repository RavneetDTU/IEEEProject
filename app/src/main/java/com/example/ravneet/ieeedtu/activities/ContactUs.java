package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ravneet.ieeedtu.R;

public class ContactUs extends AppCompatActivity {

    ImageView iv_Benifits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        iv_Benifits = (ImageView) findViewById(R.id.iv_Contactus);
    }
}
