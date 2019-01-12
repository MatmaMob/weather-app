package com.example.tomaszmatusik.weather_app.api;

import com.example.tomaszmatusik.weather_app.data.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("location/{woeid}")
    Observable<WeatherResponse> getWeatherData(@Path("woeid") Long woeid);
}
