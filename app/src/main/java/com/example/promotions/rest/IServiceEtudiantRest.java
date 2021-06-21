package com.example.promotions.rest;

import com.example.promotions.entite.Etudiant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IServiceEtudiantRest {

    public static final String ENDPOINT = "http://10.0.3.2/ecole/";

    @GET("promotion/{acronyme}/etudiant")
    Call<List<Etudiant>> getEtudiant(@Path("acronyme") String acronyme);

    //@GET("etudiant/{id}")
    //Call<Etudiant> getEtudiant(@Path("id") String id);

    @POST("promotion/{acronyme}/rapport")
    Call<Void> create(@Path("acronyme") String acronyme, @Body Etudiant etudiant);

}
