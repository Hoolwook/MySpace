package com.example.a.a02_exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    class WeatherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return weatherList.size();
        }

        @Override
        public Object getItem(int position) {
            return weatherList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.custlistview, null);
            }
            TextView textView1 = (TextView)convertView.findViewById(R.id.weatherInfo1);
            TextView textView2 = (TextView)convertView.findViewById(R.id.weatherInfo2);
            WeatherData data = weatherList.get(position);
            String info1 = "날씨 : "+data.weather + ", 온도 : "+ data.temperature;
            Date date = new Date();
            date.setDate(date.getDate() + data.day);
            date.setHours(data.hour);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일  HH시");
            String info2 = sdf.format(date);
            textView1.setText(info1);
            textView2.setText(info2);
            return convertView;
        }
    }
    ArrayList<WeatherData> weatherList = new ArrayList<>();
    WeatherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.custListView);
        adapter = new WeatherAdapter();
        listView.setAdapter(adapter);

        initData();
    }

    private void initData() {
        weatherList.clear();
        WeatherPullParser parser = new WeatherPullParser(weatherList, adapter);
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000");
    }

    public void onReloadClick(View v){
        initData();
    }
}
