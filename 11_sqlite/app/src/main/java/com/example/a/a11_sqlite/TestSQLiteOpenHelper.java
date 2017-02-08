package com.example.a.a11_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a on 2017-02-08.
 */

public class TestSQLiteOpenHelper  extends SQLiteOpenHelper{
    public TestSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL = "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name TEXT ,age INTEGER , address TEXT";
        db.execSQL(strSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSQL = "DROP TABLE IF EXISTS student";
        db.execSQL(strSQL);
        onCreate(db);

    }
}
