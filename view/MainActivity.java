package com.ravensoul.placesandweather.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.Places;
import com.ravensoul.placesandweather.BaseApp;
import com.ravensoul.placesandweather.R;
import com.ravensoul.placesandweather.adapter.WeatherAdapter;
import com.ravensoul.placesandweather.core.Presenter;
import com.ravensoul.placesandweather.data.WeatherData.WeatherData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class MainActivity extends BaseApp implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, MyView.View {

    @Inject
    Presenter mPresenter;
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private WeatherAdapter mAdapter;
    private List<WeatherData> mList = new ArrayList<>();
    private GoogleApiClient mGoogleApiClient;
    String city;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        getComponent().inject(this);
        mPresenter.setView(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new WeatherAdapter(mList, MainActivity.this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));


        mGoogleApiClient = new GoogleApiClient.Builder(MainActivity.this)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, 0, this)
                .addConnectionCallbacks(this)
                .build();

        final EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 1) {
                    mRecyclerView.setAdapter(mAdapter);
                    mList.clear();
                    mAdapter.notifyDataSetChanged();
                    final List<PlaceAutoComplete> list = getPredicitons(s);
                    for (int i = 0; i < list.size(); i++) {
                        city = list.get(i).description.toString();
                        mPresenter.getDataFromURL(city);
                    }
                }
            }
        });
    }


    private ArrayList<PlaceAutoComplete> getPredicitons(final CharSequence constraint) {
        if (mGoogleApiClient != null) {

            final ArrayList<PlaceAutoComplete> result = new ArrayList<>();

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    AutocompleteFilter autocompleteFilter = new AutocompleteFilter.Builder()
                            .setCountry("KZ")
                            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_CITIES)
                            .build();

                    PendingResult<AutocompletePredictionBuffer> results = Places.GeoDataApi
                            .getAutocompletePredictions(mGoogleApiClient, constraint.toString(),
                                    null, autocompleteFilter);

                    AutocompletePredictionBuffer autocompletePredictions = results
                            .await(60, TimeUnit.SECONDS);

                    final Status status = autocompletePredictions.getStatus();
                    if (!status.isSuccess()) {
//                        Toast.makeText(MainActivity.this, "Error: " + status.toString(),
//                                Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Error getting place predictions: " + status
                                .toString());
                        autocompletePredictions.release();
                    }

                    Iterator<AutocompletePrediction> iterator = autocompletePredictions.iterator();
                    ArrayList<PlaceAutoComplete> resultList = new ArrayList<>(autocompletePredictions.getCount());
                    while (iterator.hasNext()) {
                        AutocompletePrediction prediction = iterator.next();
                        Log.d(TAG, "run: prediction city " + prediction.getPrimaryText(null));
                        resultList.add(new PlaceAutoComplete(prediction.getPlaceId(), prediction.getPrimaryText(null)));
                    }
                    result.addAll(resultList);
                    autocompletePredictions.release();
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return result;
        }
        return null;
    }

    @Override
    public void onGetDataSuccess(List<WeatherData> list) {
        Log.d(TAG, "onGetDataSuccess: " + list);
        mAdapter.updateList(list);
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d(TAG, "onGetDataFailure: " + message);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public class PlaceAutoComplete {

        public CharSequence placeId;
        public CharSequence description;

        public PlaceAutoComplete(CharSequence placeId, CharSequence description) {
            this.placeId = placeId;
            this.description = description;
        }

        @NonNull
        @Override
        public String toString() {
            return description.toString();
        }
    }
}
