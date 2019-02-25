package com.ravensoul.placesandweather.API;


import com.ravensoul.placesandweather.data.WeatherData.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface WeatherAPI {

    @GET("weather?")
    Call<WeatherData> getWeatherInfo(@Query("q") String city, @Query("appid") String appId);
}
