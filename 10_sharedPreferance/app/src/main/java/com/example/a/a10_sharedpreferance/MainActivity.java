package com.example.a.a10_sharedpreferance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("mySetting", MODE_PRIVATE);
        // key 값 디폴트파리미터
        String id = pref.getString("id", "");


        // 비밀번호는 비적합
        Toast.makeText(this, "id :" + id, Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void  onStop() {
            super.onStop();

        SharedPreferences pref =getSharedPreferences("mySetting", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id" , "asdf");
        //저장할때는 commit;
        editor.commit();
    }


}

