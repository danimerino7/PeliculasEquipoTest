package com.example.peliculasequipo.webservice;

import com.example.peliculasequipo.models.Datos;
import com.example.peliculasequipo.models.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceClient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/popular")
    Call<Datos> getPeliculasP();
}
