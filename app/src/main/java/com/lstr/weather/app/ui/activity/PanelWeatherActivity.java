package com.lstr.weather.app.ui.activity;

import android.os.Bundle;

import com.lstr.weather.app.R;
import com.lstr.weather.app.ui.fragment.WeatherFragment;

/**
 * Created by LSTR on 10/30/16.
 */
public class PanelWeatherActivity extends BaseActivity implements WeatherFragment.OnListener{

    private final WeatherFragment weatherFragment = WeatherFragment.instance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_panel);

        showWheaterFragment();
    }

    private void showWheaterFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, weatherFragment).commit();
    }

    @Override
    public void nextActivity() {
        //TODO
    }
}