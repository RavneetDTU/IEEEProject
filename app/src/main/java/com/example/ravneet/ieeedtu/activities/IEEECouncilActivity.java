package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class IEEECouncilActivity extends AppCompatActivity {

    TextView post,name,year;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeecouncil);

        post = (TextView) findViewById(R.id.tv_postOfMember);
        name = (TextView) findViewById(R.id.tv_nameOfMember);
        year = (TextView) findViewById(R.id.tv_YearOfMember);

        Map<String,IEEECouncil> map = new HashMap<String, IEEECouncil>();

    }
}
