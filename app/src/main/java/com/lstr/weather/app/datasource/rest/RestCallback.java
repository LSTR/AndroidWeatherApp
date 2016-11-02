package com.lstr.weather.app.datasource.rest;

/**
 * Created by LSTR on 11/1/16.
 */
public interface RestCallback {
    void onSuccess(Object object);
    void onError(Object object);
}