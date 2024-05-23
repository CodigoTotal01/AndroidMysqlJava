package com.example.masterpiece.features.productos.pages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.masterpiece.R;
import com.example.masterpiece.features.productos.daos.ProductoDAO;
import com.example.masterpiece.features.productos.entities.Producto;
import com.example.masterpiece.features.store.pages.PasarelaDePagoActivity;

public class DetalleProductoActivity extends AppCompatActivity {
    private Producto producto;
    private ImageView imgProducto;
    private TextView nombreProducto;
    private TextView tipoProducto;
    private TextView precioProducto;
    private Button btnComprar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_producto);
        String nombreProductoObtenido = getIntent().getStringExtra("nombreProducto");
        // Inicializar las vistas
        imgProducto = findViewById(R.id.imagen_producto);
        tipoProducto = findViewById(R.id.tipo_producto);
        precioProducto = findViewById(R.id.precio_producto);
        btnComprar = findViewById(R.id.btnComprar);
        nombreProducto = findViewById(R.id.nombre_producto);
        btnComprar = findViewById(R.id.btnComprar);


        ProductoDAO productoDAO = new ProductoDAO();

        producto = productoDAO.findByNombre(nombreProductoObtenido);

        Glide.with(this)
                .load(producto.getUrlImagen())
                .into(imgProducto);
        this.nombreProducto.setText(producto.getNombre());
        this.tipoProducto.setText(producto.getTipo());
        this.precioProducto.setText(producto.getPrecio().toString());

        btnComprar.setOnClickListener(v -> {
            Intent intent = new Intent(this, PasarelaDePagoActivity.class);
            intent.putExtra("nombreProducto", producto.getNombre());
            intent.putExtra("tipoProducto", producto.getTipo());
            intent.putExtra("precioProducto", producto.getPrecio().toString());
            intent.putExtra("idProducto", Integer.toString(producto.getId())); // Añade esta línea


            startActivity(intent);
        });

    }
}