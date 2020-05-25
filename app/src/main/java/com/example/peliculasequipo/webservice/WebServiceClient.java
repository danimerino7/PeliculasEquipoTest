package com.example.peliculasequipo.webservice;

import com.example.peliculasequipo.models.Datos;
import com.example.peliculasequipo.models.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServiceClient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String token = "6a65cda94028ea80ec3a4bf23998ebab";

    @GET("movie/popular")
    Call<Datos> getPeliculasP(@Query("api_key")String tokenn, @Query("language") String lng);

    //estrenos
    @GET("/movie/{movie_id}/release_dates")
    Call<List<Pelicula>> getReleasesDates(@Path("movie_id") int movie_id, @Query("api_key") String token);


}
