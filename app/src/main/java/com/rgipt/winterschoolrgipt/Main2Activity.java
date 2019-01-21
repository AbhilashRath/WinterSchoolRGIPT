package com.rgipt.winterschoolrgipt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView txtwinterschool;
    private Handler handler;
    private Runnable runnable;

    private VideoView videoView;

    Typeface typeface;


   @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        txtwinterschool = (TextView) findViewById(R.id.winterschool);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        int aspectratio = height/width;

        txtTimerDay.setTextSize(30*aspectratio);
        txtTimerHour.setTextSize(30*aspectratio);
        txtTimerMinute.setTextSize(30*aspectratio);
        txtTimerSecond.setTextSize(30*aspectratio);
        txtwinterschool.setTextSize(30*aspectratio);




        countDownStart();



        videoView = (VideoView) findViewById(R.id.sharp);
        videoView.setVideoPath("android.resource://com.rgipt.winterschoolrgipt/" + R.raw.wsteaser);
        videoView.start();
        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });

        typeface = Typeface.createFromAsset(getAssets(),"fonts/CALIBRIZ.TTF");
        TextView textView1 = (TextView) findViewById(R.id.date);
        TextView textView2 = (TextView) findViewById(R.id.question);
        TextView textView3 = (TextView) findViewById(R.id.SnT);
        Button button = (Button) findViewById(R.id.knowmore);
        button.setTypeface(typeface);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWinterSchool();
            }
        });
        textView2.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView3.setTypeface(typeface);
        txtTimerDay.setTypeface(typeface);
        txtTimerHour.setTypeface(typeface);
        txtTimerMinute.setTypeface(typeface);
        txtTimerSecond.setTypeface(typeface);
        txtwinterschool.setTypeface(typeface);

        textView1.setText(Html.fromHtml("19<sup>th</sup> - 20<sup>th</sup> January 2019"));
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2019-01-19");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes) );
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        txtwinterschool.setVisibility(View.VISIBLE);
                        txtwinterschool.setText("Today is WINTER SCHOOL !!");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }

    public void textViewGone() {
        findViewById(R.id.linearlayouttimer).setVisibility(View.GONE);
    }

    private void startWinterSchool() {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}


