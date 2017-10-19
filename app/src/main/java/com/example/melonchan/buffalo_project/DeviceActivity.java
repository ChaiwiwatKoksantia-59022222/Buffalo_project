package com.example.melonchan.buffalo_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.melonchan.buffalo_project.tools.AppData;

public class DeviceActivity extends AppCompatActivity {

    private String ID, TITLE, SUBTITLE;

    private String[] t1,t3;
    private int[] t2;

    private int layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        AppData appData = new AppData(this);

        Bundle bundle = getIntent().getExtras();
        ID = bundle.getString("ID");
        TITLE = bundle.getString("TITLE");
        SUBTITLE = bundle.getString("SUBTITLE");

        TextView textView = (TextView) findViewById(R.id.device_name);
        textView.setText(TITLE);
        TextView text = (TextView) findViewById(R.id.device_name_sub);
        text.setText(SUBTITLE);


        if (ID.contentEquals("1")) {
            layout = R.layout.card_view_with_image;
            t1 = appData.getData(R.array.induction_equipment_text_data);
            t2 = appData.getData(R.array.induction_equipment_image_data, R.drawable.unknown_picture);
            text.setVisibility(View.VISIBLE);
        } else if (ID.contentEquals("2")) {
            layout = R.layout.card_view_with_image;
            t1 = appData.getData(R.array.artificial_insemination_equipment_text_data);
            t2 = appData.getData(R.array.artificial_insemination_image_data, R.drawable.unknown_picture);
            text.setVisibility(View.VISIBLE);
        } else if (ID.contentEquals("3")) {
            layout = R.layout.card_view_detail_with_image;
            t3 = appData.getData(R.array.t1_des);
            t1 = appData.getData(R.array.induction_program_text_data);
            t2 = appData.getData(R.array.induction_program_image_data, R.drawable.unknown_picture);
            text.setVisibility(View.VISIBLE);

        } else if (ID.contentEquals("4")) {
            layout = R.layout.card_view_with_image;
            t1 = appData.getData(R.array.artificial_insemination_short_method_text_data);
            t2 = appData.getData(R.array.artificial_insemination_short_method_image_data, R.drawable.unknown_picture);
            text.setVisibility(View.GONE);
        }

        DeviceActivity.ListViewAdapter adapter = new DeviceActivity.ListViewAdapter(t1, t2, this);

        GridView listView = (GridView) findViewById(R.id.device_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            }
        });

        ViewCompat.setNestedScrollingEnabled(listView, true);

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
            TextView tv2 = convertView.findViewById(R.id.image_card_view_des_text);
            //TextView tv2 = convertView.findViewById(R.id.menu_circle_image);
            RelativeLayout line = convertView.findViewById(R.id.line_de);

            String count = String.valueOf(position + 1);

            if (ID.contentEquals("3")){
                if (!t3[position].contentEquals("No")){
                    tv2.setText(t3[position]);
                    tv2.setVisibility(View.VISIBLE);
                }else {
                    tv2.setVisibility(View.GONE);
                }
            }
            else {
                tv2.setVisibility(View.GONE);
            }

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;

            Bitmap s = BitmapFactory.decodeResource(context.getResources(),t2[position],options);

            /*
            imageView.setImageBitmap(null);
            DecodeTask dt2 = new DecodeTask(getContext(), imageView, t2[position]);
            dt2.execute();
            imageView.setTag(iv, dt2);*/
            if (t2[position] == R.drawable.unknown_picture){
                imageView.setVisibility(View.GONE);
                tv1.setText(t1[position]);
                line.setVisibility(View.GONE);
            }else {
                imageView.setVisibility(View.VISIBLE);
                //imageView.setImageResource(t2[position]);
                imageView.setImageBitmap(s);
                tv1.setText(count + "." + t1[position]);
                line.setVisibility(View.VISIBLE);
            }
            if (!ID.contentEquals("3")){
                line.setVisibility(View.GONE);
            }

            //tv2.setText(t2.get(position));

            return convertView;
        }
    }

}
