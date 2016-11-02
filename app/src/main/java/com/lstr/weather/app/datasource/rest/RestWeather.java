package com.lstr.weather.app.datasource.rest;

import com.lstr.weather.app.datasource.model.ResponseData;
import com.lstr.weather.app.datasource.rest.retrofit.ConfigurationWS;
import com.lstr.weather.app.datasource.rest.retrofit.HelperWS;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by jmtech on 11/1/16.
 */
public class RestWeather {

    public void getUpdateWeatherData(String city, final RestCallback restCallback){
        HelperWS helperWS = ConfigurationWS.getConfiguration().create(HelperWS.class);
        Call<ResponseData> result = helperWS.getWeather("weather?q=" + city + "&units=metric&appid=92191c19457fe9b7fca86d665edc8bf7");
        result.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Response<ResponseData> response, Retrofit retrofit) {
                ResponseData resultado = response.body();
                if (resultado != null) {
                        restCallback.onSuccess(resultado);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                restCallback.onError(t.getMessage());
            }
        });
    }
}