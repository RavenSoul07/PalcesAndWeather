package com.ravensoul.placesandweather.data.WeatherData;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Double deg;

    public Wind() {
    }

    /**
     * @return The speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * @param speed The speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * @return The deg
     */
    public Double getDeg() {
        return deg;
    }

    /**
     * @param deg The deg
     */
    public void setDeg(Double deg) {
        this.deg = deg;
    }
}
