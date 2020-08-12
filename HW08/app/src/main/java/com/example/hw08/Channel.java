package com.example.hw08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hw08.Adapter.ItemChannelAdapter;
import com.example.hw08.Data.ItemChannel;

import java.util.ArrayList;

public class Channel extends AppCompatActivity {

    private final String LINK = "LINK";

    TextView txtYourChoose;
    ListView lv_item;

    ArrayList<ItemChannel> arrItem;
    ItemChannelAdapter itemChannelAdapter = null;
    String KeyChannel = "";
    Boolean IsChannel = false;
    String NameChannel = "";

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
                if(item.getKey() != null && !item.getKey().isEmpty()
                        && item.getKey().equals("detail"))
                    showDialogBox(item);
                else
                    CallItem(item);
                //showDialogBox(item);
            }
        });
    }

    private void GetDatas()
    {
        Intent intent = getIntent();
        Bundle myData = intent.getExtras();
        KeyChannel = myData.getString(MainActivity.KeyChannel);
        IsChannel = myData.getBoolean(MainActivity.IsChannel);
        NameChannel = myData.getString(MainActivity.NameChannel);
        // Capture the layout's TextView and set the string as its text
    }

    private void LoadDataListView()
    {
        arrItem = new ArrayList<ItemChannel>();

        //load channel
        if (IsChannel == true)
        {
            txtYourChoose.setText("CHANNELS IN " + NameChannel);
            arrItem = CreateData_Channel();
            itemChannelAdapter = new ItemChannelAdapter(Channel.this, R.layout.item, arrItem);
            lv_item.setAdapter(itemChannelAdapter);
        }
        else//load item
        {
            //gọi tới server
            txtYourChoose.setText(NameChannel);
            Intent intent = getIntent();
            Bundle myData = intent.getExtras();

            CallServer(myData.getString("LINK"));
        }


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
        else if(KeyChannel.equals("TT")) {
            return CreateData_TUOITTRE();
        }
        else
            return CreateData_VNNET();
    }

    private ArrayList<ItemChannel> CreateData_TN() {
        ArrayList<ItemChannel> ds = new ArrayList<ItemChannel>();

        ds.add(new ItemChannel("Thời sự", "", "https://thanhnien.vn/rss/thoi-su.rss"));
        ds.add(new ItemChannel("Thế giới", "", "https://thanhnien.vn/rss/the-gioi.rss"));
        ds.add(new ItemChannel("Văn hóa", "", "https://thanhnien.vn/rss/van-hoa.rss"));
        ds.add(new ItemChannel("Giải trí", "", "https://thanhnien.vn/rss/giai-tri.rss"));
        ds.add(new ItemChannel("Thể thao", "", "https://thethao.thanhnien.vn/rss/home.rss"));
        ds.add(new ItemChannel("Đời sống", "", "https://thanhnien.vn/rss/doi-song.rss"));
        ds.add(new ItemChannel("Tài chính", "", "https://thanhnien.vn/rss/tai-chinh-kinh-doanh.rss"));
        ds.add(new ItemChannel("Giới trẻ", "", "https://thanhnien.vn/rss/gioi-tre.rss"));
        ds.add(new ItemChannel("Giáo dục", "", "https://thanhnien.vn/rss/giao-duc.rss"));
        ds.add(new ItemChannel("Công nghệ", "", "https://thanhnien.vn/rss/cong-nghe.rss"));
        ds.add(new ItemChannel("Game", "", "https://game.thanhnien.vn/rss/home.rss"));
        ds.add(new ItemChannel("Sức khỏe", "", "https://thanhnien.vn/rss/suc-khoe.rss"));
        ds.add(new ItemChannel("Du lịch", "", "https://thanhnien.vn/rss/du-lich.rss"));
        ds.add(new ItemChannel("Xe", "", "https://xe.thanhnien.vn/rss/home.rss"));
        ds.add(new ItemChannel("Bạn cần biết", "", "https://thanhnien.vn/rss/ban-can-biet.rss"));

        return ds;
    }

    private ArrayList<ItemChannel> CreateData_VNE() {
        ArrayList<ItemChannel> ds = new ArrayList<ItemChannel>();

        ds.add(new ItemChannel("Tin nổi bật", "", "https://vnexpress.net/rss/tin-noi-bat.rss"));
        ds.add(new ItemChannel("Tin xem nhiều", "", "https://vnexpress.net/rss/tin-xem-nhieu.rss"));
        ds.add(new ItemChannel("Thế giới", "", "https://vnexpress.net/rss/the-gioi.rss"));
        ds.add(new ItemChannel("Thời sự", "", "https://vnexpress.net/rss/thoi-su.rss"));
        ds.add(new ItemChannel("Kinh doanh", "", "https://vnexpress.net/rss/kinh-doanh.rss"));
        ds.add(new ItemChannel("Startup", "", "https://vnexpress.net/rss/startup.rss"));
        ds.add(new ItemChannel("Giải trí", "", "https://vnexpress.net/rss/giai-tri.rss"));
        ds.add(new ItemChannel("Thể thao", "", "https://vnexpress.net/rss/the-thao.rss"));
        ds.add(new ItemChannel("Pháp luật", "", "https://vnexpress.net/rss/phap-luat.rss"));
        ds.add(new ItemChannel("Giáo dục", "", "https://vnexpress.net/rss/giao-duc.rss"));
        ds.add(new ItemChannel("Sức khỏe", "", "https://vnexpress.net/rss/suc-khoe.rss"));
        ds.add(new ItemChannel("Đời sống", "", "https://vnexpress.net/rss/gia-dinh.rss"));
        ds.add(new ItemChannel("Du lịch", "", "https://vnexpress.net/rss/du-lich.rss"));
        ds.add(new ItemChannel("Khoa học", "", "https://vnexpress.net/rss/khoa-hoc.rss"));
        ds.add(new ItemChannel("Số hóa", "", "https://vnexpress.net/rss/so-hoa.rss"));
        ds.add(new ItemChannel("Xe", "", "https://vnexpress.net/rss/oto-xe-may.rss"));
        ds.add(new ItemChannel("Ý kiến", "", "https://vnexpress.net/rss/y-kien.rss"));
        ds.add(new ItemChannel("Tâm sự", "", "https://vnexpress.net/rss/tam-su.rss"));
        ds.add(new ItemChannel("Cười", "", "https://vnexpress.net/rss/cuoi.rss"));

        return ds;
    }

    private ArrayList<ItemChannel> CreateData_TUOITTRE() {
        ArrayList<ItemChannel> ds = new ArrayList<>();

        ds.add(new ItemChannel("Trang chủ", "", "https://tuoitre.vn/rss/tin-moi-nhat.rss"));
        ds.add(new ItemChannel("Thế giới", "", "https://tuoitre.vn/rss/the-gioi.rss"));
        ds.add(new ItemChannel("Thời sự", "", "https://tuoitre.vn/rss/thoi-su.rss"));
        ds.add(new ItemChannel("Pháp Luật", "", "https://tuoitre.vn/rss/phap-luat.rss"));
        ds.add(new ItemChannel("Kinh doanh", "", "https://tuoitre.vn/rss/kinh-doanh.rss"));
        ds.add(new ItemChannel("Công nghệ", "", "https://tuoitre.vn/rss/nhip-song-so.rss"));
        ds.add(new ItemChannel("Xe", "", "https://tuoitre.vn/rss/xe.rss"));
        ds.add(new ItemChannel("Nhịp sống trẻ", "", "https://tuoitre.vn/rss/nhip-song-tre.rss"));
        ds.add(new ItemChannel("Văn hóa", "", "https://tuoitre.vn/rss/van-hoa.rss"));
        ds.add(new ItemChannel("Giải trí", "", "https://tuoitre.vn/rss/giai-tri.rss"));
        ds.add(new ItemChannel("Thể thao", "", "https://tuoitre.vn/rss/the-thao.rss"));
        ds.add(new ItemChannel("Giáo dục", "", "https://tuoitre.vn/rss/giao-duc.rss"));
        ds.add(new ItemChannel("Khoa học", "", "https://tuoitre.vn/rss/khoa-hoc.rss"));
        ds.add(new ItemChannel("Sức khỏe", "", "https://tuoitre.vn/rss/suc-khoe.rss"));
        ds.add(new ItemChannel("Giả thật", "", "https://tuoitre.vn/rss/gia-that.rss"));
        ds.add(new ItemChannel("Thư giãn", "", "https://tuoitre.vn/rss/thu-gian.rss"));
        ds.add(new ItemChannel("Bạn đọc làm báo", "", "https://tuoitre.vn/rss/ban-doc-lam-bao.rss"));
        ds.add(new ItemChannel("Du lịch", "", "https://tuoitre.vn/rss/du-lich.rss"));

        return ds;
    }

    private ArrayList<ItemChannel> CreateData_VNNET() {
        ArrayList<ItemChannel> ds = new ArrayList<>();

        ds.add(new ItemChannel("Chính trị", "", "https://vietnamnet.vn/rss/thoi-su-chinh-tri.rss"));
        ds.add(new ItemChannel("Thế giới", "", "https://vietnamnet.vn/rss/the-gioi.rss"));
        ds.add(new ItemChannel("Thời sự", "", "https://vietnamnet.vn/rss/thoi-su.rss"));
        ds.add(new ItemChannel("Pháp luật", "", "https://vietnamnet.vn/rss/phap-luat.rss"));
        ds.add(new ItemChannel("Kinh doanh", "", "https://vietnamnet.vn/rss/kinh-doanh.rss"));
        ds.add(new ItemChannel("Giải trí", "", "https://vietnamnet.vn/rss/giai-tri.rss"));
        ds.add(new ItemChannel("Giáo dục", "", "https://vietnamnet.vn/rss/giao-duc.rss"));
        ds.add(new ItemChannel("Đời sống", "", "https://vietnamnet.vn/rss/doi-song.rss"));
        ds.add(new ItemChannel("Thể thao", "", "https://vietnamnet.vn/rss/the-thao.rss"));
        ds.add(new ItemChannel("Công nghệ", "", "https://vietnamnet.vn/rss/cong-nghe.rss"));
        ds.add(new ItemChannel("Sức khỏe", "", "https://vietnamnet.vn/rss/suc-khoe.rss"));
        ds.add(new ItemChannel("Bất động sản", "", "https://vietnamnet.vn/rss/bat-dong-san.rss"));
        ds.add(new ItemChannel("Bạn đọc", "", "https://vietnamnet.vn/rss/ban-doc.rss"));
        ds.add(new ItemChannel("Xe", "", "https://vietnamnet.vn/rss/oto-xe-may.rss"));
        ds.add(new ItemChannel("Góc nhìn thẳng", "", "https://vietnamnet.vn/rss/goc-nhin-thang.rss"));
        ds.add(new ItemChannel("Tin mới nhất", "", "https://vietnamnet.vn/rss/tin-moi-nhat.rss"));

        return ds;
    }

    public void showDialogBox(ItemChannel itemChannel){

        final Uri storyLink = Uri.parse(itemChannel.getLink());
        String title = itemChannel.getName();
        String description = itemChannel.getDescription();
        String ss = Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT).toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(NameChannel)
                .setMessage(title + "\n\n" + Html.fromHtml(description) + "\n")
                .setPositiveButton("Close", null)
                .setNegativeButton("More", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichOne) {
                        Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                        startActivity(browser);
                    }
                })
                .show();
    }

    private void CallItem(ItemChannel itemChannel)
    {
        Intent intent = new Intent(Channel.this, Channel.class);
        Bundle myData = new Bundle();
        myData.putString(MainActivity.KeyChannel, "");
        myData.putBoolean(MainActivity.IsChannel, false);
        myData.putString(LINK, itemChannel.getLink());
        StringBuilder name = new StringBuilder("ITEMS IN CHANNEL ");
        name.append(itemChannel.getName()).append(" - ").append(NameChannel);
        myData.putString(MainActivity.NameChannel, name.toString());
        intent.putExtras(myData);
        startActivity(intent);
    }

    private void CallServer(String link){
        DownloadRssFeed download = new DownloadRssFeed(Channel.this);
        download.execute(link);
    }

}