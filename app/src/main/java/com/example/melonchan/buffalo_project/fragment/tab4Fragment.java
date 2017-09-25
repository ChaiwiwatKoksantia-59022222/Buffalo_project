package com.example.melonchan.buffalo_project.fragment;

import com.example.melonchan.buffalo_project.R;
import com.example.melonchan.buffalo_project.font.Sukhumvit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class tab4Fragment extends Fragment {

    Sukhumvit sukhumvit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab4,container,false);

        //setFont(view);

        return view;
    }

    public void setFont(View view){

        sukhumvit = new Sukhumvit(getActivity().getAssets(),"fonts");
        TextView name = view.findViewById(R.id.tab_4_name);
        name.setTypeface(sukhumvit.bold());


    }

}
