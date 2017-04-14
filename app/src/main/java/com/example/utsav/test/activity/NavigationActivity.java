package com.example.utsav.test.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.fragment.HomeStudentFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AppCompatButton btnSubmit;
    private AppCompatEditText etCurrentPassword, etnewPassword, etConfirmPassword;
    private SharedPreferences preferencesEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preferencesEmail = getSharedPreferences("Signup", Context.MODE_PRIVATE);
        HomeStudentFragment homeStudentFragment = HomeStudentFragment.newInstance("", "");
        addFragment(R.id.navigation_container, homeStudentFragment);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    public void addFragment(int id, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack("");
        transaction.commit();
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
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeStudentFragment/Up button, so long
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

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_change_password) {
            openDialog();


        } else if (id == R.id.nav_feedback) {
            startActivity(new Intent(NavigationActivity.this, FeddbackActivity.class));
            finish();

        } else if (id == R.id.nav_rate_app) {

        } else if (id == R.id.nav_signout) {
            //signoutUser();

        } else if (id == R.id.nav_view) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    private void signoutUser() {
//        SharedPreferences.Editor editor = preferencesEmail.edit();
//        editor.putBoolean("login", false);
//        editor.apply();
//        SigninFragment signinFragment = SigninFragment.newInstance("", "");
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.addFragment(R.id.container, signinFragment);
//        finish();
//    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(NavigationActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_change_password, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        etCurrentPassword = (AppCompatEditText) view.findViewById(R.id.et_current_password);
        etConfirmPassword = (AppCompatEditText) view.findViewById(R.id.et_confirm_password);
        etnewPassword = (AppCompatEditText) view.findViewById(R.id.et_new_password);
        btnSubmit = (AppCompatButton) view.findViewById(R.id.btn_submit_password);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
