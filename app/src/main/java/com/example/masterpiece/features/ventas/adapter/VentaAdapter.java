package com.example.masterpiece.features.ventas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.adapter.ClienteAdapter;
import com.example.masterpiece.features.ventas.entities.Venta;

import java.util.ArrayList;
import java.util.List;

public class VentaAdapter  extends RecyclerView.Adapter<VentaAdapter.ViewHolder>{

    List<Venta> ventas = new ArrayList<>();

    public VentaAdapter(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @NonNull
    @Override
    public VentaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.venta_card_layout,null,false);

        return new VentaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VentaAdapter.ViewHolder holder, int position) {
        Venta venta = ventas.get(position);
        holder.nombreUsuarioTextView.setText(venta.getNombreUsuario());
        holder.nombreProductoTextView.setText(venta.getNombreProducto());
        holder.cantidadTextView.setText(String.valueOf(venta.getCantidad()));
        holder.totalTextView.setText(venta.getTotal().toString());
    }

    @Override
    public int getItemCount() {
        return ventas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreUsuarioTextView;
        TextView nombreProductoTextView;
        TextView cantidadTextView;
        TextView totalTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreUsuarioTextView = itemView.findViewById(R.id.tituloNombreUsuario);
            nombreProductoTextView = itemView.findViewById(R.id.tituloNombreProducto);
            cantidadTextView = itemView.findViewById(R.id.tituloCantidad);
            totalTextView = itemView.findViewById(R.id.tituloTotal);
        }
    }
}
