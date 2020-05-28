package com.example.peliculasequipo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.peliculasequipo.models.AdapterPelicula;
import com.example.peliculasequipo.models.Datos;
import com.example.peliculasequipo.models.Pelicula;
import com.example.peliculasequipo.webservice.WebServiceClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;

    private List<Pelicula> peliculaList;
    private RecyclerView recycler;
    private AdapterPelicula adapter;

    private CardView primerBoton;
    private CardView segunBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primerBoton = findViewById(R.id.primerBoton);
        segunBoton = findViewById(R.id.segunBoton);

        lanzarPeticion();
        setupView();



    primerBoton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, EstrenosActivity.class);
            startActivity(i);
        }
    });

    segunBoton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i2 = new Intent(MainActivity.this, ProximamenteActivity.class);
            startActivity(i2);
        }
    });




    }

    private void lanzarPeticion(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        WebServiceClient client = retrofit.create(WebServiceClient.class);

        Call<Datos> peticion = client.getPeliculasP(WebServiceClient.token, "es-ES");
        peticion.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {
                Datos misDatos = response.body();
                List<Pelicula> lista = misDatos.getResults();
                adapter.setLista(lista);
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }

    private void setupView (){
        recycler = findViewById(R.id.recycler);
        peliculaList = new ArrayList<>();
        adapter = new AdapterPelicula(peliculaList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }
}
