package com.example.hw08.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hw08.Data.ItemChannel;
import com.example.hw08.R;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class ItemChannelAdapter extends ArrayAdapter<ItemChannel> {

    public List<ItemChannel> receiptlist;

    public ItemChannelAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ItemChannelAdapter(Context context, int resource, List<ItemChannel> items) {
        super(context, resource, items);

        receiptlist = items;
        //Collections.reverse(receiptlist);
    }

    @Override
    public int getCount() {
        try {
            int size = receiptlist.size();
            return size;
        } catch(NullPointerException ex) {
            return 0;
        }
    }

    public void updateReceiptsList(List<ItemChannel> newlist) {
        receiptlist.clear();
        receiptlist.addAll(newlist);
        this.notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item, null);
        }
        ItemChannel p = getItem(position);

        if (p != null) {
            InputStream is = null;

            TextView btn = v.findViewById(R.id.txtItem);
            btn.setText(p.getName());
            btn.setTag(p.getKey());
        }
        return v;
    }

}
