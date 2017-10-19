package com.example.melonchan.buffalo_project.fragment;

import com.example.melonchan.buffalo_project.DeviceActivity;
import com.example.melonchan.buffalo_project.R;
import com.example.melonchan.buffalo_project.font.Sukhumvit;
import com.example.melonchan.buffalo_project.tools.TextviewTools;

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

public class tab4Fragment extends Fragment {

    Sukhumvit sukhumvit;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_tab4, container, false);

        //setFont(view);
        show_more();

        int[] resId = {R.drawable.list
                , R.drawable.microscope};

        String[] string_list = {"ขั้นตอน", "อุปกรณ์"};

        tab4Fragment.GridViewAdapter adapter = new tab4Fragment.GridViewAdapter(string_list, resId, getContext());

        GridView listView = (GridView) view.findViewById(R.id.tab_4_menu_gridview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(arg2 == 0){
                    Intent intent = new Intent(getActivity(), DeviceActivity.class);
                    intent.putExtra("ID","4");
                    intent.putExtra("TITLE","ขั้นตอนการผสมเทียม");
                    startActivity(intent);
                }
                else if(arg2 == 1){
                    Intent intent = new Intent(getActivity(), DeviceActivity.class);
                    intent.putExtra("ID","2");
                    intent.putExtra("TITLE","อุปกรณ์");
                    intent.putExtra("SUBTITLE","สำหรับการผสมเทียม");
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

    private void show_more() {
        TextView shortTV = view.findViewById(R.id.tab_4_detail_short);
        TextView fullTV = view.findViewById(R.id.tab_4_detail_full);
        TextView show_more_btn = view.findViewById(R.id.tab4_show_more_btn);

        final TextviewTools textviewTools = new TextviewTools(view, R.string.tab4_detail, shortTV, fullTV, show_more_btn);

        show_more_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewTools.OnClick();
            }
        });

    }

    public void setFont(View view) {

        sukhumvit = new Sukhumvit(getActivity().getAssets(), "fonts");
        TextView name = view.findViewById(R.id.tab_4_name);
        name.setTypeface(sukhumvit.bold());


    }

}
