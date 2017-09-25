package com.example.melonchan.buffalo_project.tools;

import android.widget.Switch;

/**
 * Created by android on 9/24/2017 AD.
 */

public class Calendar_Tools {

    public String convertMonth_intToName(int month){

        String name = "";

        switch (month) {
            case 1 : name = "มกราคม"; break;
            case 2 : name = "กุมภาพันธ์"; break;
            case 3 : name = "มีนาคม"; break;
            case 4 : name = "เมษายน"; break;
            case 5 : name = "พฤษภาคม"; break;
            case 6 : name = "มิถุนายน"; break;
            case 7 : name = "กรกฎาคม"; break;
            case 8 : name = "สิงหาคม"; break;
            case 9 : name = "กันยายน"; break;
            case 10 : name = "ตุลาคม"; break;
            case 11 : name = "พฤศจิกายน"; break;
            case 12 : name = "ธันวาคม"; break;
            default : break;
        }

        return name;

    }

}
