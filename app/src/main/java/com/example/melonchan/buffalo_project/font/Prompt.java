package com.example.melonchan.buffalo_project.font;

import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by Melonchan on 9/20/2017 AD.
 */

public class Prompt implements Font {

    private AssetManager assetManager;
    private String address;

    public Prompt(AssetManager assetManager,String package_address) {
        this.assetManager = assetManager;
        this.address = package_address + "/Prompt/";
    }

    public Typeface thin(){
        return getFont("ExtraLight.ttf");
    }

    public Typeface bold(){
        return getFont("Bold.ttf");
    }

    public Typeface medium(){
        return getFont("Medium.ttf");
    }

    public Typeface regular(){
        return getFont("Regular.ttf");
    }

    public Typeface semiBold(){
        return getFont("SemiBold.ttf");
    }

    public Typeface light(){
        return getFont("Light.ttf");
    }

    private Typeface getFont(String type){
        return Typeface.createFromAsset(assetManager,address + type);
    }
}
