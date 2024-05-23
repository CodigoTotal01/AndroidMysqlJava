package com.example.masterpiece.features.ventas.pages;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.ventas.adapter.VentaAdapter;
import com.example.masterpiece.features.ventas.daos.VentaDAO;
import com.example.masterpiece.features.ventas.entities.Venta;

import java.util.ArrayList;
import java.util.List;

public class ReporteVentasActivity extends AppCompatActivity {


    List<Venta> ventas = new ArrayList<>();

    VentaDAO dao = new VentaDAO();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        VentaDAO ventaDAO = new VentaDAO();

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reporte_ventas);


        // Inicializar y configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerVentas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        ventas = dao.list();

        VentaAdapter ventasAdapter = new VentaAdapter(ventas);
        recyclerView.setAdapter(ventasAdapter);

    }
}