package com.lstr.weather.app.presenter;

import android.content.Context;

import com.lstr.weather.app.datasource.location.GeoLocation;
import com.lstr.weather.app.datasource.location.GpsListener;
import com.lstr.weather.app.datasource.location.GpsLocation;
import com.lstr.weather.app.datasource.model.ResponseData;
import com.lstr.weather.app.datasource.rest.RestCallback;
import com.lstr.weather.app.datasource.rest.RestWeather;
import com.lstr.weather.app.view.WeatherView;

/**
 * Created by LSTR on 11/1/16.
 */
public class WeatherPresenter {

    private Context context;
    private WeatherView weatherView;
    private RestWeather restWeather;
    private GpsLocation gpsLocation;
    private GeoLocation geoLocation;

    public void addView(WeatherView weatherView){
        this.weatherView = weatherView;
        context = weatherView.getContext();

        restWeather = new RestWeather();
        geoLocation = new GeoLocation(context);
    }

    public void getLatLng(){
         gpsLocation = new GpsLocation(new GpsListener() {
            @Override
            public Context getContext() {
                return context;
            }

            @Override
            public void sendLocation(double latitude, double longitude) {
                getCityName(latitude, longitude);
                gpsLocation.disconnect();
            }
        });
        gpsLocation.connect();
    }

    public void getCityName(double latitude, double longitude){
        String city = geoLocation.getLocationName(latitude, longitude);
        weatherView.showCity(city);
    }


    public void getUpdateWeatherData(String city){
        restWeather.getUpdateWeatherData(city, new RestCallback() {
            @Override
            public void onSuccess(Object object) {
                ResponseData data = (ResponseData)object;
                weatherView.showResult(data);
            }

            @Override
            public void onError(Object object) {
                System.out.println("Error:"+ object);
            }
        });
    }

    public void removeView(){
        this.weatherView = null;
    }
}