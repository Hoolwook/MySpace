package com.example.a.a17_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("my Service" , "onCreate");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("my Service" , "onStartCommand");
        return START_STICKY;

//        return START_NOT_STICKY  서비스를 재실행하지 않음

//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("my Service" , "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
