package com.example.a.a02_exam;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        int day;
        int hour;
        float temp;
        String wfKor;
        String wfEn;
        @Override
        public String toString() {
            String res = "day : "+day+" hour : "+hour+
                    " temp : "+temp+" wfKor : "+wfKor + "wfEn" + wfEn;
            return res;
        }
    }

    ArrayList<WeatherData> list = new ArrayList<>();
    enum DataType {none, hourType, dayType, tempType, wfKorType ,wfEnType }
    DataType type = DataType.none;
    TextView custTextView;
    ImageView custImage;

    class custPullParser extends AsyncTask<String , Void , String >{

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String res = "";
            for(WeatherData data : list){
                if(data.wfEn.toString().equals("wfEn")){
                    if(equals("clear")){
                        custImage.setImageResource(R.drawable.sunny);
                    }else if(equals("Partly Cloudy")){
                        custImage.setImageResource(R.drawable.cloud);
                    }else if(equals("snow")){
                        custImage.setImageResource(R.drawable.snow);
                    }else if(equals("rain")){
                        custImage.setImageResource(R.drawable.rain);
                    }
                }else{
                    res += data.toString()+"\n";
                }

            }
            custTextView.setText(res);
        }

        @Override
        protected String doInBackground(String... params) {
            String res = "";
            try {
                XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
                URL url = new URL(params[0]);
                xpp.setInput(url.openStream() , "utf-8");
                int eventType = xpp.getEventType();

                WeatherData data = null;

                while(eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_TAG:
                            if(xpp.getName().equals("hour")){
                                data = new WeatherData();
                                type = DataType.hourType;
                                list.add(data);
                            }else if(xpp.getName().equals("day")){
                                type = DataType.dayType;
                            }else if(xpp.getName().equals("temp")){
                                type = DataType.tempType;
                            }else if(xpp.getName().equals("wfKor")){
                                type = DataType.wfKorType;
                            }else if(xpp.getName().equals("wfEn")){
                                type = DataType.wfEnType;
                            }

                            break;
                        case XmlPullParser.TEXT:
                            switch (type){
                                case hourType:
                                    data.hour = Integer.parseInt(xpp.getText());
                                    break;
                                case dayType:
                                    data.day = Integer.parseInt(xpp.getText());
                                    break;
                                case tempType:
                                    data.temp = Float.parseFloat(xpp.getText());
                                    break;
                                case wfKorType:
                                    data.wfKor = xpp.getText();
                                    break;
                                case wfEnType:
                                    data.wfEn = xpp.getText();
                            }
                            type = DataType.none;
                            break;
                        case XmlPullParser.END_TAG:
                            break;

                    }
                    eventType = xpp.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return res;
        }
    }



    class WeatherAdapter extends BaseAdapter{
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
                convertView = getLayoutInflater().inflate(R.layout.custlistview, null);
            }
//            WeatherData data = list.get(position);





            return convertView;
        }
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custTextView = (TextView) findViewById(R.id.custTextWeather);
        custImage = (ImageView) findViewById(R.id.custImage);
        custPullParser task = new custPullParser();




        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000");
        task.cancel(true);

        ListView listView = (ListView) findViewById(R.id.custListView);



    }
}
