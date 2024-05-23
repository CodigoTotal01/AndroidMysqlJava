package com.example.masterpiece.features.productos.pages;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.masterpiece.R;
import com.example.masterpiece.features.productos.adapter.ProductoAdapter;
import com.example.masterpiece.features.productos.daos.ProductoDAO;
import com.example.masterpiece.features.productos.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProductosActivity extends AppCompatActivity {

    List<Producto> productos = new ArrayList<>();

    ProductoDAO dao = new ProductoDAO();

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_catalogo_productos);


        // Inicializar y configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Cargar la lista de artistas
        productos = dao.list();

        ProductoAdapter productosAdapter = new ProductoAdapter(this, productos);
        recyclerView.setAdapter(productosAdapter);
    }
}