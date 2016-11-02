package com.lstr.weather.app.datasource.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LSTR on 11/1/16.
 */
public class SysModel {
    private String country;
    private long sunrise;
    private long sunset;

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}