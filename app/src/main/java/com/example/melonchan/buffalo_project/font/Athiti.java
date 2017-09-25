package com.example.melonchan.buffalo_project.font;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class Athiti implements Font{

    private AssetManager assetManager;
    private String address;

    public Athiti(AssetManager assetManager, String package_address){
        this.assetManager = assetManager;
        this.address = package_address + "/Athiti/";
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
