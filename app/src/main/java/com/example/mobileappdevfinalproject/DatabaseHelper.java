package com.example.mobileappdevfinalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    @SuppressLint("Range")
    public List<Listings> getListingsFromUserId(int user_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LISTINGS WHERE user_id = " + user_id, null);

        List<Listings> listings = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("listing_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                int user = cursor.getInt(cursor.getColumnIndex("user_id"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                double cost = cursor.getDouble(cursor.getColumnIndex("cost"));
                String condition = cursor.getString(cursor.getColumnIndex("condition"));

                Listings location = new Listings(id, title, user, description, cost, condition);
                listings.add(location);
            } while (cursor.moveToNext());

        }

        cursor.close();
        db.close();

        return listings;
    }

    @SuppressLint("Range")
    public List<Listings> getAllListings() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LISTINGS", null);

        List<Listings> listings = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("listing_id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                int user = cursor.getInt(cursor.getColumnIndex("user_id"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                double cost = cursor.getDouble(cursor.getColumnIndex("cost"));
                String condition = cursor.getString(cursor.getColumnIndex("condition"));

                Listings location = new Listings(id, title, user, description, cost, condition);
                listings.add(location);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listings;
    }
}
