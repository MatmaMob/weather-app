package com.example.tomaszmatusik.weather_app.main;

import com.example.tomaszmatusik.weather_app.data.Weather;
import com.example.tomaszmatusik.weather_app.data.WeatherResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MainContract {

    interface View {
        void setWeatherList(List<Weather> weatherList);

        void showLoadingBar(boolean isLoading);
    }

    interface Presenter {
        void handleWeatherData(Long woeid);
    }

    interface Model {
        Observable<WeatherResponse> getWeatherData(Long woeid);
    }
}

