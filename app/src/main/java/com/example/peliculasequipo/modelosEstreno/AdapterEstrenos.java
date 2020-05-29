package com.example.peliculasequipo.modelosEstreno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peliculasequipo.R;
import com.example.peliculasequipo.models.Pelicula;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AdapterEstrenos extends RecyclerView.Adapter<AdapterEstrenos.EstrenoHolder> {
    private List<Releasesdates> releasesdatesList;
    private List<Pelicula> peliculaList;
    private Context context;

    public AdapterEstrenos(Context context) {
        peliculaList = new ArrayList<>();
        releasesdatesList = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterEstrenos.EstrenoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.estreno_item,parent, false);
        return new EstrenoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEstrenos.EstrenoHolder holder, int position) {
        final Pelicula pelicula = peliculaList.get(position);
//        Releasesdates releasesdates = releasesdatesList.get(position);

        holder.titulo.setText(pelicula.getTitle());
        holder.fecha.setText(String.valueOf(pelicula.getRelease_date()));
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+pelicula.getPoster_path()).into(holder.imagen);

        holder.usa.setText("21-07-2022");
        holder.japan.setText("3-11-2021");


      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Toast.makeText(context, "Disponible a partir del " +pelicula.getRelease_date(), Toast.LENGTH_SHORT).show();
          }
      });

    }

    @Override
    public int getItemCount() { return peliculaList.size(); }

    public void setPeliculaList(List<Pelicula> lista){
        this.peliculaList = lista;
        notifyDataSetChanged();

    }

    static class EstrenoHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView fecha;
        private TextView titulo;
        private ConstraintLayout layout;

        //lanzamientos
        private TextView usa;
        private TextView japan;

        public EstrenoHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.constraitlayout);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha_estreno);
            imagen = itemView.findViewById(R.id.portada);

            usa = itemView.findViewById(R.id.eeuu);
            japan = itemView.findViewById(R.id.japon);


            
        }
    }



}
