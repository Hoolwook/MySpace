package com.example.a.a20_notification;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1234);
    }
}
