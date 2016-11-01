package com.lstr.weather.app.presenter;

import android.content.Context;

import com.lstr.weather.app.datasource.ConfigurationWS;
import com.lstr.weather.app.datasource.HelperWS;
import com.lstr.weather.app.datasource.model.ResponseData;
import com.lstr.weather.app.view.WeatherView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by LSTR on 11/1/16.
 */
public class WeatherPresenter {

    private Context context;
    private WeatherView weatherView;

    public void addView(WeatherView weatherView){
        this.weatherView = weatherView;
        context = weatherView.getContext();
    }

    public void removeView(){
        this.weatherView = null;
    }

    public void getUpdateWeatherData(String city){
        HelperWS helperWS = ConfigurationWS.getConfiguration().create(HelperWS.class);
        Call<ResponseData> result = helperWS.getWeather("weather?q=" + city + "&units=metric&appid=92191c19457fe9b7fca86d665edc8bf7");
        result.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Response<ResponseData> response, Retrofit retrofit) {
                ResponseData resultado = response.body();
                if (resultado != null) {
                    if(weatherView != null) {
                        weatherView.showResult(resultado);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}