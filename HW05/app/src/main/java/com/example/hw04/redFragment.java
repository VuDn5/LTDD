package com.example.hw04;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link redFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class redFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MainActivity main;
    Context context= null;
    String message = "";

    TextView tvMSSV, tvName, tvClass, tvDiem;
    Button btnFirst, btnPre, btnNext, btnLast;

    public redFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment redFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static redFragment newInstance(String param1, String param2) {
        redFragment fragment = new redFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

        //if(!(getActivity() instanceof MainCallbacks))
       // {
       //     throw new IllegalStateException( "Activity must implement MainCallbacks");
       // }

        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /* FrameLayout view_layout_blue = (FrameLayout) inflater.inflate(R.layout.fragment_blue, null);


*/
        return inflater.inflate(R.layout.fragment_red, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        tvMSSV = view.findViewById(R.id.tvMSSV);
        tvClass = view.findViewById(R.id.tvClass);
        tvName = view.findViewById(R.id.tvName);
        tvDiem = view.findViewById(R.id.tvDiem);

        btnFirst = view.findViewById(R.id.btnFirst);
        btnPre = view.findViewById(R.id.btnPre);
        btnNext = view.findViewById(R.id.btnNext);
        btnLast = view.findViewById(R.id.btnLast);

        LoadShowData();
    }

    public void LoadShowData()
    {
        tvClass.setText("18 HCB");
        tvName.setText("Nhom 9");
    }

    public static redFragment newInstance(String strArg) {
        redFragment fragment = new redFragment();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    //@Override
    public void onMsgFromMainToFragment(String strValue) {
        // receiving a message from MainActivity(it may happen at any point in time)
        tvMSSV.setText("THIS MESSAGE COMES FROM MAIN:" + strValue);
    }

}