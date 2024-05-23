package com.example.masterpiece.features.store.pages;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.masterpiece.R;

public class PasarelaDePagoActivity extends AppCompatActivity {

    private TextView nombreProductoPagar;
    private TextView tipoProductoPagar;
    private TextView precioProductoPagar;

    private Button btnComprarPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pasarela_de_pago);

        // Inicializar las vistas
        nombreProductoPagar = findViewById(R.id.nombre_producto);
        tipoProductoPagar = findViewById(R.id.tipo_producto);
        precioProductoPagar = findViewById(R.id.precio_producto);
        btnComprarPagar = findViewById(R.id.btnPagar);

        // Recuperar los datos del producto
        String nombre = getIntent().getStringExtra("nombreProducto");
        String tipo = getIntent().getStringExtra("tipoProducto");
        String precio = getIntent().getStringExtra("precioProducto");

        // Poblar las vistas con los datos del producto
        nombreProductoPagar.setText(nombre);
        tipoProductoPagar.setText(tipo);
        precioProductoPagar.setText(precio);

    }
}