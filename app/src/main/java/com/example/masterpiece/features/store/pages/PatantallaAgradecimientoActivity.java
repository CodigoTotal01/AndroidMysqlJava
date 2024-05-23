package com.example.masterpiece.features.store.pages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.masterpiece.R;
import com.example.masterpiece.features.productos.pages.CatalogoProductosActivity;

public class PatantallaAgradecimientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_patantalla_agradecimiento);

        Button btnCatalogo = findViewById(R.id.btnCatalogo);
        btnCatalogo.setOnClickListener(v -> {
            Intent intent = new Intent(this, CatalogoProductosActivity.class);
            startActivity(intent);
        });
    }
}