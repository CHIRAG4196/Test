package com.example.utsav.test.activity.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.model.User;

import java.util.ArrayList;

/**
 * Created by utsav on 14-04-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.StudentViewHolder> {
    private ArrayList<User> userArrayList = new ArrayList<>();
    private Context context;

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.tvMobile.setText("");
        holder.tvName.setText("");
        holder.ivUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvName, tvMobile;
        private AppCompatImageView ivDelete, ivUpdate;

        public StudentViewHolder(View itemView) {
            super(itemView);
            tvName = (AppCompatTextView) itemView.findViewById(R.id.tv_name);
            tvMobile = (AppCompatTextView) itemView.findViewById(R.id.tv_mobile);
            ivDelete = (AppCompatImageView) itemView.findViewById(R.id.iv_delete);
            ivUpdate = (AppCompatImageView) itemView.findViewById(R.id.iv_edit);
        }
    }
}
