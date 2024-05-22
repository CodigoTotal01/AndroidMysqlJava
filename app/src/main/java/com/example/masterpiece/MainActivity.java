package com.example.masterpiece;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masterpiece.model.adapter.ArtistaAdapter;
import com.example.masterpiece.model.connectiondb.ConnectionDB;
import com.example.masterpiece.model.daos.ArtistaDao;
import com.example.masterpiece.model.entities.Artista;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Artista> artistas = new ArrayList<>();
    ArtistaDao dao = new ArtistaDao();
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
        artistas = dao.list();

        // Configurar el adaptador y asignarlo al RecyclerView
        ArtistaAdapter artistaAdapter = new ArtistaAdapter(this, artistas);
        recyclerView.setAdapter(artistaAdapter);
    }
}


