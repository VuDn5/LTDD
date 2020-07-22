package com.example.hw04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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

    FragmentTransaction ft;
    redFragment redFragment;
    blueFragment blueFragment;

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
        ft = getSupportFragmentManager().beginTransaction();
        blueFragment = blueFragment.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, blueFragment);
        ft.commit();

        ft = getSupportFragmentManager().beginTransaction();
        redFragment = redFragment.newInstance("first-red");
        ft.replace(R.id.main_holder_red, redFragment);
        ft.commit();
    }

    private void AddEvents()
    {
        /*
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //BanTin item = dsBanTin.get(position);
                User item = listUser.get(position);

                tvYourChoose.setText("Your Choose: " + item.getName());
            }

        });

         */
    }

    private void LoadDataListView()
    {
        //get data userAdapter
       /* listUser = new ArrayList<User>();
        listUser = CreateData();

        userAdapter = new UserAdapter(MainActivity.this, R.layout.item, listUser);
        lv_item.setAdapter(userAdapter);
        */

    }

    public ArrayList<User> CreateData() {
        ArrayList<User> ds = new ArrayList<User>();

        User user1 = new User("Nguyễn Văn A", "01234567890");
        User user2 = new User("Lê Thị B", "0334444512");
        User user3 = new User("Trần Văn C", "04743917424");
        User user4 = new User("Phan Văn D", "033513523");
        User user5 = new User("Đinh E", "0988885231");

        ds.add(user1);
        ds.add(user2);
        ds.add(user3);
        ds.add(user4);
        ds.add(user5);

        return ds;
    }



}