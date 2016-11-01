package com.lstr.weather.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lstr.weather.app.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startWheater();
            }
        }, 750);
    }

    private void startWheater() {
        startActivity(new Intent(this, PanelWeatherActivity.class));
        finish();
    }
}