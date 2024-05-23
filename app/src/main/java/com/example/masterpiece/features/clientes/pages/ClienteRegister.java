package com.example.masterpiece.features.clientes.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.masterpiece.R;
import com.example.masterpiece.features.clientes.daos.ClienteDAO;
import com.example.masterpiece.features.clientes.entities.Cliente;
import com.example.masterpiece.features.productos.pages.CatalogoProductosActivity;


public class ClienteRegister extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCorreo;
    private EditText etTelefono;
    private Button btnComienzaExplorar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cliente_register);

        etNombre = findViewById(R.id.etNombreCliente);
        etCorreo = findViewById(R.id.etCorreoCliente);
        etTelefono = findViewById(R.id.etTelefonoCliente);
        btnComienzaExplorar = findViewById(R.id.btnComienzaExplorarProductos);

        btnComienzaExplorar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String correo = etCorreo.getText().toString();
                String telefono = etTelefono.getText().toString();

                Cliente cliente = new Cliente.Builder()
                        .nombre(nombre)
                        .correo(correo)
                        .telefono(telefono)
                        .build();

                ClienteDAO clienteDAO = new ClienteDAO();
                if (clienteDAO.insert(cliente)) {
                    Toast.makeText(ClienteRegister.this, "Cliente registrado correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ClienteRegister.this, CatalogoProductosActivity.class);
                    clienteDAO.findByNombre(nombre).getId();
                    intent.putExtra("idCliente", clienteDAO.findByNombre(nombre).getId());
                    startActivity(intent);
                } else {
                    Toast.makeText(ClienteRegister.this, "Error al registrar cliente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}