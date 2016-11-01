package com.lstr.weather.app.datasource.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LSTR on 11/1/16.
 */
public class WeatherModel {
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}