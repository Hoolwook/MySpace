package com.example.a.a22_fragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.Frame);
        switch (v.getId()){
            case R.id.btnAdd:
                if(fragment == null){
                    fragment = new BlankFragment();
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.Frame, fragment, "counter");
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fragment != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fragment);
                    tr.commit();
                    fm.popBackStack();
                }
                break;
            case R.id.btnReplace:
                if(fragment != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fragment.getTag().equals("counter")){
                        textFragment textFragment = new textFragment();
                        tr.replace(R.id.Frame, textFragment, "text");
                    }else{
                        BlankFragment blankFragment = new BlankFragment();
                        tr.replace(R.id.Frame, blankFragment, "counter");
                    }
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnHide:
                if(fragment != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fragment.isHidden()) {
                        tr.show(fragment);
//                        tr.addToBackStack(null);
                    }else {
                        tr.hide(fragment);
//                        fm.popBackStack();
                    }

                    tr.commit();
                }
                break;
        }
    }
}
