package com.example.actividad_1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText nombre, usuario, clave;
    private Button registrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.editTextName);
        usuario = findViewById(R.id.editTextEmail);
        clave = findViewById(R.id.editTextPassword);
        registrar = findViewById(R.id.buttonRegister);
    }

    public void Registrar(View view){
        AdminSQLite admin = new AdminSQLite(this);
        SQLiteDatabase db = admin.getWritableDatabase();

        String user = usuario.getText().toString();
        String userr = nombre.getText().toString();
        String pass = clave.getText().toString();
        if (user.isEmpty()){
            usuario.setError("correo vacio");
            usuario.requestFocus();
        } else if (userr.isEmpty()) {
            nombre.setError("Nombre vacio");
            nombre.requestFocus();
        } else if (pass.isEmpty()) {
            clave.setError("Clave vacia");
            clave.requestFocus();
        }else {
            ContentValues datos  = new ContentValues();
            datos.put("Nombre",userr);
            datos.put("User",user);
            datos.put("Clave",pass);
            db.insert(AdminSQLite.TABLE_NAME,null,datos);
        }
    }
}

