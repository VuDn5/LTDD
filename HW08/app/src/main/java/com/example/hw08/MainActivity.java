package com.example.hw08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String KeyChannel = "key";
    public static final String NameChannel = "name";
    public static final String IsChannel = "isChannel";
    Button btnThanhNien, btnVNExpress, btnTuoiTre, btnVietNamNet;


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
        btnTuoiTre = findViewById(R.id.btnTuoiTre);
        btnVietNamNet = findViewById(R.id.btnVietNamNet);
    }

    private void AddEvents()
    {
        btnThanhNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code btnThanhNien
                //Here************
                CallChannel("TN", "Thanh niên");//ThanhNien
            }
        });

        btnVNExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code btnVNExpress
                //Here************
                CallChannel("VNE", "VnExpress");//VNExpress
            }
        });

        btnTuoiTre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallChannel("TT", "Tuổi trẻ");//TuoiTre
            }
        });

        btnVietNamNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallChannel("VIENET", "VietNamNet");//VietNam Net
            }
        });
    }

    private void CallChannel(String key, String name)
    {
        Intent intent = new Intent(MainActivity.this, Channel.class);
        Bundle myData = new Bundle();
        myData.putString(KeyChannel, key);
        myData.putString(NameChannel, name);
        myData.putBoolean(IsChannel, true);
        intent.putExtras(myData);
//        intent.putExtra(KeyChannel, key);
//        intent.putExtra(IsChannel, true );
        startActivity(intent);
    }

}