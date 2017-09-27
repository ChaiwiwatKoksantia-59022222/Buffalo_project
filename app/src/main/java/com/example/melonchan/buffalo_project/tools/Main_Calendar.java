package com.example.melonchan.buffalo_project.tools;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melonchan.buffalo_project.R;

import java.util.ArrayList;
import java.util.Calendar;

import static java.security.AccessController.getContext;

/**
 * Created by android on 9/24/2017 AD.
 */

public class Main_Calendar {

    View view;
    Context context;
    FragmentActivity activity;
    Calendar calendar;
    int year,month,day,cycle;

    Calendar_Tools tools;
    My_Dialog my_dialog;

    TextView textView;

    Dialog dialog;
    Boolean c1 = false,c2 = false;

    public Main_Calendar(View view,Context context,FragmentActivity activity) {
        this.view = view;
        this.context = context;
        this.activity = activity;

        tools = new Calendar_Tools();
        calendar = Calendar.getInstance();
        my_dialog = new My_Dialog(context);
        initData();
    }

    public void getResult(){
        ArrayList<String> arrayList = new ArrayList<>();
        if (!c1 || !c2){
            my_dialog.alertDialog("ข้อมูลไม่ครบ","ปิด");
        }
        else {
            Calculator calculator = new Calculator(day,month,year,cycle);

            arrayList = calculator.getDate();
        }
        Log.e("DAY 1",arrayList.get(0));
        Log.e("DAY 2",arrayList.get(1));
        Log.e("DAY 3",arrayList.get(2));
        Log.e("DAY 4",arrayList.get(3));
        Log.e("DAY 5",arrayList.get(4));
    }

    public void getDialog(final TextView textView){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.main_input_dialog);
        dialog.setCancelable(true);
        dialog.show();

        Button cancel = dialog.findViewById(R.id.add_input_cancel);
        Button confirm = dialog.findViewById(R.id.add_input_confirm);

        final EditText editText = dialog.findViewById(R.id.add_input_edittext);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(Integer.parseInt(editText.getText().toString()));
                cycle = Integer.parseInt(text);

                if (cycle > 365){
                    my_dialog.alertDialog("ข้อมูลไม่ถูกต้อง","ปิด");
                    cycle = 0;
                    c2 = false;
                }
                else if (cycle == 0){
                    my_dialog.alertDialog("ข้อมูลไม่ถูกต้อง","ปิด");
                    c2 = false;
                }
                else {
                    textView.setText(text+" วัน");
                    c2 = true;
                }

                dialog.cancel();
            }
        });
    }


    private void initData(){
        this.year = calendar.get(Calendar.YEAR) + 543;
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        //yearDay = calendar.get(Calendar.DAY_OF_YEAR);
    }

    public String getData(){
        return "วันที่ " + String.valueOf(day) + " " + tools.convertMonth_intToName(month) + " พ.ศ." + String.valueOf(year);
    }

    public void resetCalendar(){
        initData();
    }

    public void getCalenderDialog(){
        resetCalendar();
        new DatePickerDialog(activity,date_s
                ,calendar.get(Calendar.YEAR)
                ,calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void getCalenderDialog_withSetText(TextView textView){
        resetCalendar();
        this.textView = textView;
        new DatePickerDialog(activity,date_s
                ,calendar.get(Calendar.YEAR)
                ,calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show();


    }

    DatePickerDialog.OnDateSetListener date_s = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            setDateFromPicker(year + 543,month + 1,day);
        }
    };

    private void setText(){
        c1 = true;
        textView.setText(getData());
    }

    private void setDateFromPicker(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;

        setText();
    }

}
