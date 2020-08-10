package com.example.hw08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hw08.Adapter.ItemChannelAdapter;
import com.example.hw08.Data.ItemChannel;

import java.util.ArrayList;

public class Channel extends AppCompatActivity {

    TextView txtYourChoose;
    ListView lv_item;

    ArrayList<ItemChannel> arrItem;
    ItemChannelAdapter itemChannelAdapter = null;
    String KeyChannel = "";
    Boolean IsChannel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        AddControls();
        GetDatas();
        LoadDataListView();
        AddEvents();

    }

    private void AddControls()
    {
        txtYourChoose = findViewById(R.id.tvYourChoose);
        lv_item = findViewById(R.id.list_item);

    }

    private void AddEvents()
    {
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemChannel item = arrItem.get(i);
                CallItem(item.getKey());
            }
        });
    }

    private void GetDatas()
    {
        Intent intent = getIntent();
        KeyChannel = intent.getStringExtra(MainActivity.KeyChannel);
        IsChannel = intent.getBooleanExtra(MainActivity.IsChannel, false);
        // Capture the layout's TextView and set the string as its text
        txtYourChoose.setText(KeyChannel);
    }

    private void LoadDataListView()
    {
        arrItem = new ArrayList<ItemChannel>();

        //load channel
        if (IsChannel == true)
        {
            arrItem = CreateData_Channel();
        }
        else//load item
        {
            //dựa vào key để load danh sách
            arrItem = CreateItem_vne_TheTheo();
        }

        itemChannelAdapter = new ItemChannelAdapter(Channel.this, R.layout.item, arrItem);
        lv_item.setAdapter(itemChannelAdapter);
    }

    public ArrayList<ItemChannel> CreateData_Channel() {
        if (KeyChannel.contains("TN"))
        {
            return CreateData_TN();
        }
        else if (KeyChannel.contains("VNE"))
        {
            return CreateData_VNE();
        }
        else
            return CreateData_TN();
    }

    public ArrayList<ItemChannel> CreateData_TN() {
        ArrayList<ItemChannel> ds = new ArrayList<ItemChannel>();

        ItemChannel user1 = new ItemChannel("THE THEO", "tn_TheTheo");
        ItemChannel user2 = new ItemChannel("THE DUC", "tn_TheDuc");
        ItemChannel user3 = new ItemChannel("KINH TE", "tn_KinhThe");
        ItemChannel user4 = new ItemChannel("PHAP LUAP", "tn_PhapLuat");

        ds.add(user1);
        ds.add(user2);
        ds.add(user3);
        ds.add(user4);

        return ds;
    }

    public ArrayList<ItemChannel> CreateData_VNE() {
        ArrayList<ItemChannel> ds = new ArrayList<ItemChannel>();

        ItemChannel user1 = new ItemChannel("VNExpress THE THEO", "vne_TheTheo");
        ItemChannel user3 = new ItemChannel("VNExpress KINH TE", "vne_KinhThe");
        ItemChannel user4 = new ItemChannel("VNExpress PHAP LUAP", "vne_PhapLuat");

        ds.add(user1);
        ds.add(user3);
        ds.add(user4);

        return ds;
    }

    public ArrayList<ItemChannel> CreateItem_vne_TheTheo() {
        ArrayList<ItemChannel> ds = new ArrayList<ItemChannel>();

        ItemChannel user1 = new ItemChannel("KET QUA AF CUP", "tn_1" ,"LINK 1");
        ItemChannel user3 = new ItemChannel("TIN XAY DUNG SAN VAN DONG", "tn_2", "LINK 2");
        ItemChannel user4 = new ItemChannel("THANH LAP CAU LAC BO", "tn_3", "LINK 3");

        ds.add(user1);
        ds.add(user3);
        ds.add(user4);

        return ds;
    }

    private void CallItem(String key)
    {
        Intent intent = new Intent(Channel.this, Channel.class);
        intent.putExtra(MainActivity.KeyChannel, key);
        intent.putExtra(MainActivity.IsChannel, false);
        startActivity(intent);
    }

}