package com.ravensoul.placesandweather.core;

import android.util.Log;

import com.google.gson.Gson;
import com.ravensoul.placesandweather.API.APIClient;
import com.ravensoul.placesandweather.API.WeatherAPI;
import com.ravensoul.placesandweather.data.WeatherData.WeatherData;
import com.ravensoul.placesandweather.view.MyView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Interactor implements MyView.Interactor {
    List<WeatherData> mWeatherData = new ArrayList<>();
    private WeatherAPI apiClient;

    public Interactor(WeatherAPI api) {
        this.apiClient = api;
    }

    @Override
    public void initRetrofitCall(String q, final MyView.onGetDataListener listener) {
        apiClient
                .getWeatherInfo(q, "2c667717d5c091ae26b893e67215ac35")
                .enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Log.d("DATA", new Gson().toJson(response.body()));
                            WeatherData data = response.body();
                            mWeatherData.add(data);
                            listener.onSuccess(mWeatherData);
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {
                        listener.onFailure(t.getMessage());
                    }
                });
    }
}
