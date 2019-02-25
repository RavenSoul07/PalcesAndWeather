package com.ravensoul.placesandweather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ravensoul.placesandweather.di.AppComponent;
import com.ravensoul.placesandweather.di.DaggerAppComponent;
import com.ravensoul.placesandweather.di.Module;

public class BaseApp extends AppCompatActivity {

    AppComponent mComponent;

//    public static BaseApp get(Context context) {
//        return (BaseApp) context.getApplicationContext();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = DaggerAppComponent.builder()
                .module(new Module())
                .build();
//        mComponent.inject(this);
    }


    public AppComponent getComponent() {
        return mComponent;
    }

}
