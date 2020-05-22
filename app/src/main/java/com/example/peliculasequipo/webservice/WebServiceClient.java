package com.example.peliculasequipo.webservice;

import com.example.peliculasequipo.models.Datos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface WebServiceClient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String token = "6a65cda94028ea80ec3a4bf23998ebab";

    @Headers({
            "api_key:" + token
    })
    @GET("movie/popular")
    Call<Datos> getPeliculasP();
}
