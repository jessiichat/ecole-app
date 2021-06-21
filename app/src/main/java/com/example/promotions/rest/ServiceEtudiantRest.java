package com.example.promotions.rest;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceEtudiantRest {

    private static final String TAG = "ServiceEtudiantRest";
    private static IServiceEtudiantRest serviceEtudiantRest;
    public static IServiceEtudiantRest getInstance(){
        if(serviceEtudiantRest == null){
            Log.i(TAG, "========= initServiceRest ========");
            serviceEtudiantRest = new Retrofit.Builder()
                    .baseUrl(IServiceEtudiantRest.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IServiceEtudiantRest.class);
        }
        return serviceEtudiantRest;
    }
}
