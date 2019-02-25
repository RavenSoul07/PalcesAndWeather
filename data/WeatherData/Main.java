package com.ravensoul.placesandweather.data.WeatherData;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private Double temp;
    @SerializedName("pressure")
    private Double pressure;
    @SerializedName("humidity")
    private Double humidity;
    @SerializedName("temp_min")
    private Double temp_min;
    @SerializedName("temp_max")
    private Double temp_max;

    public Main() {
    }

    /**
     * @return The temp
     */
    public Double getTemp() {
        return temp;
    }

    /**
     * @param temp The temp
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     * @return The presssure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * @param pressure The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return The humidity
     */
    public Double getHumidity() {
        return humidity;
    }

    /**
     * @param humidity The humidity
     */
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    /**
     * @return The temp_min
     */
    public Double getTemp_min() {
        return temp_min;
    }

    /**
     * @param temp_min The temp_min
     */
    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    /**
     * @return The temp_max
     */
    public Double getTemp_max() {
        return temp_max;
    }

    /**
     * @param temp_max The temp_max
     */
    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }


}
