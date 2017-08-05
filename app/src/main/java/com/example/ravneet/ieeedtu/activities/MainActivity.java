package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.ravneet.ieeedtu.MakingPosts.MakeMember;
import com.example.ravneet.ieeedtu.MakingPosts.MakePosts;
import com.example.ravneet.ieeedtu.PrivateActivity.ChatRoom;
import com.example.ravneet.ieeedtu.PrivateActivity.EventNotification;
import com.example.ravneet.ieeedtu.PrivateActivity.SIGNotification;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Admins;
import com.example.ravneet.ieeedtu.infrasturcture.PaidMember;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth firebaseAuth;
    ArrayList<Admins> adminList = new ArrayList<>();
    private boolean isAdmin = false;
    static ArrayList<PaidMember> paidMemberList = new ArrayList<>();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceadmin;
    private ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot datachild : dataSnapshot.getChildren()) {
                PaidMember thismember = new PaidMember(datachild.child("name").getValue().toString(),
                        datachild.child("year").getValue().toString(),
                        datachild.child("email").getValue().toString().toLowerCase(),
                        datachild.child("membershipGivenBy").getValue().toString());
                paidMemberList.add(thismember);
            }
            for (int i = 0; i < paidMemberList.size(); i++) {
                Log.d("TAG", "onActivityResult: " + paidMemberList.get(i).getEmail());
                if (paidMemberList.get(i).getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                    //navigationView1.setVisibility(View.VISIBLE);
                    if (drawer.findViewById(R.id.nav_rightview) == null)
                        drawer.addView(adminNavigationView);
                    Toast.makeText(MainActivity.this, "Welcome IEEE Member.", Toast.LENGTH_SHORT).show();

                }
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private ValueEventListener valueEventListeneradmin = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot dataSnapshotChildren : dataSnapshot.getChildren()){
                Admins thisAdmin = new Admins(dataSnapshotChildren.child("email").getValue().toString(),
                        dataSnapshotChildren.child("name").getValue().toString());
                adminList.add(thisAdmin);
            }
            for(int i = 0;i<adminList.size();i++){
                if(adminList.get(i).getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())){
                    isAdmin = true;
                }
            }



        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public static final int RC_SIGN_IN = 1;
    DrawerLayout drawer;
    NavigationView adminNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("IEEE Members");
        databaseReferenceadmin = firebaseDatabase.getReference().child("admins");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        adminNavigationView = (NavigationView) drawer.findViewById(R.id.nav_rightview);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_rightview);
        navigationView.setNavigationItemSelectedListener(this);
       navigationView1.setNavigationItemSelectedListener(this);
        drawer.removeViewAt(2);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {
            Log.e("TAG", "onCreate: User isn't null");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot datachild : dataSnapshot.getChildren()) {
                        PaidMember thismember = new PaidMember(datachild.child("name").getValue().toString(),
                                datachild.child("year").getValue().toString(),
                                datachild.child("email").getValue().toString(),
                                datachild.child("membershipGivenBy").getValue().toString());
                        paidMemberList.add(thismember);
                    }
                    for (int i = 0; i < paidMemberList.size(); i++) {
                        Log.d("TAG", "onCreate: " + paidMemberList.get(i).getEmail());
                        if (paidMemberList.get(i).getEmail().equals(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
                            //navigationView1.setVisibility(View.VISIBLE);
                            if (drawer.findViewById(R.id.nav_rightview) == null)
                                drawer.addView(adminNavigationView);
                            Toast.makeText(MainActivity.this, "Welcome IEEE Member", Toast.LENGTH_SHORT).show();

                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } else {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setLogo(R.drawable.ieee_logo)
                            .setIsSmartLockEnabled(false)
                            .setProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                            .build(),
                    RC_SIGN_IN);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_contactus) {
            startActivity(new Intent(MainActivity.this, ContactUs.class));
            return true;
        } else if (id == R.id.nav_signout) {
            AuthUI.getInstance().signOut(this);
            drawer.removeView(adminNavigationView);
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setLogo(R.drawable.ieee_logo)
                            .setIsSmartLockEnabled(false)
                            .setProviders(
                                    Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                            .build(),
                    RC_SIGN_IN);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_notification) {
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        } else if (id == R.id.nav_ieeecouncil) {
            startActivity(new Intent(MainActivity.this, IEEECouncilActivity.class));
        } else if (id == R.id.nav_biweeklyArticle) {
            startActivity(new Intent(MainActivity.this, AchievementActivity.class));
        } else if (id == R.id.nav_signotification) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this, SIGNotification.class));
        } else if (id == R.id.nav_eventnotification) {
            startActivity(new Intent(MainActivity.this, EventNotification.class));
        } else if (id == R.id.nav_chatroom) {
            startActivity(new Intent(MainActivity.this, ChatRoom.class));
        } else if(id == R.id.nav_admin){

        } else if (id == R.id.nav_admin){
            if(isAdmin == true){
                startActivity(new Intent(MainActivity.this, MakePosts.class));
            }
            else {
                Toast.makeText(this, "You Are Not Admin", Toast.LENGTH_SHORT).show();
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "You are Logged In...", Toast.LENGTH_SHORT).show();
                databaseReference.addValueEventListener(valueEventListener);
                databaseReferenceadmin.addValueEventListener(valueEventListeneradmin);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign-In Canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

}
