package com.lstr.weather.app.datasource;

import com.lstr.weather.app.datasource.model.ResponseData;

import retrofit.Call;
import retrofit.http.POST;
import retrofit.http.Url;

/**
 * Created by LSTR on 11/1/16.
 */
public interface HelperWS {
    @POST
    Call<ResponseData> getWeather(@Url String url);
}