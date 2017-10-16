package com.example.melonchan.buffalo_project.tools;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Created by android on 10/15/2017 AD.
 */

public class AppData {

    private static Context context;

    public AppData(Context context) {
        this.context = context;
    }

    public static String[] getData(int resourceID){
        TypedArray typedArray = context.getResources().obtainTypedArray(resourceID);
        String[] array_res = new String[typedArray.length()];
        for (int i = 0; i < array_res.length ; i++){
            array_res[i] = typedArray.getString(i);
        }
        typedArray.recycle();
        return array_res;
    }

    public static int[] getData(int resourceID,int defaultResourceID){
        TypedArray typedArray = context.getResources().obtainTypedArray(resourceID);
        int[] array_res = new int[typedArray.length()];
        for (int i = 0;i < array_res.length;i++){
            array_res[i] = typedArray.getResourceId(i,defaultResourceID);
        }
        typedArray.recycle();
        return array_res;
    }


}
