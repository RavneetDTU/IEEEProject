package com.example.ravneet.ieeedtu.activities;

import android.app.Application;
import android.util.Log;

import com.example.ravneet.ieeedtu.infrasturcture.PaidMember;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by ravneet on 2/8/17.
 */

public class MyApp extends Application {

    public static ArrayList<PaidMember> paidMemberArrayList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().getReference().child("IEEE Members").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot datachild : dataSnapshot.getChildren()){
                    PaidMember thismember = new PaidMember(datachild.child("name").getValue().toString(),
                            datachild.child("year").getValue().toString(),
                            datachild.child("email").getValue().toString(),
                            datachild.child("membershipGivenBy").getValue().toString());
                    paidMemberArrayList.add(thismember);
                    Log.e("TAG", "onDataChange: " +  datachild.child("email").getValue().toString());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
