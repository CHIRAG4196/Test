package com.example.utsav.test.activity.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by utsav on 14-04-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "user";
    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_PASSWORD = "user_password";
    private static final String USER_MOBILE_NO = "user_mobile_no";
    private static final String USER_IDENTITY = "user_identity";
    private static final String USER_GENDER = "user_gender";


    private static final String TABLE_ATTENDANCE = "attendance";
    private static final String ATTENDANCE_ID = "attendance_id";
    private static final String ATTENDANCE_DATE = "attendance_date";
    private static final String ATTENDANCE_TIME = "attendance_time";
    private static final String ATTENDANCE_STATUS = "attendance_status";


    private static final String TABLE_BATCH = "batch";
    private static final String BATCH_ID = "batch_id";
    private static final String BATCH_NAME = "batch_name";

    private static final String CREATE_TABLE_BATCH = "" +
            "create table " + TABLE_BATCH + " (" +
            BATCH_ID + " INTEGER PRIMARY KEY, " +
            BATCH_NAME + " TEXT)";


    private static final String CREATE_TABLE_ATTENDANCE = "" +
            "create table " + TABLE_ATTENDANCE + " (" +
            ATTENDANCE_ID + " INTEGER PRIMARY KEY, " +
            USER_ID + " INTEGER, " +
            ATTENDANCE_DATE + " TEXT, " +
            ATTENDANCE_TIME + " TEXT, " +
            ATTENDANCE_STATUS + " TEXT, " +
            BATCH_ID + " INTEGER)";


    private static final String CREATE_TABLE_USER = "" +
            "create table " + TABLE_USER + " (" +
            USER_ID + " INTEGER PRIMARY KEY, " +
            USER_NAME + " TEXT, " +
            USER_EMAIL + " TEXT, " +
            USER_PASSWORD + " TEXT, " +
            USER_MOBILE_NO + " TEXT, " +
            USER_IDENTITY + " TEXT, " +
            USER_GENDER + " TEXT, " +
            BATCH_ID + " INTEGER)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_ATTENDANCE);
        db.execSQL(CREATE_TABLE_BATCH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATCH);

        onCreate(db);

    }
}
