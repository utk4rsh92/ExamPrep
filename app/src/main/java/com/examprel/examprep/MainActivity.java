package com.examprel.examprep;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.examprel.examprep.AddSub.FirstExpActivity;
import com.examprel.examprep.ArrayExample.ListActivity;
import com.examprel.examprep.GPS.LocationActivity;
import com.examprel.examprep.LifeCycle.LicfeActivity;
import com.examprel.examprep.Orientaion.SaveStateActivity;
import com.examprel.examprep.Permission.GetPermitActivity;
import com.examprel.examprep.sample.OperatorActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
        }
        else if (id == R.id.nav_gallery) {
            //(new Intent(MainActivity.this,SqliteActivity.class));startActivity
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(MainActivity.this, FirstExpActivity.class));

        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(MainActivity.this, OperatorActivity.class));
        }
        else if (id == R.id.nav_location) {
            startActivity(new Intent(MainActivity.this, LocationActivity.class));
        }
        else if (id == R.id.nav_savestate) {
            startActivity(new Intent(MainActivity.this, SaveStateActivity.class));

        }
        else if (id == R.id.nav_arraylist) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
        }
        else if (id == R.id.nav_share) {
            startActivity(new Intent(MainActivity.this, LicfeActivity.class));

        }
        else if (id == R.id.nav_permit) {
            startActivity(new Intent(MainActivity.this, GetPermitActivity.class));

        }
        else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
