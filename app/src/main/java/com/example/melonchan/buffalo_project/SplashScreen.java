package com.example.melonchan.buffalo_project;

import android.graphics.Typeface;
import android.os.Bundle;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Light_v26(getWindow());

        Sukhumvit sukhumvit = new Sukhumvit(this.getAssets(),"fonts");

        TextView big = (TextView)findViewById(R.id.splashScreen_text_big);
        big.setTypeface(sukhumvit.bold());
        TextView little = (TextView)findViewById(R.id.splashScreen_text_little);
        little.setTypeface(sukhumvit.light());



    }


}
