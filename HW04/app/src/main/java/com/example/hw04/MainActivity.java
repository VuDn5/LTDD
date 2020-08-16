package com.example.hw04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hw04.Adapter.UserAdapter;
import com.example.hw04.Data.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvYourChoose;
    ListView lv_item;

    ArrayList<User> listUser;
    UserAdapter userAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();

        LoadDataListView();

        AddEvents();
    }

    private void AddControls()
    {
        tvYourChoose = findViewById(R.id.tvYourChoose);
        lv_item = findViewById(R.id.list_item);
    }

    private void AddEvents()
    {
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //BanTin item = dsBanTin.get(position);
                User item = listUser.get(position);

                tvYourChoose.setText("Your Choose: " + item.getName());
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

        User user1 = new User("THE THEO", "tn_TheTheo");
        User user2 = new User("THE DUC", "tn_TheDuc");
        User user3 = new User("KINH TE", "tn_KinhThe");
        User user4 = new User("PHAP LUAP", "tn_PhapLuat");

        ds.add(user1);
        ds.add(user2);
        ds.add(user3);
        ds.add(user4);
        return ds;
    }



}