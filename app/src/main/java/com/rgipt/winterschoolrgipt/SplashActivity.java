package com.rgipt.winterschoolrgipt;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView snt = (ImageView) findViewById(R.id.snt);
        final TextView loadingText = (TextView)findViewById(R.id.loading);

        Thread splashTimer = new Thread(){
            public void run(){
                try{
                    int splashTime = 0;
                    while(splashTime < 6000){

                        sleep(100);

                        if(splashTime < 500){
                            setText(".");
                        }
                        else if(splashTime >= 500 && splashTime < 1000 ){
                            setText("..");
                        }else if(splashTime >= 1000 && splashTime < 1500 ){
                            setText("...");
                        }else if(splashTime >= 1500 && splashTime < 2000 ){
                            setText(".");
                        }else if(splashTime >= 2000 && splashTime < 2500 ){
                            setText("..");
                        }else if(splashTime >= 2500 && splashTime < 3000 ){
                            setText("...");
                        }else if(splashTime >= 3000 && splashTime < 3500 ){
                            setText(".");
                        }else if(splashTime >= 3500 && splashTime < 4000 ){
                            setText("..");
                        }else if(splashTime >= 4000 && splashTime < 4500 ){
                            setText("...");
                        }else if(splashTime >= 4500 && splashTime < 5000 ){
                            setText(".");
                        }else if(splashTime >= 5000 && splashTime < 5500 ){
                            setText("..");
                        }else if (splashTime >= 5500){
                            setText("...");
                        }
                        splashTime = splashTime + 100;

                    }
                    Intent intent = new Intent(SplashActivity.this,Main2Activity.class);
                    startActivity(intent);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                finally{
                    finish();
                }
            }
        };
        splashTimer.start();
    }
    private void setText(final CharSequence text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.loading)).setText(text);
            }
        });
    }
}


