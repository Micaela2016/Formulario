package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    TextView tvNombre, tvTelefono, tvEmail, tvDescripcion,tvFecha;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        tvNombre= (TextView) findViewById(R.id.tvNombre);
        tvTelefono= (TextView) findViewById(R.id.tvTelefono);
        tvFecha= (TextView) findViewById(R.id.tvFecha);
        tvEmail= (TextView) findViewById(R.id.tvEmail);
        tvDescripcion= (TextView) findViewById(R.id.tvDescripcion);

        agregarBoton();
        Bundle extras = this.getIntent().getExtras();
        if (extras != null){
            String nombre = extras.getString("Nombre");
            String telefono = extras.getString("Telefono");
            String email = extras.getString("Email");
            String descripcion = extras.getString("Descripcion");
            String fecha = extras.getString("Fecha");

            tvNombre.setText(nombre);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
            tvFecha.setText(fecha);
        }
    }

    public void agregarBoton() {
        Button botonEditar= (Button) findViewById(R.id.btnEditarDatos);
        botonEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent (MostrarDatos.this, MainActivity.class);
                i.putExtra("Nombre",tvNombre.getText().toString());
                i.putExtra("Telefono",tvTelefono.getText().toString());
                i.putExtra("Email",tvEmail.getText().toString());
                i.putExtra("Descripcion",tvDescripcion.getText().toString());
                i.putExtra("Fecha",tvFecha.getText().toString());
                startActivity(i);

            }
        });
    }
}