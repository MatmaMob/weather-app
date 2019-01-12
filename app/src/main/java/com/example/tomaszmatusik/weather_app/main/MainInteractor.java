package com.example.tomaszmatusik.weather_app.main;

import com.example.tomaszmatusik.weather_app.api.ApiService;
import com.example.tomaszmatusik.weather_app.data.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class MainInteractor implements MainContract.Model {

    private ApiService apiService;

    @Inject
    public MainInteractor(Retrofit retrofit) {
        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public Observable<WeatherResponse> getWeatherData(Long woeid) {
        return apiService.getWeatherData(woeid);
    }
}
