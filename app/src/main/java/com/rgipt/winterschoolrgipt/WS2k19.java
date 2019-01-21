package com.rgipt.winterschoolrgipt;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Abhilash on 08-12-2018.
 */

public class WS2k19 extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.wstwoknineteen_layout,container,false);

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/SourceSansPro-Semibold.ttf");
        TextView textView = (TextView) view.findViewById(R.id.wstext);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.LinearLayoutws);
        textView.setTypeface(typeface);
        textView.setMovementMethod(new ScrollingMovementMethod());
/*
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int leftRightPadding = (int) Math.round(0.05*width);
        int topPadding = (int) Math.round(0.05*height);
        int bottomPadding = (int) Math.round(0.08*height);
        linearLayout.setPadding(leftRightPadding,topPadding,leftRightPadding,bottomPadding);
*/
        return view;

   }

}
