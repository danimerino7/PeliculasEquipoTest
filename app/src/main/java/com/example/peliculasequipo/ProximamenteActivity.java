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
import com.example.peliculasequipo.models2.AdapterProximamente;
import com.example.peliculasequipo.models2.Datos2;
import com.example.peliculasequipo.models2.Proximo;
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

public class ProximamenteActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClientBuilder;
    private List<Proximo> proximamenteList;
    private RecyclerView recycler;
    private AdapterProximamente adapter;
    private TextView back;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proximamente_layout);


        Toast.makeText(ProximamenteActivity.this, "Haz click sobre la imagen para saber fecha de estreno", Toast.LENGTH_SHORT).show();
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        lanzarPeticionEstreno();
        setupViewEstreno();
    }


    private void lanzarPeticionEstreno(){
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        WebServiceClient client = retrofit.create(WebServiceClient.class);
        // es-ES&page=
        Call<Datos2> peticionEstrenos = client.getEstrenos(WebServiceClient.token);
        peticionEstrenos.enqueue(new Callback<Datos2>() {
            @Override
            public void onResponse(Call<Datos2> call, Response<Datos2> response) {
                Datos2 datosEstreno = response.body();
                List<Proximo> list = datosEstreno.getResultados();
               adapter.setListado(list);

            }

            @Override
            public void onFailure(Call<Datos2> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });

    }

    private void setupViewEstreno (){
        recycler = findViewById(R.id.recycler);
        proximamenteList = new ArrayList<>();
        adapter = new AdapterProximamente(proximamenteList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

}
