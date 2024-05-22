package com.example.masterpiece.features.auth.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.masterpiece.R;
import com.example.masterpiece.features.auth.daos.UsuarioDAO;
import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.features.clientes.pages.ClienteRegister;

public class RegisterActivity extends AppCompatActivity {

    private EditText editUsuarioRegister;
    private EditText editPasswordRegister;
    private Button btnSalirRegisterUsuario;
    private Button btnContinuarRegisterCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editUsuarioRegister = findViewById(R.id.editUsuarioRegister);
        editPasswordRegister = findViewById(R.id.editPasswordRegister);
        btnSalirRegisterUsuario = findViewById(R.id.btnSalirRegisterUsuario);
        btnContinuarRegisterCliente = findViewById(R.id.btnContinuarRegisterCliente);
        btnSalirRegisterUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnContinuarRegisterCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioString = editUsuarioRegister.getText().toString();
                String password = editPasswordRegister.getText().toString();

                Usuario usuario = new Usuario.Builder()
                        .usuario(usuarioString)
                        .password(password)
                        .build();
                // Buscar usuario por nombre de usuario
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.insert(usuario);

                if (usuarioDAO.insert(usuario)) {
                    Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                    // Aquí puedes realizar las acciones necesarias al presionar el botón "Continuar"
                    // Por ejemplo, puedes redirigir a la siguiente actividad
                    Intent intent = new Intent(RegisterActivity.this, ClienteRegister.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}