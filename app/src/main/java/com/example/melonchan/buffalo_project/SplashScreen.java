package com.example.melonchan.buffalo_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.font.Athiti;
import com.example.melonchan.buffalo_project.font.Mitr;
import com.example.melonchan.buffalo_project.font.Prompt;
import com.example.melonchan.buffalo_project.font.Sukhumvit;
import com.example.melonchan.buffalo_project.tools.Light_v26;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Light_v26(getWindow());

        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Sukhumvit sukhumvit = new Sukhumvit(this.getAssets(), "fonts");

        TextView big = (TextView) findViewById(R.id.splashScreen_text_big);
        big.setTypeface(sukhumvit.bold());
        TextView little = (TextView) findViewById(R.id.splashScreen_text_little);
        little.setTypeface(sukhumvit.light());


    }

    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }


}
