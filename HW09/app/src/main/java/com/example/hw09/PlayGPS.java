package com.example.hw09;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class PlayGPS extends Service {
    String GPS_FILTER = "matos.action.GPSFIX";
    Thread serviceThread;
    LocationManager lm;
    GPSListener myLocationListener;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e(" << MyGpsService - onStart >>", "I am alive - GPS !");
        serviceThread = new Thread(new Runnable() {
            public void run() {
                getGPSFix_Version2(); // uses GPS chip provider
            }// run
        });
        serviceThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("<<MyGpsService-onDestroy>>", "I am dead-GPS");
        try {
            lm.removeUpdates(myLocationListener);
            //isRunning = false;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
        }
    }

    public void getGPSFix_Version2() {
        try {
            Looper.prepare();
            // try to get your GPS location using the LOCATION.SERVIVE provider
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            // This listener will catch and disseminate location updates
            myLocationListener = new GPSListener();
            // define update frequency for GPS readings
            long minTime = 2000; // 2 seconds
            float minDistance = 0; // 5 meter
            // request GPS updates

            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, myLocationListener);
            Looper.loop();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    private class GPSListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude(), longitude = location.getLongitude();
            Intent myFilteredResponse = new Intent(GPS_FILTER);
            myFilteredResponse.putExtra("latitude", latitude);
            myFilteredResponse.putExtra("longitude", longitude);
            myFilteredResponse.putExtra("provider", location.getProvider());
            Log.e(">>GPS_Service<<", "Lat:" + latitude + " lon:" + longitude);
            sendBroadcast(myFilteredResponse);
        }

        public void onProviderDisabled(String provider) { }
        public void onProviderEnabled(String provider) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }

    }
}
