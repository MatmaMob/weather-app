package com.example.tomaszmatusik.weather_app.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("consolidated_weather")
    private List<Weather> weatherList;

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
