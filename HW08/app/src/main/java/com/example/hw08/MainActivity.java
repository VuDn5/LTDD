package com.example.hw08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String KeyChannel = "key";
    public static final String IsChannel = "isChannel";
    Button btnThanhNien, btnVNExpress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        AddEvents();
    }

    private void AddControls()
    {
        btnThanhNien = findViewById(R.id.btnThanhNien);
        btnVNExpress = findViewById(R.id.btnVNExpress);

    }

    private void AddEvents()
    {
        btnThanhNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code btnThanhNien
                //Here************
                CallChannel("TN");//ThanhNien
            }
        });

        btnVNExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code btnVNExpress
                //Here************
                CallChannel("VNE");//VNExpress
            }
        });

    }

    private void CallChannel(String key)
    {
        Intent intent = new Intent(MainActivity.this, Channel.class);
        intent.putExtra(KeyChannel, key);
        intent.putExtra(IsChannel, true );
        startActivity(intent);
    }

}