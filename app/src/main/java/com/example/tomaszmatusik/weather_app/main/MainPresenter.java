package com.example.tomaszmatusik.weather_app.main;

import android.util.Log;

import com.example.tomaszmatusik.weather_app.data.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainInteractor mainInteractor;
    private MainContract.View mainView;

    @Inject
    public MainPresenter(MainInteractor mainInteractor, MainContract.View mainView) {
        this.mainInteractor = mainInteractor;
        this.mainView = mainView;
    }

    @Override
    public void handleWeatherData(Long woeid) {

        mainInteractor.getWeatherData(woeid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mainView.showLoadingBar(true);
                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        mainView.setWeatherList(weatherResponse.getWeatherList());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("API ERROR", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mainView.showLoadingBar(false);
                    }
                });
    }
}
