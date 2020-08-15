package com.example.hw09;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int LOCATION_PERMISSION_CODE = 100;
    TextView txtMsg;
    Intent intentCallService4, intentCallService5, intentCallService6;
    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartMusic).setOnClickListener(this);
        findViewById(R.id.btnStopMusic).setOnClickListener(this);
        findViewById(R.id.btnStartFibo).setOnClickListener(this);
        findViewById(R.id.btnStopFibo).setOnClickListener(this);
        findViewById(R.id.btnStopFibo).setOnClickListener(this);
        findViewById(R.id.btnStartGPS).setOnClickListener(this);
        findViewById(R.id.btnStopGPS).setOnClickListener(this);
        Log.e("MAIN", "Main started");
        txtMsg = findViewById(R.id.txtMsg);

        intentCallService4 = new Intent(this, PlayMusic.class);
        intentCallService5 = new Intent(this, PlayFibo.class);
        intentCallService6 = new Intent(this, PlayGPS.class);

        IntentFilter filter5 = new IntentFilter("matos.action.GOSERVICE5");
        IntentFilter filter6 = new IntentFilter("matos.action.GPSFIX");

        //register
        receiver = new MyEmbeddedBroadcastReceiver();
        registerReceiver(receiver, filter5);
        registerReceiver(receiver, filter6);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStartMusic){
            Log.e("MAIN", "onClick: starting service music");
            startService(intentCallService4);
        }
        else if (view.getId() == R.id.btnStopMusic){
            Log.e("MAIN", "onClick: stopping service music");
            stopService(intentCallService4);
        }
        if(view.getId() == R.id.btnStartFibo){
            Log.e("MAIN", "onClick: starting service fibonacci");
            startService(intentCallService5);
        }
        else if (view.getId() == R.id.btnStopFibo){
            Log.e("MAIN", "onClick: stopping service fibonacci");
            stopService(intentCallService5);
        }
        if(view.getId() == R.id.btnStartGPS){

            //request permission locatition
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[] { Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION  },
                        LOCATION_PERMISSION_CODE);
                return;
            }
            else {
                Log.e("MAIN", "onClick: starting service gps");
                startService(intentCallService6);
            }

        }
        else if (view.getId() == R.id.btnStopGPS){
            Log.e("MAIN", "onClick: stopping service gps");
            stopService(intentCallService6);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);
    }


    public class MyEmbeddedBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("MAIN >>", "ACTION: " + intent.getAction());
            if(intent.getAction().equals("matos.action.GOSERVICE5")){
                String service5Data = intent.getStringExtra("MyService5DataItem");
                Log.e("MAIN>>", "Data received from Service5: " + service5Data);
                txtMsg.append("\nService5Data: > " + service5Data);
            }
            else if (intent.getAction().equals("matos.action.GPSFIX")){
                double latitude = intent.getDoubleExtra("latitude", -1);
                double longitude = intent.getDoubleExtra("longitude", -1);
                String provider = intent.getStringExtra("provider");
                String service6Data = provider + " lat: " + Double.toString(latitude)
                        + " lon: " + Double.toString(longitude);
                Log.e("MAIN>>", "Data received from Service6:" + service6Data);
                txtMsg.append("\nService6Data: > "+ service6Data);
            }
        }
    }
}