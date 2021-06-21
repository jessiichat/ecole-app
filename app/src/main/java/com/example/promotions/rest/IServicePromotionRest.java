package com.example.promotions.rest;

import com.example.promotions.entite.Promotion;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IServicePromotionRest {

    public static final String ENDPOINT = "http://10.0.3.2:8080/ecole/";

    @GET("promotion")
    Call<List<Promotion>> getPromotions();
    @GET("promotion/{acronyme}")
    Call<Promotion> getPromotion(@Path("acronyme") String acronyme);
    @POST("promotion")
    Call<Void> creerPromotion(@Body Promotion promotion);

}
