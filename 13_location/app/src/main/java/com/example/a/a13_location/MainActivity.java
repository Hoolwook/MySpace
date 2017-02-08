package com.example.a.a13_location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);
        String str = "";
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        for(String p : providers){
            str += "provider : " +p+ "state"+
                    manager.isProviderEnabled(p) +"\n";
        }
        myTextView.setText(str);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 1000, 1.0f , listener);
        manager.requestLocationUpdates(LocationManager,NETWORK_STATS_SERVICE ,1000, 1.0f , listener);

    }
}
