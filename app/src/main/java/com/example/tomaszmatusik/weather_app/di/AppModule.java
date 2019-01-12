package com.example.tomaszmatusik.weather_app.di;

import com.example.tomaszmatusik.weather_app.api.RetrofitHelper;
import com.example.tomaszmatusik.weather_app.main.MainContract;
import com.example.tomaszmatusik.weather_app.main.MainInteractor;
import com.example.tomaszmatusik.weather_app.main.MainPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {

    private MainContract.View mainView;

    public AppModule(MainContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    Retrofit provideRetrofitHelper() {
        return RetrofitHelper.getHelper();
    }

    @Provides
    MainInteractor provideMainRepository(Retrofit retrofit) {
        return new MainInteractor(retrofit);
    }

    @Provides
    MainContract.View provideMainView() {
        return mainView;
    }

    @Provides
    MainPresenter provideMainPresenter(MainInteractor mainInteractor) {
        return new MainPresenter(mainInteractor, mainView);
    }
}
