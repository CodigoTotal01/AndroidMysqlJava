package com.example.masterpiece.features.store.pages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.masterpiece.R;
import com.example.masterpiece.features.auth.daos.UsuarioDAO;
import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.features.ventas.daos.VentaDAO;
import com.example.masterpiece.features.ventas.entities.Venta;

import java.math.BigDecimal;

public class PasarelaDePagoActivity extends AppCompatActivity {


    VentaDAO ventaDAO = new VentaDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    private TextView nombreProductoPagar;
    private TextView tipoProductoPagar;
    private TextView precioProductoPagar;

    private Button btnComprarPagar;

    private String clienteTemporalId = "1";


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

        String idProducto = getIntent().getStringExtra("idProducto");

        // Poblar las vistas con los datos del producto
        nombreProductoPagar.setText(nombre);
        tipoProductoPagar.setText(tipo);
        precioProductoPagar.setText(precio);

        Venta venta = new Venta.Builder().idProducto(Integer.parseInt(idProducto)).idUsuario(Integer.parseInt(clienteTemporalId)).cantidad(1).total(BigDecimal.valueOf(Double.parseDouble(precio))).build();

        btnComprarPagar.setOnClickListener(v -> {
            Boolean ventaRealizada = ventaDAO.insert(venta);
            if (ventaRealizada) {
                Intent intent = new Intent(this, PatantallaAgradecimientoActivity.class);
                startActivity(intent);
            }
        });

    }
}