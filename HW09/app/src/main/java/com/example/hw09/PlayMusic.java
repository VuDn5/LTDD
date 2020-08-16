package com.example.hw09;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PlayMusic extends Service {
    public static boolean boolIsServiceCreated = false;
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Toast.makeText(this, "MyService4 Created", Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onCreate");
        boolIsServiceCreated = true;
        player = MediaPlayer.create(getApplicationContext(), R.raw.lyly_magazine);
    }

    @Override
    public  void onStart(Intent intent, int startid){
        if (player.isPlaying())
            Toast.makeText(this, "MyService4 Already Started " + startid, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "MyService4 Started " + startid, Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onStart");
        player.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService4 Stopped", Toast.LENGTH_LONG).show();
        Log.e("MyService4", "onDestroy");
        player.stop(); player.release(); player = null;
    }
}
