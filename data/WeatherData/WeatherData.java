package com.ravensoul.placesandweather.data.WeatherData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {

    @SerializedName("coord")
    private Coord mCoord;
    @SerializedName("weather")
    private List<Weather> mWeather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("visibility")
    private Integer visibility;
    @SerializedName("wind")
    private Wind mWind;
    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("dt")
    private Integer dt;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private Integer cod;

    public WeatherData() {
    }

    /**
     * @return The coord
     */
    public Coord getCoord() {
        return mCoord;
    }

    /**
     * @param coord The coord
     */
    public void setCoord(Coord coord) {
        mCoord = coord;
    }

    /**
     * @return The weather
     */
    public List<Weather> getWeather() {
        return mWeather;
    }

    /**
     * @param weather The weather
     */
    public void setWeather(List<Weather> weather) {
        mWeather = weather;
    }

    /**
     * @return The base
     */
    public String getBase() {
        return base;
    }

    /**
     * @param base The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * @return The main
     */
    public Main getMain() {
        return mMain;
    }

    /**
     * @param main The main
     */
    public void setMain(Main main) {
        mMain = main;
    }

    /**
     * @return The visibility
     */
    public Integer getVisibility() {
        return visibility;
    }

    /**
     * @param visibility The visibility
     */
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    /**
     * @return The wind
     */
    public Wind getWind() {
        return mWind;
    }

    /**
     * @param wind The wind
     */
    public void setWind(Wind wind) {
        mWind = wind;
    }

    /**
     * @return The clouds
     */
    public Clouds getClouds() {
        return mClouds;
    }

    /**
     * @param clouds The clouds
     */
    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    /**
     * @return The dt
     */
    public Integer getDt() {
        return dt;
    }

    /**
     * @param dt The dt
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * @return The sys
     */
    public Sys getSys() {
        return mSys;
    }

    /**
     * @param sys The sys
     */
    public void setSys(Sys sys) {
        mSys = sys;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
