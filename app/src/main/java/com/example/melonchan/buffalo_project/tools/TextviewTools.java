package com.example.melonchan.buffalo_project.tools;

import android.content.Intent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.R;

/**
 * Created by android on 10/17/2017 AD.
 */

public class TextviewTools {

    private View view;

    TextView short_textview, full_textview, show_more_btn;

    private boolean show_all = false;

    public TextviewTools(View view, String string, TextView short_textview, TextView full_textview, TextView show_more_btn) {
        this.view = view;
        this.short_textview = short_textview;
        this.full_textview = full_textview;

        setText(string);
        OnShowShort();
    }

    public TextviewTools(View view, int string, TextView short_textview, TextView full_textview, TextView show_more_btn) {
        this.view = view;
        this.short_textview = short_textview;
        this.full_textview = full_textview;
        this.show_more_btn = show_more_btn;

        setTextWithInt(string);
        OnShowShort();
    }

    public void OnClick() {
        if (show_all) {
            OnShowShort();
        } else {
            OnShowFull();
        }
    }

    private void setTextWithInt(int string) {
        this.short_textview.setText(string);
        setShortTextWithPoint();
        this.full_textview.setText(string);
    }

    private void setText(String string) {
        this.short_textview.setText(string);
        setShortTextWithPoint();
        this.full_textview.setText(string);
    }

    private void OnShowShort() {
        this.short_textview.setVisibility(View.VISIBLE);
        this.full_textview.setVisibility(View.GONE);
        this.show_more_btn.setText("แสดงเพิ่มเติม");
        show_all = false;
    }

    private void OnShowFull() {
        this.short_textview.setVisibility(View.GONE);
        this.full_textview.setVisibility(View.VISIBLE);
        this.show_more_btn.setText("แสดงน้อยลง");
        show_all = true;
    }

    public void setShortTextWithPoint() {
        ViewTreeObserver vto = short_textview.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                ViewTreeObserver obs = short_textview.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (short_textview.getLineCount() > 3) {
                    int lineEndIndex = short_textview.getLayout().getLineEnd(2);
                    String text = short_textview.getText().subSequence(0, lineEndIndex - 3) + " ...";
                    short_textview.setText(text);
                }
            }
        });
    }

}
