package com.example.ravneet.ieeedtu.PrivateActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ravneet.ieeedtu.Adapters.OnItemClickListener;
import com.example.ravneet.ieeedtu.Adapters.SIGAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.SIGModel;

import java.util.ArrayList;

public class SIGNotification extends AppCompatActivity {

    RecyclerView rv_signotification;
    SIGAdapter sigAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signotification);

        rv_signotification = (RecyclerView) findViewById(R.id.rv_sigNotificarion);
        rv_signotification.setLayoutManager(new LinearLayoutManager(this));

        sigAdapter = new SIGAdapter(this, new ArrayList<SIGModel>());
        rv_signotification.setAdapter(sigAdapter);

        sigAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String title) {
                Intent i = new Intent(getApplicationContext(),LargeSIGNotification.class);
                i.putExtra("title",title);
                startActivity(i);
            }
        });
    }
}
