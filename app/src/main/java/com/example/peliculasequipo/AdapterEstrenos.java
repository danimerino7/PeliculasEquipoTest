package com.example.peliculasequipo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.peliculasequipo.models.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class AdapterEstrenos extends RecyclerView.Adapter<AdapterEstrenos.EstrenoHolder> {

    private List<Pelicula> peliculaList;
    private Context context;

    public AdapterEstrenos(Context context) {
        peliculaList = new ArrayList<>();
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
        holder.imagen.setImageResource(pelicula.getId());
        holder.titulo.setText(pelicula.getTitle());
        holder.fecha.setText(String.valueOf(pelicula.getRelease_date()));
    }

    @Override
    public int getItemCount() { return peliculaList.size(); }

    static class EstrenoHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView fecha;
        private TextView titulo;
        private ConstraintLayout layout;

        public EstrenoHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.constraitlayout);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha_estreno);
            imagen = itemView.findViewById(R.id.portada);
        }
    }

}
