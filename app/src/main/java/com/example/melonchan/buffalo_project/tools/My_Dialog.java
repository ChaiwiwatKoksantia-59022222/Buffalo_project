package com.example.melonchan.buffalo_project.tools;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.R;

/**
 * Created by android on 9/25/2017 AD.
 */

public class My_Dialog {

    Context context;

    boolean check = false;

    public My_Dialog(Context context) {
        this.context = context;
    }

    public void alertDialog(String text,String cancel_text){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.cancel_dialog);
        dialog.setCancelable(true);
        dialog.show();

        TextView textView = dialog.findViewById(R.id.can_textview_dialog);
        textView.setText(text);

        Button cancel = dialog.findViewById(R.id.can_cancel_btn);
        cancel.setVisibility(View.GONE);
        Button confirm = dialog.findViewById(R.id.can_confirm_btn);
        confirm.setText(cancel_text);
        confirm.setVisibility(View.VISIBLE);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    public void exitDialog(String text, String cancel_text, String confirm_text){
        final Dialog dialog = new Dialog(context);
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
            }
        });

    }


}
