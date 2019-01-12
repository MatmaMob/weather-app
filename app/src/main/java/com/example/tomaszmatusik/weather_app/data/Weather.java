package com.example.tomaszmatusik.weather_app.data;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private Long id;
    @SerializedName("weather_state_name")
    private String weatherStateName;
    @SerializedName("weather_state_abbr")
    private String weatherStateAbbr;
    @SerializedName("wind_direction_compass")
    private String windDirection;
    @SerializedName("created")
    private String created;
    @SerializedName("applicable_date")
    private String applicableDate;
    @SerializedName("min_temp")
    private Double minTemp;
    @SerializedName("max_temp")
    private Double maxTemp;
    @SerializedName("wind_speed")
    private Double windSpeed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getWeatherStateAbbr() {
        return weatherStateAbbr;
    }

    public void setWeatherStateAbbr(String weatherStateAbbr) {
        this.weatherStateAbbr = weatherStateAbbr;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(String applicableDate) {
        this.applicableDate = applicableDate;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
