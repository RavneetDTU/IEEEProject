package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.ravneet.ieeedtu.MakingPosts.MakePosts;
import com.example.ravneet.ieeedtu.PrivateActivity.ChatRoom;
import com.example.ravneet.ieeedtu.PrivateActivity.EventNotification;
import com.example.ravneet.ieeedtu.PrivateActivity.SIGNotification;
import com.example.ravneet.ieeedtu.R;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        }
        else if(id == R.id.makePosts){
            startActivity(new Intent(MainActivity.this, MakePosts.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_memberonly) {
            startActivity(new Intent(MainActivity.this, MemberOnly.class));
        } else if (id == R.id.nav_notification) {
            startActivity(new Intent(MainActivity.this, NotificationActivity.class));
        } else if (id == R.id.nav_ieeecouncil) {
            startActivity(new Intent(MainActivity.this, IEEECouncilActivity.class));
        } else if (id == R.id.nav_biweeklyArticle) {
            startActivity(new Intent(MainActivity.this, Achivements.class));
        } else if (id == R.id.nav_signotification) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this, SIGNotification.class));
        } else if (id == R.id.nav_eventnotification) {
            startActivity(new Intent(MainActivity.this, EventNotification.class));
        } else if (id == R.id.nav_chatroom) {
            startActivity(new Intent(MainActivity.this, ChatRoom.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
