package com.ravensoul.placesandweather.API;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    private static WeatherAPI weatherAPI;
    public static String URL = "http://api.openweathermap.org/data/2.5/";

    public static WeatherAPI getWeatherClient() {
        if (weatherAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            weatherAPI = retrofit.create(WeatherAPI.class);
        }
        return weatherAPI;
    }

}
