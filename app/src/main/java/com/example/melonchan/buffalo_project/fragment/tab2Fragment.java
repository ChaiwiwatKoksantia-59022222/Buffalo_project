package com.example.melonchan.buffalo_project.fragment;

import com.example.melonchan.buffalo_project.R;
import com.example.melonchan.buffalo_project.font.Sukhumvit;
import com.example.melonchan.buffalo_project.tools.AppData;
import com.example.melonchan.buffalo_project.tools.DecodeTask;
import com.example.melonchan.buffalo_project.tools.TextviewTools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class tab2Fragment extends Fragment {

    Sukhumvit sukhumvit;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_tab2, container, false);

        //setFont(view);

        AppData appData = new AppData(getContext());

        String[] t1 = appData.getData(R.array.behavior_text_data);
        int[] t2 = appData.getData(R.array.behavior_image_data, R.drawable.unknown_picture);

        tab2Fragment.ListViewAdapter adapter = new tab2Fragment.ListViewAdapter(t1, t2, getContext());

        GridView listView = view.findViewById(R.id.tab_2_menu_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });

        ViewCompat.setNestedScrollingEnabled(listView, true);

        show_more();

        return view;
    }

    private class ListViewAdapter extends BaseAdapter {
        private String[] t1;
        private int[] t2;
        private Context context;
        private LayoutInflater INFLATER;


        public ListViewAdapter(String[] t1, int[] t2, Context context) {
            this.t1 = t1;
            this.t2 = t2;
            this.context = context;

            INFLATER = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

            int layout = R.layout.card_view_with_image;
            int iv = R.id.image_card_view_image;

            ImageView imageView = null;
            if (convertView == null) {
                convertView = INFLATER.inflate(layout, parent, false);
                imageView = convertView.findViewById(iv);
            } else {
                imageView = convertView.findViewById(iv);
                /*DecodeTask dt1 = (DecodeTask)imageView.getTag(iv);
                if(dt1 != null)
                    dt1.cancel(true);*/
            }

            TextView tv1 = convertView.findViewById(R.id.image_card_view_title_text);
            //TextView tv2 = convertView.findViewById(R.id.menu_circle_image);

            String count = String.valueOf(position + 1);

            /*
            imageView.setImageBitmap(null);
            DecodeTask dt2 = new DecodeTask(getContext(), imageView, t2[position]);
            dt2.execute();
            imageView.setTag(iv, dt2);*/

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;

            Bitmap s = BitmapFactory.decodeResource(context.getResources(),t2[position],options);


            //imageView.setImageResource(t2[position]);
            imageView.setImageBitmap(s);

            tv1.setText(count + "." + t1[position]);
            //tv2.setText(t2.get(position));

            return convertView;
        }
    }

    private void show_more() {
        TextView shortTV = view.findViewById(R.id.tab_2_detail_short);
        TextView fullTV = view.findViewById(R.id.tab_2_detail_full);
        TextView show_more_btn = view.findViewById(R.id.tab2_show_more_btn);

        final TextviewTools textviewTools = new TextviewTools(view, R.string.tab2_detail, shortTV, fullTV, show_more_btn);

        show_more_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewTools.OnClick();
            }
        });

    }

    public void setFont() {

        sukhumvit = new Sukhumvit(getActivity().getAssets(), "fonts");
        TextView name = view.findViewById(R.id.tab_2_name);
        name.setTypeface(sukhumvit.bold());
        TextView name_sub = view.findViewById(R.id.tab_2_name_sub);
        name_sub.setTypeface(sukhumvit.bold());


    }

}

