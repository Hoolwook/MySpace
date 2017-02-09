package com.example.a.a16_br2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(intent.ACTION_BATTERY_CHANGED)){
                int value= intent.getIntExtra("level",0);
                Toast.makeText(context, "battery : " + value , Toast.LENGTH_SHORT).show();
            }else if(action.equals(intent.ACTION_BATTERY_LOW)){
                Toast.makeText(context, "battery is low" , Toast.LENGTH_SHORT).show();
            }else if(action.equals("Nideren")){
                Toast.makeText(context, "my broadcast", Toast.LENGTH_SHORT).show();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        // 버튼의 인텐트를 받을 준비
        filter.addAction("Nideren");
        
        
        
        
        registerReceiver(receiver,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);

    }
    
    public void onBtnClick(View v){         
        Intent intent = new Intent("Nideren");
        sendBroadcast(intent);
    }
    
}
