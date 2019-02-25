package com.ravensoul.placesandweather.data.WeatherData;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private Integer all;

    public Clouds() {
    }

    /**
     *
     * @return The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}
