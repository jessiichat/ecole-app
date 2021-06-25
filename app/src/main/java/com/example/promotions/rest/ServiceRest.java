package com.example.promotions.rest;

    import android.util.Log;

    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRest {

        private static final String TAG = "ServiceRest";
        private static IServiceRest servicePromotionRest;
        public static IServiceRest getInstance(){
            if(servicePromotionRest == null){
                Log.i(TAG, "========= initServiceRest ========");
                servicePromotionRest = new Retrofit.Builder()
                        .baseUrl(IServiceRest.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(IServiceRest.class);
            }
            return servicePromotionRest;
        }
    }

