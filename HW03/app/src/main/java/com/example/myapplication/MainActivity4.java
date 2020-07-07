package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    TextView txtUsername, txtPassword, txtBirthDate, txtGender, txtHobbis;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        AddControls();
        AddEvents();
    }

    public void AddControls()
    {
        txtUsername = findViewById(R.id.tvUsername);
        txtPassword = findViewById(R.id.tvPassword);
        txtBirthDate = findViewById(R.id.tvBirthDate);
        txtGender = findViewById(R.id.tvGender);
        txtHobbis = findViewById(R.id.tvHobbies);

        btnExit = findViewById(R.id.btnExit);
    }

    public void AddEvents()
    {
        ActivityReceiver();

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    public void ActivityReceiver()
    {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        boolean isMale = bundle.getBoolean("Male");
        boolean isTennis = bundle.getBoolean("Tennis");
        boolean isFutBal = bundle.getBoolean("FutBal");
        boolean isOthers = bundle.getBoolean("Others");
        String hobbies = (isTennis ? "Tennis, " : "") + (isFutBal ? "FutBal, " : "") + (isOthers ? "Others" : "") ;

        txtUsername.setText(txtUsername.getText() + bundle.getString("Username"));
        txtPassword.setText(txtPassword.getText() + bundle.getString("Password"));
        txtBirthDate.setText(txtBirthDate.getText() + bundle.getString("BirthDate"));

        if (isMale = true)
            txtGender.setText(txtGender.getText() + "Male");
        else
            txtGender.setText(txtGender.getText() + "Female");

        txtHobbis.setText(hobbies);
    }
}