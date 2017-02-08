package com.example.a.a11_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by a on 2017-02-08.
 */

public class TestSQLiteHandler {
    TestSQLiteOpenHelper helper;
    public TestSQLiteHandler(Context context){
        // 오픈헬퍼생성
        helper = new TestSQLiteOpenHelper(context , "people", null,1);
    }
    public void insert(String name , int age , String address){
        SQLiteDatabase db = helper.getWritableDatabase();

        // ContentValues 에 담고
        ContentValues values = new ContentValues();
        values.put("name" , name);
        values.put("age" , age);
        values.put("address" , address);

        // 디비 insert
        db.insert("student",null,values);

    }

    public  void  delete(String name){
        SQLiteDatabase db= helper.getWritableDatabase();
        db.delete("student","name = ?", new String[]{name});

    }

    public void update(String name , int newAge){
        SQLiteDatabase db = helper.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put("age" , newAge);

        db.update("student", values , "name = ?" , new String[]{name});

    }

    public String  SelectAll(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String res = "";

        Cursor c = db.query("student" , null ,null ,null ,null ,null ,null );
        while(c.moveToNext()){
            String name = c.getString( c.getColumnIndex("name"));
            int age = c.getInt( c.getColumnIndex("age"));
            String address = c.getString( c.getColumnIndex("address"));

            res += "name"+ name + "age"+ age + "address" + address + "\n";
        }

        return res;
    }

}
