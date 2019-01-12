package com.example.tomaszmatusik.weather_app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.tomaszmatusik.weather_app.R;
import com.example.tomaszmatusik.weather_app.adapter.WeatherRecyclerAdapter;
import com.example.tomaszmatusik.weather_app.data.Weather;
import com.example.tomaszmatusik.weather_app.di.AppModule;
import com.example.tomaszmatusik.weather_app.di.DaggerAppComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final int WARSAW_WOEID = 523920;

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.weather_recycler_view)
    RecyclerView weatherRecyclerView;

    @BindView(R.id.loading_bar)
    ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setDaggerDependency();
        mainPresenter.handleWeatherData((long) WARSAW_WOEID);
    }

    @Override
    public void setWeatherList(List<Weather> weatherList) {

        WeatherRecyclerAdapter adapter = new WeatherRecyclerAdapter(this, weatherList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        weatherRecyclerView.setLayoutManager(lm);
        weatherRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoadingBar(boolean isLoading) {
        if (!isLoading) {
            loadingBar.setVisibility(View.GONE);
        } else {
            loadingBar.setVisibility(View.VISIBLE);
        }
    }

    public void setDaggerDependency() {
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);
    }
}
