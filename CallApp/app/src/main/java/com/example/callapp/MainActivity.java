package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.callapp.Adapter.UserAdapter;
import com.example.callapp.Data.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCall;
    EditText txtNumberCall;

    Button key0;
    Button key1;
    Button key2;
    Button key3;
    Button key4;
    Button key5;
    Button key6;
    Button key7;
    Button key8;
    Button key9;

    Button keyClear;
    Button keyBack;

    ListView lv_item;

    ArrayList<User> listUser;
    UserAdapter userAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();

        //LoadDataListView();

        AddEvents();
    }

    private void AddControls()
    {
        txtNumberCall = findViewById(R.id.txtNumberCall);

        btnCall = findViewById(R.id.btnCall);
        key0 = findViewById(R.id.t9_key_0);
        key1 = findViewById(R.id.t9_key_1);
        key2 = findViewById(R.id.t9_key_2);
        key3 = findViewById(R.id.t9_key_3);
        key4 = findViewById(R.id.t9_key_4);
        key5 = findViewById(R.id.t9_key_5);
        key6 = findViewById(R.id.t9_key_6);
        key7 = findViewById(R.id.t9_key_7);
        key8 = findViewById(R.id.t9_key_8);
        key9 = findViewById(R.id.t9_key_9);

        keyClear = findViewById(R.id.t9_key_clear);
        keyBack = findViewById(R.id.t9_key_backspace);

        lv_item = findViewById(R.id.lvItem);
    }

    private void AddEvents()
    {
        key0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumberCall.setText(txtNumberCall.getText().toString() + key0.getText().toString());
            }
        });


        AddEventst9_key(key1);
        AddEventst9_key(key2);
        AddEventst9_key(key3);
        AddEventst9_key(key4);
        AddEventst9_key(key5);
        AddEventst9_key(key6);
        AddEventst9_key(key7);
        AddEventst9_key(key8);
        AddEventst9_key(key9);

/*
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //BanTin item = dsBanTin.get(position);
                User item = listUser.get(position);
            }

        });
        */

    }

    private void AddEventst9_key(final Button key)
    {
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumberCall.setText(txtNumberCall.getText().toString() + key.getText().toString());
            }
        });
    }

    private void LoadDataListView()
    {
        //get data userAdapter
        listUser = new ArrayList<User>();
        listUser = CreateData();

        userAdapter = new UserAdapter(MainActivity.this, R.layout.item, listUser);
        lv_item.setAdapter(userAdapter);
    }

    public ArrayList<User> CreateData() {
        ArrayList<User> ds = new ArrayList<User>();

        User user1 = new User("User 1" , "0123456789");
        User user2 = new User("User 2" , "0123456780");
        User user3 = new User("User 3" , "0123456781");
        User user4 = new User("User 4" , "0123456782");
        User user5 = new User("User 5" , "0123456783");

        ds.add(user1);
        ds.add(user2);
        ds.add(user3);
        ds.add(user4);
        ds.add(user5);


        return ds;
    }


}