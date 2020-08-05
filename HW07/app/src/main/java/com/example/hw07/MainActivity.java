package com.example.hw07;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtText;
    TextView tvPercent;
    ProgressBar progressBar;
    double percent;
    Button btnDoItAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText = findViewById(R.id.edtText);
        tvPercent = findViewById(R.id.tvPercent);
        progressBar = findViewById(R.id.progressBar);
        btnDoItAgain = findViewById(R.id.btnDoItAgain);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        percent = 0;
        btnDoItAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initProgressBar();
            }
        });
    }

    private void initProgressBar() {
        String str = edtText.getText().toString();
        int value;
        if (!str.isEmpty()) {
            value = Integer.valueOf(str);
        } else {
            value = 0;
        }
        edtText.setEnabled(false);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        percent = 0;
        btnDoItAgain.setAlpha(0.5f);
        btnDoItAgain.setEnabled(false);
        new MyTask().execute(value);
    }

    private class MyTask extends AsyncTask<Integer, Integer, String> {
        private final int LIMIT = 10000000;

        @Override
        protected String doInBackground(Integer... params) {
            int valuePercen = 0;
            int valueInput = params[0];

            if(valueInput != 0) {
//                double value = (float) 1 / valueInput * 100;
//
//                for (int i = 1; i <= valueInput; i++) {
//                    try {
//                        Thread.sleep(0);
//                        valuePercen = valuePercen + value;
//                        if (valuePercen >= 1) {
//                            publishProgress((int) valuePercen);
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                //double value = (float) 1 / valueInput * 100;

                double wannaSleep = 1 - valueInput * 1.0 / LIMIT;
                wannaSleep = (1 + wannaSleep) * 30;
                for(int i = 0; i <= 100; i++){
                    try{
                        Thread.sleep((long)wannaSleep);
                        publishProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return "Task Completed.";
        }

        @Override
        protected void onPostExecute(String result) {
            btnDoItAgain.setAlpha(1f);
            btnDoItAgain.setEnabled(true);
            edtText.setEnabled(true);

        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvPercent.setText(String.format("%d%%", values[0]));
            progressBar.setProgress(values[0]);
        }
    }
}