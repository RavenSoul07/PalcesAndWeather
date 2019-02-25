package com.ravensoul.placesandweather.di;

import com.ravensoul.placesandweather.view.MainActivity;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {Module.class})
public interface AppComponent {
//    void inject(BaseApp activity);
    void inject(MainActivity activity);
}
