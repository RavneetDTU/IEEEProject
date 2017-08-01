package com.example.ravneet.ieeedtu.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ravneet.ieeedtu.Adapters.NotificationAdapter;
import com.example.ravneet.ieeedtu.Adapters.OnItemClickListener;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.example.ravneet.ieeedtu.infrasturcture.Notification;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotificationAdapter notificationAdapter;

    private ProgressBar progress;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ArrayList<Notification> councilArrayList = new ArrayList<>();
            for (DataSnapshot dataSnapshotchild : dataSnapshot.getChildren()) {
                Notification thisnotification = new Notification(dataSnapshotchild.child("title").getValue().toString()
                        , dataSnapshotchild.child("body").getValue().toString()
                        , dataSnapshotchild.child("date").getValue().toString());
                councilArrayList.add(thisnotification);
            }
            ((ViewGroup)progress.getParent()).removeView(progress);
            notificationAdapter.updateNotification(councilArrayList);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

           progress = (ProgressBar) findViewById(R.id.progressBar);

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference().child("PublicNotification");

        recyclerView = (RecyclerView) findViewById(R.id.rv_publicNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notificationAdapter = new NotificationAdapter(this,new ArrayList<Notification>());
        recyclerView.setAdapter(notificationAdapter);

            databaseReference.addValueEventListener(valueEventListener);

            notificationAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(String title) {
                    Intent i = new Intent(NotificationActivity.this,LargePublicNotification.class);
                    startActivity(i);
                }
            });

            progress.setVisibility(ProgressBar.VISIBLE);


    }
}
