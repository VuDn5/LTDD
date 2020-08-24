package com.example.callapp.fragment;

<<<<<<< HEAD
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
=======
>>>>>>> e945b080d3edc40648672fec64e3dc92bc543f21
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.callapp.MainActivity;
=======

>>>>>>> e945b080d3edc40648672fec64e3dc92bc543f21
import com.example.callapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuaySo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuaySo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

<<<<<<< HEAD
    MainActivity main;
    Context context= null;
    String message = "";

    EditText txtNumberCall;
    Button btnCall;
    Button btnClear;
    Button btnBack;

    Button t9_key_0;
    Button t9_key_1;
    Button t9_key_2;
    Button t9_key_3;
    Button t9_key_4;
    Button t9_key_5;
    Button t9_key_6;
    Button t9_key_7;
    Button t9_key_8;
    Button t9_key_9;

=======
>>>>>>> e945b080d3edc40648672fec64e3dc92bc543f21
    public QuaySo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuaySo.
     */
    // TODO: Rename and change types and number of parameters
    public static QuaySo newInstance(String param1, String param2) {
        QuaySo fragment = new QuaySo();
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
<<<<<<< HEAD

        try
        {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        }
        catch (IllegalStateException e)
        {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
=======
>>>>>>> e945b080d3edc40648672fec64e3dc92bc543f21
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quay_so, container, false);
    }
<<<<<<< HEAD

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {


        AddControls(view);
        AddEvents();
    }

    private void AddControls(View view)
    {
        txtNumberCall = view.findViewById(R.id.txtNumberCall);
        btnCall = view.findViewById(R.id.btnCall);
        btnClear = view.findViewById(R.id.t9_key_clear);
        btnBack = view.findViewById(R.id.t9_key_backspace);

        t9_key_0 = view.findViewById(R.id.t9_key_0);
        t9_key_1 = view.findViewById(R.id.t9_key_1);
        t9_key_2 = view.findViewById(R.id.t9_key_2);
        t9_key_3 = view.findViewById(R.id.t9_key_3);
        t9_key_4 = view.findViewById(R.id.t9_key_4);
        t9_key_5 = view.findViewById(R.id.t9_key_5);
        t9_key_6 = view.findViewById(R.id.t9_key_6);
        t9_key_7 = view.findViewById(R.id.t9_key_7);
        t9_key_8 = view.findViewById(R.id.t9_key_8);
        t9_key_9 = view.findViewById(R.id.t9_key_9);
    }

    private void AddEvents()
    {
        SetEnventKey(t9_key_0, t9_key_0.getText().toString());
        SetEnventKey(t9_key_1, t9_key_1.getText().toString());
        SetEnventKey(t9_key_2, t9_key_2.getText().toString());
        SetEnventKey(t9_key_3, t9_key_3.getText().toString());
        SetEnventKey(t9_key_4, t9_key_4.getText().toString());
        SetEnventKey(t9_key_5, t9_key_5.getText().toString());
        SetEnventKey(t9_key_6, t9_key_6.getText().toString());
        SetEnventKey(t9_key_7, t9_key_7.getText().toString());
        SetEnventKey(t9_key_8, t9_key_8.getText().toString());
        SetEnventKey(t9_key_9, t9_key_9.getText().toString());

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumberCall.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberCall = txtNumberCall.getText().toString();
                if (numberCall.length() <= 1)
                    txtNumberCall.setText("");
                else
                    txtNumberCall.setText(numberCall.subSequence(0, numberCall.length() - 1));
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowCall();
            }
        });
    }

    private void SetEnventKey(final Button t9_key, final String num)
    {
        t9_key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumberCall.setText(txtNumberCall.getText().toString() + num);

            }
        });
    }

    private void ShowCall()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(txtNumberCall.getText())
                .setTitle("Calling");
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

=======
>>>>>>> e945b080d3edc40648672fec64e3dc92bc543f21
}