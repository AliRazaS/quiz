package com.byteshaft.iqtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            TopSectionFragment topSectionFragment = new TopSectionFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, topSectionFragment)
                    .commit();
        }
    }

    public void changeLoginFragment (View view) {
        BottomSectionFragment bottomSectionFragment = new BottomSectionFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, bottomSectionFragment)
                .addToBackStack(null)
                .commit();
    }
    public void close(View view){
        MainActivity.this.finish();
    }
    public void back(View view){
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
