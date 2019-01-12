package com.example.tomaszmatusik.weather_app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tomaszmatusik.weather_app.R;
import com.example.tomaszmatusik.weather_app.data.Weather;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherRecyclerAdapter extends RecyclerView.Adapter {

    private static final int TODAY_TYPE = 0;
    private static final int NORMAL_TYPE = 1;

    private List<Weather> weatherList;
    private Context context;

    public WeatherRecyclerAdapter(Context context, List<Weather> weatherList) {
        this.weatherList = weatherList;
        this.context = context;
    }

    static class TodayWeatherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.min_temp)
        TextView minTempView;

        @BindView(R.id.max_temp)
        TextView maxTempView;

        @BindView(R.id.wind_speed)
        TextView windSpeedView;

        @BindView(R.id.wind_direction)
        TextView windDirectionView;

        @BindView(R.id.weather_icon)
        ImageView weatherIconView;

        @BindView(R.id.date)
        TextView dateView;

        public TodayWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.min_temp)
        TextView minTempView;

        @BindView(R.id.max_temp)
        TextView maxTempView;

        @BindView(R.id.weather_icon)
        ImageView weatherIconView;

        @BindView(R.id.date)
        TextView dateView;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        if (i == TODAY_TYPE) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_today_weather, viewGroup, false);
            return new TodayWeatherViewHolder(v);
        }
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_weather, viewGroup, false);
        return new WeatherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        Weather weather = weatherList.get(position);

        if (viewHolder instanceof TodayWeatherViewHolder) {
            TodayWeatherViewHolder todayHolder = (TodayWeatherViewHolder) viewHolder;
            todayHolder.maxTempView.setText(String.valueOf(Math.round(weather.getMaxTemp())) + " \u2103");
            todayHolder.minTempView.setText(String.valueOf(Math.round(weather.getMinTemp())) + " \u2103");
            todayHolder.windDirectionView.setText(weather.getWindDirection());
            todayHolder.windSpeedView.setText(String.valueOf(Math.round(weather.getWindSpeed())) + " mph");
            Glide.with(context).load("https://www.metaweather.com/static/img/weather/png/64/" + weather.getWeatherStateAbbr() + ".png").into(todayHolder.weatherIconView);
        } else {
            WeatherViewHolder weatherHolder = (WeatherViewHolder) viewHolder;
            weatherHolder.maxTempView.setText(String.valueOf(Math.round(weather.getMaxTemp())) + " \u2103");
            weatherHolder.minTempView.setText(String.valueOf(Math.round(weather.getMinTemp())) + " \u2103");
            weatherHolder.dateView.setText(weather.getApplicableDate());
            Glide.with(context).load("https://www.metaweather.com/static/img/weather/png/64/" + weather.getWeatherStateAbbr() + ".png").into(weatherHolder.weatherIconView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TODAY_TYPE;
        }
        return NORMAL_TYPE;
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }
}
