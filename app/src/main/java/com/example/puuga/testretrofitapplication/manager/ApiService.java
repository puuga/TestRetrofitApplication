package com.example.puuga.testretrofitapplication.manager;

import com.example.puuga.testretrofitapplication.model.LocationEntry;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by siwao on 17/7/2559.
 */
public interface ApiService {
    @GET("track_geo_check_v2.php")
    Call<LocationEntry[]> loadLocationEntry();
}
