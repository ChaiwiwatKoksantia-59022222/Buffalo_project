package com.example.melonchan.buffalo_project.tools;

import android.view.View;
import android.view.Window;

/**
 * Created by Melonchan on 9/20/2017 AD.
 */

public class Light_v26 {

    public Light_v26(Window window) {

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    }
}
