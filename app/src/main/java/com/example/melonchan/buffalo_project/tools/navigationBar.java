package com.example.melonchan.buffalo_project.tools;

import android.support.v7.widget.CardView;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by android on 9/28/2017 AD.
 */

public class navigationBar {

    boolean navigationBar;

    public navigationBar() {
        this.navigationBar = isNavigationBarAvailable();
    }

    public boolean checkNavigationBar() {
        return navigationBar;
    }

    public void getAction(RelativeLayout relativeLayout){
        if (navigationBar){
            relativeLayout.setVisibility(View.GONE);
        }
        else {
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }

    public void getAction(LinearLayout linearLayout){
        if (navigationBar){
            linearLayout.setVisibility(View.GONE);
        }
        else{
            linearLayout.setVisibility(View.VISIBLE);
        }
    }

    public void getAction(CardView cardView){
        if (navigationBar){
            cardView.setVisibility(View.GONE);
        }
        else {
            cardView.setVisibility(View.VISIBLE);
        }
    }

    private boolean isNavigationBarAvailable(){

        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        boolean hasHomeKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_HOME);

        return ((hasBackKey && hasHomeKey));
    }

}
