package com.ravensoul.placesandweather.di;

import com.ravensoul.placesandweather.API.APIClient;
import com.ravensoul.placesandweather.API.WeatherAPI;
import com.ravensoul.placesandweather.core.Interactor;
import com.ravensoul.placesandweather.core.Presenter;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@dagger.Module
public class Module {

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    WeatherAPI provideApi(Retrofit retrofit) {
        return retrofit.create(WeatherAPI.class);
    }

    @Provides
    @Singleton
    Interactor provideInteractor(WeatherAPI api) {
        return new Interactor(api);
    }

    @Provides
    @Singleton
    Presenter providePresenter(Interactor interactor) {
        return new Presenter(interactor);
    }
}
