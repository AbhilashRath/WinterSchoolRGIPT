package com.rgipt.winterschoolrgipt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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

    public void cfd(View view){
        AlertDialog.Builder sBuilder = new AlertDialog.Builder(MainActivity.this);
        View sView = getLayoutInflater().inflate(R.layout.cfd_ds_about_dialogue, null);
        TextView textViewcfd = (TextView) sView.findViewById(R.id.about_cfd);
        textViewcfd.setVisibility(View.VISIBLE);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textViewcfd.setTypeface(typeface);
        textViewcfd.setMovementMethod(new ScrollingMovementMethod());
        sBuilder.setView(sView);
        AlertDialog dialog = sBuilder.create();
        dialog.show();

    }
    public void ds(View view){
        AlertDialog.Builder sBuilder = new AlertDialog.Builder(MainActivity.this);
        View sView = getLayoutInflater().inflate(R.layout.cfd_ds_about_dialogue, null);
        TextView textViewds = (TextView) sView.findViewById(R.id.about_ds);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textViewds.setTypeface(typeface);


        textViewds.setVisibility(View.VISIBLE);
        textViewds.setMovementMethod(new ScrollingMovementMethod());
        sBuilder.setView(sView);
        AlertDialog dialog = sBuilder.create();
        dialog.show();

    }
    public void paymentmode(View view){
        AlertDialog.Builder sBuilder = new AlertDialog.Builder(MainActivity.this);
        View sView = getLayoutInflater().inflate(R.layout.cfd_ds_about_dialogue, null);

        TextView textViewpayment = (TextView) sView.findViewById(R.id.about_payment);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textViewpayment.setTypeface(typeface);

        textViewpayment.setVisibility(View.VISIBLE);
        textViewpayment.setMovementMethod(new ScrollingMovementMethod());
        sBuilder.setView(sView);
        AlertDialog dialog = sBuilder.create();
        dialog.show();

    }

    public void project(View view){
        AlertDialog.Builder sBuilder = new AlertDialog.Builder(MainActivity.this);
        View sView = getLayoutInflater().inflate(R.layout.cfd_ds_about_dialogue, null);

        TextView textViewproject = (TextView) sView.findViewById(R.id.about_project);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textViewproject.setTypeface(typeface);

        textViewproject.setVisibility(View.VISIBLE);
        textViewproject.setMovementMethod(new ScrollingMovementMethod());
        sBuilder.setView(sView);
        AlertDialog dialog = sBuilder.create();
        dialog.show();
    }
    public void poster(View view){
        AlertDialog.Builder sBuilder = new AlertDialog.Builder(MainActivity.this);
        View sView = getLayoutInflater().inflate(R.layout.cfd_ds_about_dialogue, null);
        TextView textViewposter = (TextView) sView.findViewById(R.id.about_poster);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        textViewposter.setTypeface(typeface);

        textViewposter.setVisibility(View.VISIBLE);
        textViewposter.setMovementMethod(new ScrollingMovementMethod());
        sBuilder.setView(sView);
        AlertDialog dialog = sBuilder.create();
        dialog.show();
    }
    public static String FACEBOOK_URL = "https://www.facebook.com/sciencetechnical/";
    public static String FACEBOOK_PAGE_ID = "sciencetechnical";
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }
    public void fb(View view){
        try{
            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = getFacebookPageURL(this);
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);
        }catch (Exception e){
            startActivity(new Intent(Intent.ACTION_VIEW,    Uri.parse("https://www.facebook.com/sciencetechnical/")));
        }
    }
    public void lkd(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://company/science-technical-committee-rgipt"));
        final PackageManager packageManager = this.getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/science-technical-committee-rgipt/"));
        }
        startActivity(intent);
    }
    public void dialer(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:8890947171"));
        startActivity(intent);

    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public static String PACKAGE_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        PACKAGE_NAME = getApplicationContext().getPackageName();
        Log.i("Info",PACKAGE_NAME);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.wstwoknineteen_layout, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new WS2k19();
                    break;
                case 1:
                    fragment = new news_fragment();
                    break;
                case 2:
                    fragment = new schedule_fragment();
                    break;
                case 3:
                    fragment = new CFD();
                    break;
                case 4:
                    fragment = new DS();
                    break;
                case 5:
                    fragment = new Events();
                    break;
                case 6:
                    fragment = new REGISTER();
                    break;
                case 7:
                    fragment = new REACHUS();
                    break;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 8;
        }
    }
}
