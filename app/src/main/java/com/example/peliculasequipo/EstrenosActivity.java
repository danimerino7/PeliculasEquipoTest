package com.example.peliculasequipo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class EstrenosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterEstrenos adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estrenos_layout);

        Toast.makeText(this, "Bienvenido a la sección de estrenos, desliza para ver las novedades", Toast.LENGTH_SHORT).show();

        //configuracion recyclerview
        recyclerView = findViewById(R.id.recycler);
        GridLayoutManager manager2 = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager2);
        adapter = new AdapterEstrenos(this);
        recyclerView.setAdapter(adapter);

    }

    private void LanzarEstrenos(){

    }

    private void SetupEstrenos(){

    }



}
