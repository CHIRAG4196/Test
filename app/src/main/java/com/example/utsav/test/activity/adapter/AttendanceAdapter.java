package com.example.utsav.test.activity.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.model.Attendance;

import java.util.ArrayList;

/**
 * Created by utsav on 14-04-2017.
 */

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {
    private ArrayList<Attendance> attendanceArrayList = new ArrayList<>();
    private Context context;

    @Override
    public AttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_attendance, parent, false);
        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttendanceViewHolder holder, int position) {
        Attendance attendance = attendanceArrayList.get(position);
        holder.tvAttendanceName.setText("");


    }

    @Override
    public int getItemCount() {
        return attendanceArrayList.size();
    }

    static class AttendanceViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvAttendanceName;
        private AppCompatCheckBox cbAttendance;

        public AttendanceViewHolder(View itemView) {
            super(itemView);
            tvAttendanceName = (AppCompatTextView) itemView.findViewById(R.id.tv_attendance_name);
            cbAttendance = (AppCompatCheckBox) itemView.findViewById(R.id.cb_attendance);
        }
    }
}
