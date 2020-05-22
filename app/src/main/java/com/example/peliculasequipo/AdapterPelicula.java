package com.example.peliculasequipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.models.Pelicula;

import java.util.List;

public class AdapterPelicula extends RecyclerView.Adapter<AdapterPelicula.PeliculaHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    public AdapterPelicula(List<Pelicula> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPelicula.PeliculaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        PeliculaHolder holder = new PeliculaHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPelicula.PeliculaHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titleTV.setText(pelicula.getTitle());
        holder.voteTV.setText(pelicula.getVote_average());
        holder.sinopsisTV.setText(pelicula.getOverview());
        holder.dateTV.setText(pelicula.getRelease_date());
        //Picasso()
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public void setLista(List<Pelicula> lista){
        this.peliculas = lista;
        notifyDataSetChanged();

    }

    static class PeliculaHolder extends RecyclerView.ViewHolder {

        ImageView imgCabecera;
        TextView titleTV, voteTV, sinopsisTV, dateTV;

        public PeliculaHolder(@NonNull View v) {
            super(v);
            imgCabecera = v.findViewById(R.id.imgCabecera);
            titleTV = v.findViewById(R.id.titleTV);
            voteTV = v.findViewById(R.id.voteTV);
            sinopsisTV = v.findViewById(R.id.sinopsisTV);
            dateTV = v.findViewById(R.id.dateTV);
        }
    }
}
