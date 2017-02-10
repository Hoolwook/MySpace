package com.example.a.a02_exam;

/**
 * Created by a on 2017-02-10.
 */
public class WeatherData{
    String weather;
    float temperature;
    int day;
    int hour;

    @Override
    public String toString() {
        String res = "day : "+day+" hour : "+hour+
                " temp : "+temperature+" wfKor : "+weather;
        return res;
    }
}