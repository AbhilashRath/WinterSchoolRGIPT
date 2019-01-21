package com.rgipt.winterschoolrgipt;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Abhilash on 08-12-2018.
 */

public class REGISTER extends Fragment {

    private VideoView videoView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.register_layout,container,false);

        TextView textView = (TextView) view.findViewById(R.id.txtpayment);
/*        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rootLinearLayout);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int leftRightPadding = (int) Math.round(0.05*width);
        int bottomPadding = (int) Math.round(0.07*height);
        int topPadding = (int) Math.round(0.04*height);
        linearLayout.setPadding(leftRightPadding,topPadding,leftRightPadding,bottomPadding);*/

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textView.setTypeface(typeface);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button buttonregisterrgipt = (Button) view.findViewById(R.id.register_rgipt);
        Button buttonregisterpublic = (Button) view.findViewById(R.id.register_public);

        buttonregisterrgipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startgoogleformrgipt();
            }
        });
        buttonregisterpublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startgoogleformpublic();
            }
        });



        return view;
    }
    public void startgoogleformrgipt(){
        Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScpf8OfIvlExxoO2DGEv8f666ijo9IzNArN8_4D8kO96x11tQ/viewform");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void startgoogleformpublic(){
        Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeIMq12mNLvRLEFeKyFqpdsk32-7Dq4FEf5nobbNxWjO7JZ7g/viewform");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }



}
