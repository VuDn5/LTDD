package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity3 extends AppCompatActivity {

    EditText txtUsername, txtPassword, txtRetype, txtBirthDate;
    RadioButton radMale;
    CheckBox chkTennis, chkFutBal, chkOthers;
    Button btnReset, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        AddControls();
        AddEvents();
    }

    public void AddControls()
    {
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtRetype = findViewById(R.id.txtRetype);
        txtBirthDate = findViewById(R.id.dtpBirhtDate);
        radMale = findViewById(R.id.radMale);
        chkTennis = findViewById(R.id.chkTennis);
        chkFutBal = findViewById(R.id.chkFutbal);
        chkOthers = findViewById(R.id.chkOthers);
        btnReset = findViewById(R.id.btnReset);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    public void AddEvents()
    {
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtRetype.setText("");
                txtBirthDate.setText("");
                radMale.setChecked(true);
                chkTennis.setChecked(false);
                chkFutBal.setChecked(false);
                chkOthers.setChecked(false);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity3.this, MainActivity4.class);

                Bundle bundle = new Bundle();

                bundle.putString ("Username", txtUsername.getText().toString());
                bundle.putString ("Password", txtPassword.getText().toString());
                bundle.putString ("Retype", txtRetype.getText().toString());
                bundle.putString ("BirthDate", txtBirthDate.getText().toString());
                bundle.putBoolean ("Male", radMale.isChecked());
                bundle.putBoolean ("Tennis", chkTennis.isChecked());
                bundle.putBoolean ("FutBal", chkFutBal.isChecked());
                bundle.putBoolean ("Others", chkOthers.isChecked());

                intent.putExtras(bundle);

                startActivityForResult(intent, 1122);
            }
        });

    }
}