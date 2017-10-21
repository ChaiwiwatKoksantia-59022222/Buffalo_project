package com.example.melonchan.buffalo_project;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.tools.AppData;

import java.util.ArrayList;

public class VocabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        AppData appData = new AppData(this);

        String[] t1 = appData.getData(R.array.vocabulary_word_text_data);
        String[] t2 = appData.getData(R.array.vocabulary_meaning_text_data);
        ListViewAdapter adapter = new ListViewAdapter(t1,t2,this);

        GridView listView = (GridView) findViewById(R.id.vocab_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });

        LinearLayout back_btn = (LinearLayout) findViewById(R.id.result_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewCompat.setNestedScrollingEnabled(listView, true);

    }

    private class ListViewAdapter extends BaseAdapter {
        private String[] t1,t2;
        private Context context;

        public ListViewAdapter(String[] t1,String[] t2,Context context) {
            this.t1 = t1;
            this.t2 = t2;
            this.context = context;
        }

        @Override
        public int getCount() {
            return t1.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_view, null);

            TextView tv1 = convertView.findViewById(R.id.card_view_title_text);
            TextView tv2 = convertView.findViewById(R.id.card_view_des_text);

            tv1.setText(t1[position]);
            tv2.setText(t2[position]);

            return convertView;
        }
    }

}
