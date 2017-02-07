package com.example.a.a05_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    String[] list = {"Hello" , "World" , "Oracle" , "java",
            "Hello" , "World" , "Oracle" , "java",
            "Hello" , "World" , "Oracle" , "java",
            "Hello" , "World" , "Oracle" , "java"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.MyListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,android.R.layout.simple_list_item_1,list

        );
        listView.setAdapter(adapter);
    }



}
