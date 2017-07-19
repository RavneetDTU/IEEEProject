package com.example.ravneet.ieeedtu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.Adapters.IEEECouncilAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IEEECouncilActivity extends AppCompatActivity {

    RecyclerView rv_IEEECouncil;
    IEEECouncilAdapter councilAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeecouncil);

        rv_IEEECouncil = (RecyclerView) findViewById(R.id.rv_ieeecouncil);
        rv_IEEECouncil.setLayoutManager(new LinearLayoutManager(this));

        councilAdapter = new IEEECouncilAdapter(this, new ArrayList<IEEECouncil>());
        rv_IEEECouncil.setAdapter(councilAdapter);



    }
}
