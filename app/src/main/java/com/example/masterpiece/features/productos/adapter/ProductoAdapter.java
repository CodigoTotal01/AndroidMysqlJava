package com.example.masterpiece.features.productos.adapter;

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
import com.example.masterpiece.features.productos.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private Context mCtx;
    private List<Producto> productos;

    public ProductoAdapter(Context mCtx, List<Producto> productos) {
        this.mCtx = mCtx;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.nombreProducto.setText(producto.getNombre());
        holder.tipoProducto.setText(producto.getTipo());
        holder.precioProducto.setText(producto.getPrecio().toString());
        Glide.with(mCtx)
                .load(producto.getUrlImagen())
                .into(holder.imgProducto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProducto;
        private TextView nombreProducto;
        private TextView tipoProducto;
        private TextView precioProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProducto = itemView.findViewById(R.id.imagen_producto);
            nombreProducto = itemView.findViewById(R.id.nombre_producto);
            tipoProducto = itemView.findViewById(R.id.tipo_producto);
            precioProducto = itemView.findViewById(R.id.precio_producto);

        }
    }
}
