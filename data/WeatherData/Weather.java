package com.ravensoul.placesandweather.data.WeatherData;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private Integer wId;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public Weather() {
    }

    /**
     *
     * @return The wId
     */
    public Integer getwId() {
        return wId;
    }

    /**
     *
     * @param wId The wId
     */
    public void setwId(Integer wId) {
        this.wId = wId;
    }

    /**
     *
     * @return The main
     */
    public String getMain() {
        return main;
    }

    /**
     *
     * @param main The main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon The
     *
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
