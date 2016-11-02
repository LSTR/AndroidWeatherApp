package com.lstr.weather.app.datasource.rest.retrofit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by LSTR on 11/1/16.
 */
public class ConfigurationWS {
    public static Retrofit getConfiguration() {
        return new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}