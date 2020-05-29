package com.example.peliculasequipo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.models.Results;
import com.example.peliculasequipo.models.Similares;
import com.example.peliculasequipo.webservice.WebServiceClient;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SimilaresActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClient;
    private RecyclerView recyclerView;
    private AdapterSimilares adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.similar_layout);

        lanzarSimilares();
        setupSimilares();

    }

    private void lanzarSimilares(){

        int id = 0;
        Bundle b = getIntent().getExtras();
        if(b != null && b.containsKey("similares")){
            id = b.getInt("similares");
        }

        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        WebServiceClient client = retrofit.create(WebServiceClient.class);

        Call<Similares> llamada = client.getSimilar(id, WebServiceClient.token);
        llamada.enqueue(new Callback<Similares>() {
            @Override
            public void onResponse(Call<Similares> call, Response<Similares> response) {
                Similares similares = response.body();
                List<Results> listaResults = similares.getResults();
                adapter.setSimilares(listaResults);

            }

            @Override
            public void onFailure(Call<Similares> call, Throwable t) {
                Log.d("RETROFIT", "Error" + t.getMessage());
            }
        });
    }

    private void setupSimilares(){
        recyclerView = findViewById(R.id.recyclerSim);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        adapter = new AdapterSimilares(this);
        recyclerView.setAdapter(adapter);
    }
}
