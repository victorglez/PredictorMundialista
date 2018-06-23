package com.magister.unab.predictormundialista;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Menu Action
        switch (id)
        {
            case R.id.menu_item_prediction:
                Intent intent_menu_item_prediction = new Intent(this, CountryActivity.class);
                startActivity(intent_menu_item_prediction);
                break;

            case R.id.menu_item_one_activity:
                Intent intent_menu_item_one_activity = new Intent(this, GroupOneActivity.class);
                startActivity(intent_menu_item_one_activity);
                break;

            case R.id.menu_item_two_activity:
                Intent intent_menu_item_two_activity = new Intent(this, GroupOneActivity.class);
                startActivity(intent_menu_item_two_activity);
                break;

            case R.id.menu_item_three_activity:
                Intent intent_menu_item_three_activity = new Intent(this, GroupOneActivity.class);
                startActivity(intent_menu_item_three_activity);
                break;

            case R.id.menu_item_four_activity:
                Intent intent_menu_item_four_activity = new Intent(this, GroupOneActivity.class);
                startActivity(intent_menu_item_four_activity);
                break;

            case R.id.menu_item_five_activity:
                Intent intent_menu_item_five_activity = new Intent(this, GroupOneActivity.class);
                startActivity(intent_menu_item_five_activity);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
