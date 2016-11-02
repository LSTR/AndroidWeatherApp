package com.lstr.weather.app.datasource.model;

/**
 * Created by LSTR on 11/1/16.
 */
public class MainModel {
    private String humidity;
    private String pressure;
    private Double temp;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}