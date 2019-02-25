package com.ravensoul.placesandweather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ravensoul.placesandweather.R;
import com.ravensoul.placesandweather.data.WeatherData.WeatherData;
import com.ravensoul.placesandweather.utils.DiffUtilWeather;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    private List<WeatherData> mData;
    private Context context;

    public WeatherAdapter(List<WeatherData> data, Context context) {
        mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        WeatherData data = mData.get(i);
        myViewHolder.namer.setText(data.getName());
        myViewHolder.temper.setText(data.getMain().getTemp().toString());
        myViewHolder.descer.setText(data.getWeather().get(0).getDescription());
    }

    @Override
    public int getItemCount() {
        if ((mData != null) && (mData.size() != 0)) {
            return mData.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView temper, namer, descer;

        public MyViewHolder(View view) {
            super(view);
            this.temper = view.findViewById(R.id.temp);
            this.namer = view.findViewById(R.id.name);
            this.descer = view.findViewById(R.id.desc);
        }
    }

    public void updateList(List<WeatherData> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtilWeather(this.mData, newList));
        diffResult.dispatchUpdatesTo(this);
        this.mData.clear();
        this.mData.addAll(newList);
    }

}
