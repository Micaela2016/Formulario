package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre,inputFecha,etTelefono,etEmail, etDescripcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFecha= (EditText) findViewById(R.id.etFecha);
        etNombre= (EditText) findViewById(R.id.etNombre);
        etTelefono= (EditText) findViewById(R.id.etTelefono);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etDescripcion= (EditText) findViewById(R.id.etDescripcion);
        inputFecha.setOnClickListener(this);
        agregarBoton();

        Bundle extras = this.getIntent().getExtras();
        if (extras != null){
            String nombre = extras.getString("Nombre");
            String telefono = extras.getString("Telefono");
            String email = extras.getString("Email");
            String descripcion = extras.getString("Descripcion");
            String fecha = extras.getString("Fecha");

            etNombre.setText(nombre);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
            inputFecha.setText(fecha);
        }
    }


    public void agregarBoton() {
        Button botonSiguiente= (Button) findViewById(R.id.btnSiguiente);
        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i= new Intent (MainActivity.this, MostrarDatos.class);
                i.putExtra("Nombre",etNombre.getText().toString());
                i.putExtra("Telefono",etTelefono.getText().toString());
                i.putExtra("Email",etEmail.getText().toString());
                i.putExtra("Descripcion",etDescripcion.getText().toString());
                i.putExtra("Fecha",inputFecha.getText().toString());
                startActivity(i);

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.etFecha:
                showDatePickerDialog((EditText) view);
                break;
        }

    }



    public void showDatePickerDialog(EditText v) {
        DialogFragment newFragment = DatePickerFragment.newInstance(v);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}