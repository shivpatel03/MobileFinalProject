package com.example.mobileappdevfinalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MRKTPLCE";
    private static final String LISTING_TABLE = "LISTINGS";
    private static final String USER_TABLE = "USERS";

    public DatabaseHelper(@Nullable Context context) {
        super (context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create user table
        db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE +
                "(" +
                "user_id PRIMARY KEY AUTOINCREMENT," +
                "username VARCHAR(255) NOT NULL UNIQUE," +
                "password VARCHAR(255) NOT NULL" +
                ")");

        // create listing table
        db.execSQL("CREATE TABLE IF NOT EXISTS " + LISTING_TABLE +
                "(" +
                "listing_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title VARCHAR(255) NOT NULL," +
                "user_id INTEGER NOT NULL," +
                "description TEXT," +
                "cost DECIMAL(10,2)," +
                "condition TEXT CHECK(condition IN ('Brand new', 'Used, like new', 'Heavily Used')) NOT NULL," +
                "FOREIGN KEY(user_id) REFERENCES USER(user_id) ON DELETE CASCADE" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LISTING_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }
}
