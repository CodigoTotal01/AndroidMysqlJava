package com.example.masterpiece;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.features.auth.adapter.UsuarioAdapter;
import com.example.masterpiece.features.auth.daos.UsuarioDAO;
import com.example.masterpiece.features.auth.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Usuario> usuarios = new ArrayList<>();
    UsuarioDAO dao = new UsuarioDAO();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar y configurar RecyclerView
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Cargar la lista de artistas
        usuarios = dao.list();

        // Configurar el adaptador y asignarlo al RecyclerView
        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios);
        recyclerView.setAdapter(usuarioAdapter);
    }
}


