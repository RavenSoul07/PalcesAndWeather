package com.ravensoul.placesandweather.view;

import com.ravensoul.placesandweather.data.WeatherData.WeatherData;

import java.util.List;

public interface MyView {

    interface View {
        void onGetDataSuccess(List<WeatherData> list);

        void onGetDataFailure(String message);
    }

    interface Presenter {
        void getDataFromURL(String city);
    }

    interface Interactor {
        void initRetrofitCall(String city, MyView.onGetDataListener listener);

    }

    interface onGetDataListener {
        void onSuccess(List<WeatherData> list);

        void onFailure(String message);
    }
}
