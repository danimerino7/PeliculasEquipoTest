package com.example.peliculasequipo.models2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.R;
import com.example.peliculasequipo.models.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProximamente extends RecyclerView.Adapter<AdapterProximamente.ProximamenteHolder> {

    private List<Proximo> proximos;
    private Context context;

    public AdapterProximamente(List<Proximo> proximos, Context context) {
        this.proximos = proximos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterProximamente.ProximamenteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproximamente, parent, false);
        ProximamenteHolder holder = new ProximamenteHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProximamente.ProximamenteHolder holder, int position) {

        Proximo proximo = proximos.get(position);
        holder.titulopeli.setText(proximo.getTitle());

        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+proximo.getPoster_path()).into(holder.portada);
        holder.portada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+proximo.getRelease_date(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return proximos.size();
    }

    public void setListado(List<Proximo> listado){
        this.proximos = listado;
        notifyDataSetChanged();

    }


    static class ProximamenteHolder extends RecyclerView.ViewHolder {

        //delcarar elementos list
        ImageView portada;
        TextView titulopeli;

        LinearLayout layout;

        public ProximamenteHolder(@NonNull View v) {
            super(v);

            //aociar ids aesos
            portada = v.findViewById(R.id.portadapeli);
            titulopeli = v.findViewById(R.id.titulopeli);

            layout = v.findViewById(R.id.layoutitem);


        }
    }
}
