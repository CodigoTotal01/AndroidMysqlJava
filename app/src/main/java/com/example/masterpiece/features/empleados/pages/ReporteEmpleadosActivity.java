package com.example.masterpiece.features.empleados.pages;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.daos.ClienteDAO;
import com.example.masterpiece.features.clientes.entities.Cliente;
import com.example.masterpiece.features.empleados.adapter.EmpleadoAdapter;
import com.example.masterpiece.features.empleados.daos.EmpleadoDAO;
import com.example.masterpiece.features.empleados.entities.Empleado;

import java.util.ArrayList;
import java.util.List;

public class ReporteEmpleadosActivity extends AppCompatActivity {


    List<Empleado> empleados = new ArrayList<>();
    EmpleadoDAO dao = new EmpleadoDAO();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reporte_empleados);

        // Inicializar y configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerEmpleados);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        empleados = dao.list();

        EmpleadoAdapter empleadosAdapter = new EmpleadoAdapter(empleados);
        recyclerView.setAdapter(empleadosAdapter);

    }
}