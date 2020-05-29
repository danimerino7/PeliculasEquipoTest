package com.example.peliculasequipo.webservice;

import com.example.peliculasequipo.models.Datos;
import com.example.peliculasequipo.models.Pelicula;
import com.example.peliculasequipo.models.Similares;
import com.example.peliculasequipo.models2.Datos2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET("movies/get-upcoming")
    Call<Datos2> getEstrenos(@Query("api_key")String token, @Query("language") String lng);

    //Similares
    @GET("movie/{movie_id}/similar")
    Call<Similares> getSimilar(@Path("movie_id") int movie_id, @Query("api_key") String token);


    //probe esto pero nada y con la url esa si carga el objeto
    //Call<Datos2> getEstrenos(@Query("api_key")String token, @Query("language") String lng, @Query("page=") int page);
    // https://api.themoviedb.org/3/movie/upcoming?api_key=6a65cda94028ea80ec3a4bf23998ebab&language=es-ES&page=






}
