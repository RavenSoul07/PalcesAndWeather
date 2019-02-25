package com.ravensoul.placesandweather.utils;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.ravensoul.placesandweather.data.WeatherData.WeatherData;

import java.util.List;

public class DiffUtilWeather extends DiffUtil.Callback {

    List<WeatherData> oldList;
    List<WeatherData> newList;


    public DiffUtilWeather(List<WeatherData> oldList, List<WeatherData> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }


    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return oldList.get(i).getId().equals(newList.get(i1).getId());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return oldList.get(i).getMain().getTemp().equals(newList.get(i1).getMain().getTemp());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
