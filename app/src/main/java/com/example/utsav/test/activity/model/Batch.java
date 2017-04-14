package com.example.utsav.test.activity.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by utsav on 14-04-2017.
 */

public class Batch implements Parcelable {
    public static final Parcelable.Creator<Batch> CREATOR = new Parcelable.Creator<Batch>() {
        @Override
        public Batch createFromParcel(Parcel source) {
            return new Batch(source);
        }

        @Override
        public Batch[] newArray(int size) {
            return new Batch[size];
        }
    };
    private int id;
    private String name;

    public Batch() {
    }

    protected Batch(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }
}
