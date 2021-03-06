package com.example.peliculasequipo.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.EstrenosActivity;
import com.example.peliculasequipo.MainActivity;
import com.example.peliculasequipo.R;
import com.example.peliculasequipo.SimilaresActivity;
import com.squareup.picasso.Picasso;

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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist3, parent, false);
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
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+pelicula.getPoster_path()).into(holder.imgCabecera);
        
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(context, SimilaresActivity.class);


            }
        });

        holder.peliculasSimilares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SimilaresActivity.class);
                i.putExtra("similares", pelicula.getId());
                context.startActivity(i);
            }
        });

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
        CardView cardView;
        Button peliculasSimilares;

        public PeliculaHolder(@NonNull View v) {
            super(v);
            imgCabecera = v.findViewById(R.id.imgCabecera);
            titleTV = v.findViewById(R.id.titleTV);
            voteTV = v.findViewById(R.id.voteTV);
            sinopsisTV = v.findViewById(R.id.sinopsisTV);
            dateTV = v.findViewById(R.id.dateTV);
            cardView = v.findViewById(R.id.cardview);
            peliculasSimilares = v.findViewById(R.id.similaresBoton);



        }
    }
}
