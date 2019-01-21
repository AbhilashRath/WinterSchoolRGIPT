package com.rgipt.winterschoolrgipt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Abhilash on 08-12-2018.
 */

public class REACHUS extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.reachus_layout,container,false);

        Button button = (Button) view.findViewById(R.id.send);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rootLayoutreachus);

        DisplayMetrics displayMetrics = new DisplayMetrics();
/*        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int leftRightPadding = (int) Math.round(0.1*width);
        int topbottomPadding = (int) Math.round(0.1*height);
        linearLayout.setPadding(leftRightPadding,topbottomPadding,leftRightPadding,topbottomPadding);*/

        final EditText message = (EditText) view.findViewById(R.id.message);
        final EditText subject = (EditText) view.findViewById(R.id.subject);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"science_technical@rgipt.ac.in"});
                i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT   , message.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
