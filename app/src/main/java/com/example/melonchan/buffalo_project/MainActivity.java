package com.example.melonchan.buffalo_project;

import android.app.Application;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.melonchan.buffalo_project.font.Mitr;
import com.example.melonchan.buffalo_project.font.Sukhumvit;

import com.example.melonchan.buffalo_project.tools.Light_v26;

import com.example.melonchan.buffalo_project.fragment.tab1Fragment;
import com.example.melonchan.buffalo_project.fragment.tab2Fragment;
import com.example.melonchan.buffalo_project.fragment.tab3Fragment;
import com.example.melonchan.buffalo_project.fragment.tab4Fragment;
import com.example.melonchan.buffalo_project.fragment.tab5Fragment;
import com.example.melonchan.buffalo_project.tools.My_Dialog;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private Sukhumvit sukhumvit;
    //Mitr mitr = new Mitr(getAssets(),"fonts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Light_v26(getWindow());

        sukhumvit = new Sukhumvit(getAssets(), "fonts");

        sBottomBar();
        start_fragment();


    }

    public void start_fragment() {
        tab1Fragment tab1 = new tab1Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab1).commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        My_Dialog my_dialog = new My_Dialog(MainActivity.this);
        exitDialog("คุณต้องการที่จะออกจากแอป?", "ยกเลิก", "ยืนยัน");
    }

    public void exitDialog(String text, String cancel_text, String confirm_text) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cancel_dialog);
        dialog.setCancelable(true);
        dialog.show();

        TextView textView = dialog.findViewById(R.id.can_textview_dialog);
        textView.setText(text);

        Button cancel = dialog.findViewById(R.id.can_cancel_btn);
        cancel.setText(cancel_text);
        cancel.setVisibility(View.VISIBLE);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        Button confirm = dialog.findViewById(R.id.can_confirm_btn);
        confirm.setText(confirm_text);
        confirm.setVisibility(View.VISIBLE);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                finish();
            }
        });

    }

    public void sBottomBar() {
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.nav_tab_1) {
                    tab1Fragment tab1 = new tab1Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab1).commit();
                } else if (tabId == R.id.nav_tab_2) {
                    tab2Fragment tab2 = new tab2Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab2).commit();
                } else if (tabId == R.id.nav_tab_3) {
                    tab3Fragment tab3 = new tab3Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab3).commit();
                } else if (tabId == R.id.nav_tab_4) {
                    tab4Fragment tab4 = new tab4Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab4).commit();
                } else {
                    tab5Fragment tab5 = new tab5Fragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, tab5).commit();
                }
            }
        });
    }

}
