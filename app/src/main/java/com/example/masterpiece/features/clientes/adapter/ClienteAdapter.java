package com.example.masterpiece.features.clientes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.features.clientes.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ViewHolder> {
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteAdapter(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @NonNull
    @Override
    public ClienteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cliente_card_layout,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdapter.ViewHolder holder, int position) {
        Cliente cliente = clientes.get(position);
        holder.nombreTextView.setText(cliente.getNombre());
        holder.correoTextView.setText(cliente.getCorreo());
        holder.telefonoTextView.setText(cliente.getTelefono());
    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreTextView;
        private TextView correoTextView;
        private TextView telefonoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.tituloNombre);
            correoTextView = itemView.findViewById(R.id.tituloCorreo);
            telefonoTextView = itemView.findViewById(R.id.tituloTelefono);
        }
    }
}