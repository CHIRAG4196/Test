package com.example.utsav.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.adapter.UserAdapter;

public class RecycleActivity extends AppCompatActivity {
    private RecyclerView rvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        rvUser = (RecyclerView) findViewById(R.id.rv_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUser.setLayoutManager(layoutManager);
        rvUser.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        UserAdapter userAdapter = new UserAdapter();
        rvUser.setAdapter(userAdapter);

    }
}
