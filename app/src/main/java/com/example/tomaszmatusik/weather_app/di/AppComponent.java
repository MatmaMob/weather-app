package com.example.tomaszmatusik.weather_app.di;

import com.example.tomaszmatusik.weather_app.main.MainActivity;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
