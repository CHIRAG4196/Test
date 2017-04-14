package com.example.utsav.test.activity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.utsav.test.activity.model.Attendance;
import com.example.utsav.test.activity.model.User;

import java.util.ArrayList;

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


    //    private static final String TABLE_BATCH = "batch";
//    private static final String BATCH_ID = "batch_id";
    private static final String BATCH_NAME = "batch_name";

//    private static final String CREATE_TABLE_BATCH = "" +
//            "create table " + TABLE_BATCH + " (" +
//            BATCH_ID + " INTEGER PRIMARY KEY, " +
//            BATCH_NAME + " TEXT)";


    private static final String CREATE_TABLE_ATTENDANCE = "" +
            "create table " + TABLE_ATTENDANCE + " (" +
            ATTENDANCE_ID + " INTEGER PRIMARY KEY, " +
            USER_ID + " INTEGER, " +
            ATTENDANCE_DATE + " TEXT, " +
            ATTENDANCE_TIME + " TEXT, " +
            ATTENDANCE_STATUS + " TEXT, " +
            BATCH_NAME + " TEXT)";


    private static final String CREATE_TABLE_USER = "" +
            "create table " + TABLE_USER + " (" +
            USER_ID + " INTEGER PRIMARY KEY, " +
            USER_NAME + " TEXT, " +
            USER_EMAIL + " TEXT, " +
            USER_PASSWORD + " TEXT, " +
            USER_MOBILE_NO + " TEXT, " +
            USER_IDENTITY + " TEXT, " +
            USER_GENDER + " TEXT, " +
            BATCH_NAME + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_ATTENDANCE);
//        db.execSQL(CREATE_TABLE_BATCH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTENDANCE);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BATCH);

        onCreate(db);

    }

    public void insertUserData(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_NAME, user.getName());
        contentValues.put(USER_EMAIL, user.getEmail());
        contentValues.put(USER_PASSWORD, user.getPassword());
        contentValues.put(USER_MOBILE_NO, user.getMobileNo());
        contentValues.put(USER_IDENTITY, user.getIdentity());
        contentValues.put(USER_GENDER, user.getGender());
        contentValues.put(BATCH_NAME, user.getBatchName());
        database.insert(TABLE_USER, null, contentValues);
        database.close();
    }

    public void insertAttendanceData(Attendance attendance) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_ID, String.valueOf(attendance.getUser()));
        contentValues.put(ATTENDANCE_DATE, attendance.getDate());
        contentValues.put(ATTENDANCE_STATUS, attendance.getStatus());
        contentValues.put(ATTENDANCE_TIME, attendance.getTime());
//        contentValues.put(BATCH_ID, String.valueOf(attendance.getBatch()));
        database.insert(TABLE_ATTENDANCE, null, contentValues);
        database.close();
    }

    public ArrayList<User> getAllUserData() {
        ArrayList<User> userArrayList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from " + TABLE_USER, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        do {
            User user = new User();
            user.setUserId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));
            user.setMobileNo(cursor.getString(4));
            user.setGender(cursor.getString(5));
            user.setIdentity(cursor.getString(6));
            user.setBatchName(cursor.getString(7));
            userArrayList.add(user);
        } while (cursor.moveToNext());
        cursor.close();
        database.close();
        return userArrayList;
    }

    public long getUserCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long cnt = DatabaseUtils.queryNumEntries(db, TABLE_USER);
        db.close();
        return cnt;
    }

//    public void insertBatchData(Batch batch) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(BATCH_NAME, batch.getName());
////        contentValues.put(BATCH_ID, batch.getId());
//        database.insert(TABLE_ATTENDANCE, null, contentValues);
//        database.close();
//
//
//    }
}
