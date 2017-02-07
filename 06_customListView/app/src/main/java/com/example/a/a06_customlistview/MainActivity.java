package com.example.a.a06_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.BaseMenuPresenter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class myData{
        String title;
        String desc;
        int imgIcon;
    }

    ArrayList<myData> list = new ArrayList<myData>();

    class MyAdapter extends BaseAdapter{

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
                convertView = getLayoutInflater().inflate(R.layout.item_view, null);

            }
            TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
            TextView descView = (TextView) convertView.findViewById(R.id.descView);
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.itemIcon);

            myData data = list.get(position);
            titleTextView.setText(data.title);
            descView.setText(data.desc);
            imgIcon.setImageResource(data.imgIcon);

            return convertView;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<20; i++){
           myData data = new myData();
            data.title = "myTitle" + i;
            data.desc = "myDesc" + i;
            if(i%2==0) {
                data.imgIcon = R.mipmap.ic_launcher;
            }else{

            }
            list.add(data);

        }

        ListView listView = (ListView) findViewById(R.id.myListView);
        listView.setAdapter();

    }
}
