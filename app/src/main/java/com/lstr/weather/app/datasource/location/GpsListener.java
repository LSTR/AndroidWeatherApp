package com.lstr.weather.app.datasource.location;

import android.content.Context;

/**
 * Created by jmtech on 11/1/16.
 */
public interface GpsListener{
    Context getContext();
    void sendLocation(double latitude, double longitude);
}