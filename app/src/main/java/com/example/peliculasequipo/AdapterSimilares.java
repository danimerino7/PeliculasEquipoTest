package com.example.peliculasequipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.models.Results;
import com.example.peliculasequipo.models.Similares;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterSimilares extends RecyclerView.Adapter<AdapterSimilares.SimilaresHolder> {


    private Context context;
    private List<Results> listaResults;
    private Similares similares;

    public AdapterSimilares(Context context) {
        listaResults = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public SimilaresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.similares_item, parent, false);
        return new SimilaresHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilaresHolder holder, int position) {

       Results results = listaResults.get(position);
       holder.tituloSimilar.setText(results.getOriginal_title());
       holder.fechaSimilar.setText(results.getRelease_date());
       holder.valSimilar.setText(String.valueOf(results.getPopularity()));
       Picasso.get().load("https://image.tmdb.org/t/p/w500/"+results.getPoster_path()).into(holder.imagenSimilar);
       if(results.isAdult()){
           holder.adultSimilar.setVisibility(View.VISIBLE);
       }else{
           holder.adultSimilar.setVisibility(View.GONE);
       }

    }

    @Override
    public int getItemCount() {
        return listaResults.size();
    }

    public  void setSimilares(List<Results> results){
        this.listaResults = results;
        notifyDataSetChanged();
    }

    static class SimilaresHolder extends RecyclerView.ViewHolder{

        private ImageView imagenSimilar, adultSimilar;
        private TextView tituloSimilar, fechaSimilar, valSimilar;

        public SimilaresHolder(@NonNull View itemView) {
            super(itemView);

            imagenSimilar = itemView.findViewById(R.id.imagenSimilar);
            adultSimilar = itemView.findViewById(R.id.adultSimilar);
            tituloSimilar = itemView.findViewById(R.id.tituloSimilar);
            fechaSimilar = itemView.findViewById(R.id.fechaSimilar);
            valSimilar = itemView.findViewById(R.id.valSimilar);
        }
    }
}
