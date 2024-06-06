package com.example.sklep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "orders.db";
    public static final String TABLE_NAME = "orders";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "COMPUTER";
    public static final String COL_3 = "KEYBOARD";
    public static final String COL_4 = "MOUSE";
    public static final String COL_5 = "OTHER";
    public static final String COL_6 = "PRICE";
    public static final String COL_7 = "DATE";
    public static final String COL_8 = "NAME";
    public static final String COL_9 = "IMAGES";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, COMPUTER TEXT, KEYBOARD TEXT, MOUSE TEXT, OTHER TEXT, PRICE TEXT, DATE TEXT, NAME TEXT, IMAGES TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String computer, String keyboard, String mouse, String other, String price, String date, String name, String images) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, computer);
        contentValues.put(COL_3, keyboard);
        contentValues.put(COL_4, mouse);
        contentValues.put(COL_5, other);
        contentValues.put(COL_6, price);
        contentValues.put(COL_7, date);
        contentValues.put(COL_8, name);
        contentValues.put(COL_9, images);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
