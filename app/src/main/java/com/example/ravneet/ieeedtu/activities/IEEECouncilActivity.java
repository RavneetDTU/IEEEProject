package com.example.ravneet.ieeedtu.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.Adapters.CardfregmentAdapter;
import com.example.ravneet.ieeedtu.Adapters.IEEECouncilAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IEEECouncilActivity extends AppCompatActivity {

    RecyclerView rv_IEEECouncil;
    IEEECouncilAdapter councilAdapter;

    private FirebaseDatabase firebaseDatabase;
    private ProgressBar progress;
    private DatabaseReference databaseReference;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ArrayList<IEEECouncil> councilArrayList = new ArrayList<>();
            for(DataSnapshot dataSnapshotchild : dataSnapshot.getChildren()){

                IEEECouncil thismember = new IEEECouncil(dataSnapshotchild.child("name").getValue().toString()
                        ,dataSnapshotchild.child("post").getValue().toString()
                        ,dataSnapshotchild.child("year").getValue().toString(),
                        dataSnapshotchild.child("imageurl").getValue().toString());
                councilArrayList.add(thismember);
            }
            ((ViewGroup)progress.getParent()).removeView(progress);
            councilAdapter.updateCouncil(councilArrayList);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeecouncil);

        progress = (ProgressBar) findViewById(R.id.progressBar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        CardfregmentAdapter adapter = new CardfregmentAdapter(getSupportFragmentManager(),dpToPixels(2,this));
//
//        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
//        fragmentCardShadowTransformer.enableScaling(true);
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
//        viewPager.setOffscreenPageLimit(3);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("IEEECouncil");

       // rv_IEEECouncil = (RecyclerView) findViewById(R.id.rv_ieeecouncil);
        rv_IEEECouncil.setLayoutManager(new LinearLayoutManager(this));

        councilAdapter = new IEEECouncilAdapter(this, new ArrayList<IEEECouncil>());
        rv_IEEECouncil.setAdapter(councilAdapter);

        progress.setVisibility(ProgressBar.VISIBLE);

        databaseReference.addValueEventListener(valueEventListener);

    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
