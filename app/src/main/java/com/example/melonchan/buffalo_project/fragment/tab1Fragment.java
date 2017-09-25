package com.example.melonchan.buffalo_project.fragment;

import com.example.melonchan.buffalo_project.R;
import com.example.melonchan.buffalo_project.font.Mitr;
import com.example.melonchan.buffalo_project.font.Sukhumvit;
import com.example.melonchan.buffalo_project.tools.Main_Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class tab1Fragment extends Fragment {

    //Sukhumvit sukhumvit;
    //Mitr mitr;

    View view;
    RelativeLayout main_cal_btn;
    Main_Calendar main_calendar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tab1,container,false);
        //sukhumvit = new Sukhumvit(getActivity().getAssets(),"fonts");
        //mitr = new Mitr(getActivity().getAssets(),"fonts");

        main_calendar = new Main_Calendar(view,getContext(),getActivity());

        image();
        hub();

        return view;
    }

    private void hub(){
        date_btn();
        cycle_btn();
    }

    private void date_btn(){

        final TextView date_tv = view.findViewById(R.id.main_date_text);
        RelativeLayout date_btn = view.findViewById(R.id.main_date_button);
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_calendar.getCalenderDialog_withSetText(date_tv);
            }
        });

    }

    private void cycle_btn(){
        final TextView textView = view.findViewById(R.id.main_cycle_text);
        RelativeLayout cycle_btn = view.findViewById(R.id.main_cycle_button);
        cycle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main_calendar.getDialog(textView);
            }
        });
    }

    private void image(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        ImageView imageView = view.findViewById(R.id.main_image);
        int x = width/2;
        imageView.getLayoutParams().height = x + (x/3);
        imageView.getLayoutParams().width = width;
        imageView.requestLayout();
    }

    /*
    private void font (){

        TextView big = view.findViewById(R.id.mainScreen_text_big);
        big.setTypeface(mitr.bold());
        TextView little = view.findViewById(R.id.mainScreen_text_little);
        little.setTypeface(mitr.light());

    }*/

}
