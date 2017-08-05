package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.example.ravneet.ieeedtu.Adapters.AchievementAdapter;
import com.example.ravneet.ieeedtu.Adapters.OnItemClickListener;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Achievement;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AchievementAdapter adapter;

    private ProgressBar progress;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            ArrayList<Achievement> achievementList = new ArrayList<>();
            for (DataSnapshot dataSnapshotchild : dataSnapshot.getChildren()){
                Achievement thisAchievement = new Achievement(dataSnapshotchild.child("title").getValue().toString()
                        ,dataSnapshotchild.child("body").getValue().toString());
                achievementList.add(thisAchievement);
            }
            progress.setVisibility(ProgressBar.GONE);
            adapter.updateAchievements(achievementList);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivements);

        progress = (ProgressBar) findViewById(R.id.progressBar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Achievement");

        recyclerView = (RecyclerView) findViewById(R.id.rv_achievement);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AchievementAdapter(this, new ArrayList<Achievement>());
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(valueEventListener);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(String title, String body,String date, String place) {
                Intent i = new Intent(AchievementActivity.this,LargeAchievement.class);
                i.putExtra("title",title);
                i.putExtra("body",body);
                startActivity(i);
            }
        });

        progress.setVisibility(ProgressBar.VISIBLE);

    }
}
