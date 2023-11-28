package com.dam.evaluciont1_lgh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeleccionarAsignatura extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_OK_ASIG = 101;
    Button btnAsig1;
    Button btnAsig2;
    Button btnAsig3;
    Button btnAsig4;
    Button btnAsig5;
    Button btnAsig6;
    Button btnAsig7;
    Button btnAceptar;
    Button btnCancelar;
    EditText etAsignaturaSeleccionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_asignatura);
        btnAsig1 = findViewById(R.id.asig1);
        btnAsig2 = findViewById(R.id.asig2);
        btnAsig3 = findViewById(R.id.asig3);
        btnAsig4 = findViewById(R.id.asig4);
        btnAsig5 = findViewById(R.id.asig5);
        btnAsig6 = findViewById(R.id.asig6);
        btnAsig7 = findViewById(R.id.asig7);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        etAsignaturaSeleccionada = findViewById(R.id.etAsigSeleccionada);

        btnAsig1.setOnClickListener(this);
        btnAsig2.setOnClickListener(this);
        btnAsig3.setOnClickListener(this);
        btnAsig4.setOnClickListener(this);
        btnAsig5.setOnClickListener(this);
        btnAsig6.setOnClickListener(this);
        btnAsig7.setOnClickListener(this);
        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.asig1) {
            etAsignaturaSeleccionada.setText(R.string.pmdm);
        } else if (v.getId() == R.id.asig2) {
            etAsignaturaSeleccionada.setText(R.string.ad);
        } else if (v.getId() == R.id.asig3) {
            etAsignaturaSeleccionada.setText(R.string.psp);
        } else if (v.getId() == R.id.asig4) {
            etAsignaturaSeleccionada.setText(R.string.di);
        } else if (v.getId() == R.id.asig5) {
            etAsignaturaSeleccionada.setText(R.string.sge);
        } else if (v.getId() == R.id.asig6) {
            etAsignaturaSeleccionada.setText(R.string.iacc);
        } else if (v.getId() == R.id.asig7) {
            etAsignaturaSeleccionada.setText(R.string.ios);
        } else if (v.getId() == R.id.btnAceptar) {
            if (etAsignaturaSeleccionada.getText().toString().isEmpty()) {
                Toast.makeText(this, "Debe especificar la asignatura seleccionado", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent();
                i.putExtra(RegistrarNota.CLAVE_DATO, etAsignaturaSeleccionada.getText().toString());
                setResult(RESULT_OK_ASIG, i);
                finish();
            }
        } else if (v.getId() == R.id.btnCancelar) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}