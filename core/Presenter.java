package com.ravensoul.placesandweather.core;


import com.ravensoul.placesandweather.data.WeatherData.WeatherData;
import com.ravensoul.placesandweather.view.MyView;

import java.util.List;

public class Presenter implements MyView.Presenter, MyView.onGetDataListener {

//    private MyView myView;
    private MyView.View mView;
    private Interactor mInteractor;

    public Presenter(Interactor interactor) {
        this.mInteractor = interactor;
    }

    public void setView(MyView.View vIew) {
        this.mView = vIew;
    }


    @Override
    public void getDataFromURL(String city) {
        mInteractor.initRetrofitCall(city, this);
    }

    @Override
    public void onSuccess(List<WeatherData> list) {
        mView.onGetDataSuccess(list);
    }

    @Override
    public void onFailure(String message) {
        mView.onGetDataFailure(message);
    }
}
