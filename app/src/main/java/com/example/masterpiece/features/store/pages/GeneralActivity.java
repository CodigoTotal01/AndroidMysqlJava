package com.example.masterpiece.features.store.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.pages.ClienteCatalogoActivity;
import com.example.masterpiece.features.empleados.pages.ReporteEmpleadosActivity;
import com.example.masterpiece.features.productos.pages.CatalogoProductosActivity;
import com.example.masterpiece.features.ventas.pages.CatalogoVentaProductosActivity;
import com.example.masterpiece.features.ventas.pages.ReporteVentasActivity;

public class GeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_general);

        Button btnCatalogoProductos = findViewById(R.id.btnCatalogoProductos);
        Button btnCatalogoVentaProductos = findViewById(R.id.btnCatalogoVentaProductos);
        Button btnReporteVentas = findViewById(R.id.btnReporteVentas);
        Button btnReporteClientes = findViewById(R.id.btnReporteClientes);
        Button btnReporteEmpleados = findViewById(R.id.btnReporteEmpleados);

        btnCatalogoProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneralActivity.this, CatalogoProductosActivity.class);
                startActivity(intent);
            }
        });

        btnCatalogoVentaProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneralActivity.this, CatalogoVentaProductosActivity.class);
                startActivity(intent);
            }
        });

        btnReporteVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneralActivity.this, ReporteVentasActivity.class);
                startActivity(intent);
            }
        });

        btnReporteClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneralActivity.this, ClienteCatalogoActivity.class);
                startActivity(intent);
            }
        });

        btnReporteEmpleados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GeneralActivity.this, ReporteEmpleadosActivity.class);
                startActivity(intent);
            }
        });
    }
}