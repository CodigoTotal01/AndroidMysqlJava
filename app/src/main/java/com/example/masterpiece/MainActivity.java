package com.example.masterpiece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterpiece.features.auth.adapter.UsuarioAdapter;
import com.example.masterpiece.features.auth.daos.UsuarioDAO;
import com.example.masterpiece.features.auth.entities.Usuario;
import com.example.masterpiece.features.store.pages.TokenActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //variables
    private Button btnLogin1;
    private EditText edtUsuario1;
    private EditText edtPassword;

    private Button btnRegister;



    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnLogin1 = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        edtUsuario1=findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtClave);


        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUsuario1.getText().toString();
                String password = edtPassword.getText().toString();

                // Validar usuario y contraseña
                if (usuario.equalsIgnoreCase("admin") && password.equals("admin")) {
                    // Generar token de 6 dígitos
                    String token = generateToken();
                    Intent intent = new Intent(getApplicationContext(), TokenActivity.class);
                    intent.putExtra("token", generateToken());
                    intent.putExtra("nombre", usuario);

                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // Método para generar token de 6 dígitos
    private String generateToken() {
        Random random = new Random();
        StringBuilder tokenBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            tokenBuilder.append(random.nextInt(10)); // Generar un dígito aleatorio del 0 al 9
        }
        return tokenBuilder.toString();
    }
}


