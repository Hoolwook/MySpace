package com.example.a.myexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        String weather;
        Float temperature;
        int day;
        int hour;
    }


    class weatherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.custlist ,null);
            }
            TextView textView1 = (TextView) convertView.findViewById(R.id.custText1);
            TextView textView2 = (TextView) convertView.findViewById(R.id.custText2);
            WeatherData data = list.get(position);
            String info1 = "날씨 : "+ data.weather + " , 온도 : " + data.temperature;
            Date date = new Date();
            date.setHours(data.hour);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시");

            String info2 = sdf.format(date);
            textView1.setText(info1);
            textView2.setText(info2);


            return convertView;
        }
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
                    myData.weather = "비";
                    break;
                case 2:
                    myData.weather = "눈";
                    break;
                case 3:
                    myData.weather = "맑음";
                    break;
            }

            myData.temperature = 10.0f;
            myData.day = (i*3)/24 ;
            myData.hour = (i*3)%24;
            list.add(myData);
        }

        ListView listView = (ListView) findViewById(R.id.myCustList);
        weatherAdapter adapter = new weatherAdapter();
        listView.setAdapter(adapter);

    }
}
