package com.example.hw04;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hw04.Adapter.UserAdapter;
import com.example.hw04.Data.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link blueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class blueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MainActivity main;
    Context context= null;
    String message = "";

    TextView tvYourChoose;
    ListView lv_item;

    ArrayList<User> listUser;
    UserAdapter userAdapter = null;



    public blueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment blueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static blueFragment newInstance(String param1, String param2) {
        blueFragment fragment = new blueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static blueFragment newInstance(String strArg) {
        blueFragment fragment = new blueFragment();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        }
        catch (IllegalStateException e)
        {
            throw new IllegalStateException("MainActivitymust implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //LinearLayout view_layout_blue = (LinearLayout) inflater.inflate(R.layout.fragment_blue, null);
        return  inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        tvYourChoose = view.findViewById(R.id.tvYourChoose);
        lv_item = view.findViewById(R.id.list_item);
        LoadDataListView();
        AddEvents();
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

        userAdapter = new UserAdapter(context, R.layout.item, listUser);
        lv_item.setAdapter(userAdapter);

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