package com.example.masterpiece.model.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.masterpiece.R;
import com.example.masterpiece.model.entities.Artista;

import java.util.ArrayList;
import java.util.List;

public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.ViewHolder> {

    private Context mCtx;
    private List<Artista> artistas;

    public ArtistaAdapter(Context context, List<Artista> artistas) {
        this.mCtx = context;
        this.artistas = artistas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Artista artista = artistas.get(position);
        holder.vhNombre.setText(artista.getNombre());
        holder.vhGenero.setText(artista.getGenero());
        Glide.with(mCtx).load(artista.getImagen()).into(holder.vhImagen);
    }

    @Override
    public int getItemCount() {
        return artistas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView vhNombre;
        private TextView vhGenero;
        private ImageView vhImagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vhNombre = itemView.findViewById(R.id.nombre);
            vhGenero = itemView.findViewById(R.id.genero);
            vhImagen = itemView.findViewById(R.id.imagen);
        }
    }
}