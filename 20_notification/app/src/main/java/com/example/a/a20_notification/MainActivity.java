package com.example.a.a20_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //LargeIcon에 담기위해 비트맵세팅
        Bitmap bitmap =
                BitmapFactory.decodeResource(getResources(),R.drawable.hydrangeas);
        Intent intent = new Intent(this, NotiActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("title");
        builder.setContentText("text");
        builder.setSubText("subText");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);


        manager.notify(1234 , builder.build());
    }
}
