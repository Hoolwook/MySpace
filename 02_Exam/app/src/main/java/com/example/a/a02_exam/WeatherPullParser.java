package com.example.a.a02_exam;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by a on 2017-02-10.
 */

public class WeatherPullParser extends AsyncTask<String, Void, String> {
    ArrayList<WeatherData> weatherList;
    MainActivity.WeatherAdapter adapter;
    enum DataType {none, hourType, dayType, tempType, wfKorType}
    DataType type = DataType.none;

    public WeatherPullParser(ArrayList<WeatherData> weatherList, MainActivity.WeatherAdapter adapter) {
        this.weatherList = weatherList;
        this.adapter = adapter;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected String doInBackground(String... params) {
        String res = "";
        try {
            XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
            URL url = new URL(params[0]);
            xpp.setInput(url.openStream(), "utf-8");
            int eventType = xpp.getEventType();
            WeatherData data = null;
            while(eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if(xpp.getName().equals("hour")){
                            type = DataType.hourType;
                            data = new WeatherData();
                            weatherList.add(data);
                        }else if(xpp.getName().equals("wfKor")){
                            type = DataType.wfKorType;
                        }else if (xpp.getName().equals("day")){
                            type = DataType.dayType;
                        }else if (xpp.getName().equals("temp")){
                            type = DataType.tempType;
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
                                data.temperature = Float.parseFloat(xpp.getText());
                                break;
                            case wfKorType:
                                data.weather = xpp.getText();
                                break;
                        }
                        type = DataType.none;
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xpp.next();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}