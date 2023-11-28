package com.dam.evaluciont1_lgh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeleccionarAlumno extends AppCompatActivity implements View.OnClickListener {

    public static final int RESULT_OK_ALUMN = 101;
    Button alumn1;
    Button alumn2;
    Button alumn3;
    Button alumn4;
    Button alumn5;
    Button alumn6;
    Button alumn7;
    Button alumn8;
    Button alumn9;
    Button alumn10;
    Button alumn11;
    Button alumn12;
    Button alumn13;
    Button alumn14;
    Button alumn15;
    Button alumn16;
    Button alumn17;
    Button alumn18;
    Button alumn19;
    Button alumn20;
    Button alumn21;
    Button alumn22;
    Button aceptar;
    Button cancelar;
    EditText etAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_alumno);
        alumn1 = findViewById(R.id.btnAlum1);
        alumn2 = findViewById(R.id.btnAlum2);
        alumn3 = findViewById(R.id.btnAlum3);
        alumn4 = findViewById(R.id.btnAlum4);
        alumn5 = findViewById(R.id.btnAlum5);
        alumn6 = findViewById(R.id.btnAlum6);
        alumn7 = findViewById(R.id.btnAlum7);
        alumn8 = findViewById(R.id.btnAlum8);
        alumn9 = findViewById(R.id.btnAlum9);
        alumn10 = findViewById(R.id.btnAlum10);
        alumn11 = findViewById(R.id.btnAlum11);
        alumn12 = findViewById(R.id.btnAlum12);
        alumn13 = findViewById(R.id.btnAlum13);
        alumn14 = findViewById(R.id.btnAlum14);
        alumn15 = findViewById(R.id.btnAlum15);
        alumn16 = findViewById(R.id.btnAlum16);
        alumn17 = findViewById(R.id.btnAlum17);
        alumn18 = findViewById(R.id.btnAlum18);
        alumn19 = findViewById(R.id.btnAlum19);
        alumn20 = findViewById(R.id.btnAlum20);
        alumn21 = findViewById(R.id.btnAlum21);
        alumn22 = findViewById(R.id.btnAlum22);
        aceptar = findViewById(R.id.btnAceptar);
        cancelar = findViewById(R.id.btnCancelar);
        etAlumno = findViewById(R.id.etAlumnSeleccionado);

        alumn1.setOnClickListener(this);
        alumn2.setOnClickListener(this);
        alumn3.setOnClickListener(this);
        alumn4.setOnClickListener(this);
        alumn5.setOnClickListener(this);
        alumn6.setOnClickListener(this);
        alumn7.setOnClickListener(this);
        alumn8.setOnClickListener(this);
        alumn9.setOnClickListener(this);
        alumn10.setOnClickListener(this);
        alumn11.setOnClickListener(this);
        alumn12.setOnClickListener(this);
        alumn13.setOnClickListener(this);
        alumn14.setOnClickListener(this);
        alumn15.setOnClickListener(this);
        alumn16.setOnClickListener(this);
        alumn17.setOnClickListener(this);
        alumn18.setOnClickListener(this);
        alumn19.setOnClickListener(this);
        alumn20.setOnClickListener(this);
        alumn21.setOnClickListener(this);
        alumn22.setOnClickListener(this);
        aceptar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAlum1) {
            etAlumno.setText(R.string.alberto_barba_soriano);
        } else if (v.getId() == R.id.btnAlum2) {
            etAlumno.setText(R.string.alvaro_blazquez_vallejo);
        } else if (v.getId() == R.id.btnAlum3) {
            etAlumno.setText(R.string.raul_carrizo_martin);
        } else if (v.getId() == R.id.btnAlum4) {
            etAlumno.setText(R.string.joana_casco_galea);
        } else if (v.getId() == R.id.btnAlum5) {
            etAlumno.setText(R.string.javier_dominguez_fernandez);
        } else if (v.getId() == R.id.btnAlum6) {
            etAlumno.setText(R.string.gabriel_fernandez_aguilera);
        } else if (v.getId() == R.id.btnAlum7) {
            etAlumno.setText(R.string.amancio_javier_fernandez_lobo);
        } else if (v.getId() == R.id.btnAlum8) {
            etAlumno.setText(R.string.luis_gallego_herrero);
        } else if (v.getId() == R.id.btnAlum9) {
            etAlumno.setText(R.string.daniel_gallo_romo);
        } else if (v.getId() == R.id.btnAlum10) {
            etAlumno.setText(R.string.alberto_garcia_altez);
        } else if (v.getId() == R.id.btnAlum11) {
            etAlumno.setText(R.string.carlos_garcia_hernandez);
        } else if (v.getId() == R.id.btnAlum12) {
            etAlumno.setText(R.string.juan_manuel_guerra_arcas);
        } else if (v.getId() == R.id.btnAlum13) {
            etAlumno.setText(R.string.marcos_gimenez_diaz);
        } else if (v.getId() == R.id.btnAlum14) {
            etAlumno.setText(R.string.gonzalo_gonzalez_rodriguez);
        } else if (v.getId() == R.id.btnAlum15) {
            etAlumno.setText(R.string.jalil_martin_londres_blanes);
        } else if (v.getId() == R.id.btnAlum16) {
            etAlumno.setText(R.string.ignacio_martin_fernandez);
        } else if (v.getId() == R.id.btnAlum17) {
            etAlumno.setText(R.string.javier_martinez_gomez);
        } else if (v.getId() == R.id.btnAlum18) {
            etAlumno.setText(R.string.victor_perez_ramirez);
        } else if (v.getId() == R.id.btnAlum19) {
            etAlumno.setText(R.string.lorenzo_saez_bejar);
        } else if (v.getId() == R.id.btnAlum20) {
            etAlumno.setText(R.string.nicolas_suarez_ruiz);
        } else if (v.getId() == R.id.btnAlum21) {
            etAlumno.setText(R.string.liana_vilkelenoka);
        } else if (v.getId() == R.id.btnAlum22) {
            etAlumno.setText(R.string.angel_zhang);
        } else if (v.getId() == R.id.btnAceptar) {
            if (etAlumno.getText().toString().isEmpty()) {
                Toast.makeText(this, "Debe especificar el alumno seleccionado", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent();
                i.putExtra(RegistrarNota.CLAVE_DATO, etAlumno.getText().toString());
                setResult(RESULT_OK_ALUMN, i);
                finish();
            }
        } else if (v.getId() == R.id.btnCancelar) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }

}