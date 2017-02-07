package com.example.a.myexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        String weather;
        Float temperature;
        int day;
        int hour;
    }

    ArrayList<WeatherData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0 ; i<20 ; i++){
            WeatherData myData = new WeatherData();

            switch (i%4){
                case 0:
                    myData.weather = "흐림";
                    break;
                case 1:
                    myData.weather = "맑음";
                    break;
                case 2:
                    myData.weather = "비";
                    break;
                case 3:
                    myData.weather = "눈";
                    break;
            }

            myData.temperature = 10.0f;
            myData.day = (i*3)/24 ;
            myData.hour = (i*3)%24;
            list.add(myData);
        }

        ListView listView = (ListView) findViewById(R.id.myCustList);

    }
}
