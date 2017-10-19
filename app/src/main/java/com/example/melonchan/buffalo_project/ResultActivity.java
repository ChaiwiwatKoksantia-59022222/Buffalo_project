package com.example.melonchan.buffalo_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.tools.navigationBar;

public class ResultActivity extends AppCompatActivity {

    String day1, day2, day3, day4, day5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getDate();
        setTextView();

        LinearLayout back_btn = (LinearLayout) findViewById(R.id.result_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void setTextView() {
        TextView day1s = (TextView) findViewById(R.id.result_text_day1);
        day1s.setText(day1);
        TextView day2s = (TextView) findViewById(R.id.result_text_day2);
        day2s.setText(day2);
        TextView day3s = (TextView) findViewById(R.id.result_text_day3);
        day3s.setText(day5);
        TextView day4s = (TextView) findViewById(R.id.result_text_day4);
        day4s.setText(day4);
    }

    private void getDate() {
        Bundle bundle = getIntent().getExtras();
        day1 = bundle.getString("day1");
        day2 = bundle.getString("day2");
        day3 = bundle.getString("day3");
        day4 = bundle.getString("day4");
        day5 = bundle.getString("day5");
    }


}
