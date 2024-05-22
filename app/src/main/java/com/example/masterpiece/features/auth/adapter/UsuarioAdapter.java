package com.example.masterpiece.features.auth.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.auth.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_layout,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.ViewHolder holder, int position) {
        holder.id_usuario.setText(usuarios.get(position).getId().toString());
        holder.nombre_usuario.setText(usuarios.get(position).getUsuario());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView  id_usuario;
        private TextView nombre_usuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_usuario = itemView.findViewById(R.id.id_usuario);
            nombre_usuario = itemView.findViewById(R.id.nombre_usuario);
        }
    }
}