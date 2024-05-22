package com.example.masterpiece.features.store.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masterpiece.R;

public class TokenActivity extends AppCompatActivity {
    private TextView txtTokenData;
    private EditText txtTokenAccess;
    private Button btnLoginToken;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);


        // Obtener referencia al EditText y al Button
        txtTokenAccess = findViewById(R.id.txtTokenAccess);
        btnLoginToken = findViewById(R.id.btnLoginToken);
        txtTokenData =  findViewById(R.id.txtTokenData);

        // Obtener el token pasado desde la actividad anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            token = extras.getString("token");
        }
        txtTokenData.setText("Token: " + token);


        // Configurar el listener para el botón de login
        btnLoginToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto ingresado en el EditText
                String enteredToken = txtTokenAccess.getText().toString();

                // Comparar el token ingresado con el token recibido
                if (enteredToken.equals(token)) {
                    // Token correcto, iniciar la actividad "ReportesMainActivity"
                    Intent intent = new Intent(TokenActivity.this, CatalogoProductoActivity.class);
                    startActivity(intent);
                    finish(); // Finalizar esta actividad para evitar volver atrás
                } else {
                    // Token incorrecto, mostrar un mensaje de error
                    Toast.makeText(TokenActivity.this, "Token incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}