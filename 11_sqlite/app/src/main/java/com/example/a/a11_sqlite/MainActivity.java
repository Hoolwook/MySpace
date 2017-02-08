package com.example.a.a11_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.myTextView);
        //TestSQLiteHandler 선언
        TestSQLiteHandler dbHandler = new TestSQLiteHandler(this);
        dbHandler.insert("kim" , 10 , "서울");
        dbHandler.insert("jun" , 7 , "대전");
        dbHandler.insert("dong" , 17 , "대구");

        dbHandler.update("hello" , 13);

        String str = dbHandler.SelectAll();
        textView.setText(str);
    }
}
