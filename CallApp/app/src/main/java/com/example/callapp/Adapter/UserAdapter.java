package com.example.callapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.callapp.Data.User;
import com.example.callapp.R;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public List<User> receiptlist;

    public UserAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public UserAdapter(Context context, int resource, List<User> items) {
        super(context, resource, items);

        receiptlist = items;
        Collections.reverse(receiptlist);
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

    public void updateReceiptsList(List<User> newlist) {
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
        User p = getItem(position);

        if (p != null) {
            InputStream is = null;

            TextView tvName = (TextView) v.findViewById(R.id.tvName);
            TextView tvPhone = (TextView) v.findViewById(R.id.tvPhone);
            ImageView img = (ImageView) v.findViewById(R.id.img);
            ImageButton btnCall = (ImageButton) v.findViewById(R.id.btnCall);

            tvName.setText(p.getName());
            tvPhone.setText(p.getPhone());
        }
        return v;
    }

}
