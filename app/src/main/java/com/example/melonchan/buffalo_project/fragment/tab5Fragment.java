package com.example.melonchan.buffalo_project.fragment;

import com.example.melonchan.buffalo_project.R;
import com.example.melonchan.buffalo_project.VocabActivity;
import com.example.melonchan.buffalo_project.font.Sukhumvit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class tab5Fragment extends Fragment {

    Sukhumvit sukhumvit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab5, container, false);

        //setFont(view);

        int[] resId = {R.drawable.tr
                , R.drawable.pe, R.drawable.me};

        String[] string_list = {"คำศัพท์", "ผู้จัดทำ", "บรรณานุกรม"};

        tab5Fragment.GridViewAdapter adapter = new tab5Fragment.GridViewAdapter(string_list, resId, getContext());

        GridView listView = (GridView) view.findViewById(R.id.tab_5_menu_gridview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == 0) {
                    Intent intent = new Intent(getActivity(), VocabActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    private class GridViewAdapter extends BaseAdapter {
        private int[] resId;
        private String[] list;
        private Context context;

        public GridViewAdapter(String[] list, int[] arrayItem, Context context) {
            this.resId = arrayItem;
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.length;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_circle, null);

            TextView textView = convertView.findViewById(R.id.menu_circle_text);
            ImageView imageView = convertView.findViewById(R.id.menu_circle_image);

            textView.setText(list[position]);
            imageView.setImageResource(resId[position]);

            return convertView;
        }
    }

    public void setFont(View view) {

        sukhumvit = new Sukhumvit(getActivity().getAssets(), "fonts");
        TextView name = view.findViewById(R.id.tab_5_name);
        name.setTypeface(sukhumvit.bold());


    }

}
