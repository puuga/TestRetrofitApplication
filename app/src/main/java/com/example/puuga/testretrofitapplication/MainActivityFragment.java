package com.example.puuga.testretrofitapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puuga.testretrofitapplication.adapter.LocationEntryAdapter;
import com.example.puuga.testretrofitapplication.manager.ApiService;
import com.example.puuga.testretrofitapplication.model.LocationEntry;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private LocationEntry[] locationEntries;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(view);
        loadLocationEntry();
        return view;
    }

    public void loadLocationEntry() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://128.199.133.166/roomlink/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<LocationEntry[]> call = service.loadLocationEntry();

        call.enqueue(new Callback<LocationEntry[]>() {
            @Override
            public void onResponse(Call<LocationEntry[]> call, Response<LocationEntry[]> response) {
                Log.d("api", "onResponse");
                if (response.body() != null) {
                    Log.d("api", "onResponse - " + response.body().length);
                    locationEntries = response.body();
                    LocationEntryAdapter mAdapter = new LocationEntryAdapter(locationEntries);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<LocationEntry[]> call, Throwable t) {
                Log.d("api", "onFailure", t);
            }
        });
    }

    private void initInstances(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        LocationEntryAdapter mAdapter = new LocationEntryAdapter(locationEntries);
        mRecyclerView.setAdapter(mAdapter);
    }
}
