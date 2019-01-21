package com.rgipt.winterschoolrgipt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Abhilash on 08-12-2018.
 */

public class DS extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.ds_layout,container,false);
/*        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.);
        DisplayMetrics displayMetrics = new DisplayMetrics();
       getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int leftRightPadding = (int) Math.round(0.*width);
        int topbottomPadding = (int) Math.round(0.1*height);
        linearLayout.setPadding(leftRightPadding,topbottomPadding,leftRightPadding,topbottomPadding);*/
        return view;

    }

}
