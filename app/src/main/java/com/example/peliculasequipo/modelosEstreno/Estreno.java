package com.example.peliculasequipo.modelosEstreno;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Estreno   {

    @SerializedName("id")
    private int id;

    @SerializedName("results")
    private List<Results> results;

    public Estreno(int id, List<Results> results) {
        this.id = id;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
