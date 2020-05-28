package com.example.peliculasequipo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.modelosEstreno.AdapterEstrenos;
import com.example.peliculasequipo.modelosEstreno.Estreno;
import com.example.peliculasequipo.modelosEstreno.Releasesdates;
import com.example.peliculasequipo.modelosEstreno.Results;
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


public class EstrenosActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    private List<Pelicula> peliculaList;
    private TextView back;
    private RecyclerView recyclerView;
    private AdapterEstrenos adapter;

    //no se si necesito esto
    private List<Estreno> estrenoList;
    private Results results;
    private Releasesdates releasesdates;
    /////

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estrenos_layout);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Toast.makeText(this, "Bienvenido a estrenos, haz click sobre cada película para conocer su estreno", Toast.LENGTH_LONG).show();

        lanzarEstrenos();
        setupEstrenos();

    }

    private void lanzarEstrenos(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        WebServiceClient client = retrofit.create(WebServiceClient.class);


        //llamada para estrenos id y token recibe la llamada
        /*
        Pelicula pelicula;
       Call<Estreno> estrenos = client.getReleasesDates(pelicula.getId(),WebServiceClient.token);
       estrenos.enqueue(new Callback<Estreno>() {
           @Override
           public void onResponse(Call<Estreno> call, Response<Estreno> response) {
               Releasesdates lanzamientos = response.body();
               List<Estreno> = lanzamientos.getRelease_date();
               adapter.setPeliculaList(lanzamientos);
           }

           @Override
           public void onFailure(Call<Estreno> call, Throwable t) {

           }
       });
            */
       /////////////////////////////////////////////////


        Call<Datos> peticion = client.getPeliculasP(WebServiceClient.token, "es-ES");
        peticion.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {

                Datos misDatos = response.body();
                List<Pelicula> lista = misDatos.getResults();
                adapter.setPeliculaList(lista);
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });
    }

    private void setupEstrenos(){
        //configuracion recyclerview
        recyclerView = findViewById(R.id.recycler);
        peliculaList = new ArrayList<>();
        GridLayoutManager manager2 = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager2);
        adapter = new AdapterEstrenos(this);
        recyclerView.setAdapter(adapter);
    }



}
