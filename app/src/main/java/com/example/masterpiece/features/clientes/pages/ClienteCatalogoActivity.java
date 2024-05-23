package com.example.masterpiece.features.clientes.pages;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.adapter.ClienteAdapter;
import com.example.masterpiece.features.clientes.daos.ClienteDAO;
import com.example.masterpiece.features.clientes.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteCatalogoActivity extends AppCompatActivity {
    List<Cliente> clientes = new ArrayList<>();
    ClienteDAO dao = new ClienteDAO();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cliente_catalogo);


        // Inicializar y configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerClientes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        // Cargar la lista de artistas
        clientes = dao.list();

        ClienteAdapter clientesAdapter = new ClienteAdapter(clientes);
        recyclerView.setAdapter(clientesAdapter);

    }
}