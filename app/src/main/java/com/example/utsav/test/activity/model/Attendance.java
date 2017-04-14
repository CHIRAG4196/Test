package com.example.utsav.test.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by utsav on 14-04-2017.
 */

public class Attendance implements Parcelable {
    public static final Parcelable.Creator<Attendance> CREATOR = new Parcelable.Creator<Attendance>() {
        @Override
        public Attendance createFromParcel(Parcel source) {
            return new Attendance(source);
        }

        @Override
        public Attendance[] newArray(int size) {
            return new Attendance[size];
        }
    };
    private int id;
    private String date, time, status;
    private User user;


    public Attendance() {
    }

    protected Attendance(Parcel in) {
        this.id = in.readInt();
        this.date = in.readString();
        this.time = in.readString();
        this.status = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.date);
        dest.writeString(this.time);
        dest.writeString(this.status);
        dest.writeParcelable(this.user, flags);
    }
}
