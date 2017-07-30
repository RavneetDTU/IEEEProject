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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SIGNotification extends AppCompatActivity {

    RecyclerView rv_signotification;
    SIGAdapter sigAdapter;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ArrayList<SIGModel> SigList = new ArrayList<>();
            for(DataSnapshot dataSnapshotchild : dataSnapshot.getChildren()){
                SIGModel thisSig = new SIGModel(dataSnapshotchild.child("title").getValue().toString()
                        ,dataSnapshotchild.child("date").getValue().toString()
                        ,dataSnapshotchild.child("place").getValue().toString()
                        ,dataSnapshotchild.child("description").getValue().toString());
                SigList.add(thisSig);
            }
            sigAdapter.updateSIGList(SigList);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signotification);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("SIGInformation");

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

        databaseReference.addValueEventListener(valueEventListener);
    }
}
