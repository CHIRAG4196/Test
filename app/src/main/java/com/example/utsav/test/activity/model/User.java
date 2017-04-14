package com.example.utsav.test.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by utsav on 14-04-2017.
 */

public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private int userId;
    private String name, email, password, mobileNo, identity, gender;
    private Batch batch;

    public User() {
    }

    protected User(Parcel in) {
        this.userId = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.mobileNo = in.readString();
        this.identity = in.readString();
        this.gender = in.readString();
        this.batch = in.readParcelable(Batch.class.getClassLoader());
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.mobileNo);
        dest.writeString(this.identity);
        dest.writeString(this.gender);
        dest.writeParcelable(this.batch, flags);
    }
}
