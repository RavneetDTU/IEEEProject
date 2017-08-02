package com.example.ravneet.ieeedtu.PrivateActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.Adapters.EventAdapter;
import com.example.ravneet.ieeedtu.MakingPosts.SIGInformationPost;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEEEvent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EventNotification extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter eventAdapter;

    private ProgressBar progressBar;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ArrayList<IEEEEvent> events = new ArrayList<>();
            for(DataSnapshot datachild : dataSnapshot.getChildren()){
                IEEEEvent thisevent = new IEEEEvent(datachild.child("title").getValue().toString(),datachild.child("date").getValue().toString());
                events.add(thisevent);
            }
            progressBar.setVisibility(ProgressBar.GONE);
            eventAdapter.updateEventList(events);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_notification);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("MemberNotificatrions");

        recyclerView = (RecyclerView) findViewById(R.id.rv_EventNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        eventAdapter = new EventAdapter(this,new ArrayList<IEEEEvent>());
        recyclerView.setAdapter(eventAdapter);

        progressBar.setVisibility(ProgressBar.VISIBLE);

        databaseReference.addValueEventListener(valueEventListener);


    }
}
