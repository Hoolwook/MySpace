package com.example.a.a05_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "vlaue: "+ list[position], Toast.LENGTH_SHORT).show();
            }
        });
    }



}
