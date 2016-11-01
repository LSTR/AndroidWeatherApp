package com.lstr.weather.app.view;

import android.content.Context;

import com.lstr.weather.app.datasource.model.ResponseData;

/**
 * Created by LSTR on 11/1/16.
 */
public interface WeatherView {
    Context getContext();
    void showResult(ResponseData data);
}
