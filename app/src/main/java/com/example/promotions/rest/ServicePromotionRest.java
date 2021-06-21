package com.example.promotions.rest;

    import android.util.Log;

    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

public class ServicePromotionRest {

        private static final String TAG = "ServiceRest";
        private static IServicePromotionRest servicePromotionRest;
        public static IServicePromotionRest getInstance(){
            if(servicePromotionRest == null){
                Log.i(TAG, "========= initServiceRest ========");
                servicePromotionRest = new Retrofit.Builder()
                        .baseUrl(IServicePromotionRest.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(IServicePromotionRest.class);
            }
            return servicePromotionRest;
        }
    }

