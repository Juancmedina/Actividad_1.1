package com.example.actividad_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText usuario, clave;
    private Button inicio, registrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.editTextEmail);
        clave = findViewById(R.id.editTextPassword);
        inicio = findViewById(R.id.buttonLogin);
        registrar = findViewById(R.id.buttonRegister);
    }
    public void Validar(View view){
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();
        if (user.isEmpty()){
            usuario.setError("usuario vacio");
            usuario.requestFocus();
        } else if (pass.isEmpty()) {
            clave.setError("Clave vacia");
            clave.requestFocus();
        } else if (user.equals("iud2023") && pass.equals("moviles")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(),"Usuario o clave incorrecto",Toast.LENGTH_SHORT).show();
        }
    }

    public void Registrar(View view){

    }
}
