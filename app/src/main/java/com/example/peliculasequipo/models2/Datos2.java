package com.example.peliculasequipo.models2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datos2 {
    @SerializedName("results")
    private List<Proximo> resultados;

    public List<Proximo> getResultados() {
        return resultados;
    }

    public void setResults(List<Proximo> resultados) {
        this.resultados = resultados;
    }



}
