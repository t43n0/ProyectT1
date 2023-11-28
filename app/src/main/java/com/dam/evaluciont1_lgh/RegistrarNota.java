package com.dam.evaluciont1_lgh; //TODO revisar el guardado en fichero y testear todo

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import datos.ListaNotas;
import datos.NotasAlumnAsig;

public class RegistrarNota extends AppCompatActivity implements View.OnClickListener {

    public static final String CLAVE_DATO = "DATO";
    ListaNotas listaNotas;
    Button btnSeleccionarAlumno;
    Button btnSeleccionarAsignatura;
    Button btnCalcularNota;
    Button btnGuardarDatos;
    Button btnLimpiarDatos;
    EditText etSelectAlumn;
    EditText etSelectAsig;
    EditText etNotaExamen;
    EditText etNotaActividades;
    EditText etNotaFinal;
    ActivityResultLauncher<Intent> safr1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            int resultCode = o.getResultCode();
            if(resultCode == SeleccionarAlumno.RESULT_OK_ALUMN) {
                assert o.getData() != null;
                etSelectAlumn.setText(o.getData().getStringExtra(CLAVE_DATO));
            }
        }
    });

    ActivityResultLauncher<Intent> safr2 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            int resultCode = o.getResultCode();
            if(resultCode == SeleccionarAsignatura.RESULT_OK_ASIG) {
                assert o.getData() != null;
                etSelectAsig.setText(o.getData().getStringExtra(CLAVE_DATO));
            }
        }
    });
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_nota);
        listaNotas = new ListaNotas();
        btnSeleccionarAlumno = findViewById(R.id.btnSeleccionarAlumno);
        btnSeleccionarAsignatura = findViewById(R.id.btnSeleccionarAsignatura);
        btnCalcularNota = findViewById(R.id.btnCalcularNota);
        btnGuardarDatos = findViewById(R.id.btnGuardarDatos);
        btnLimpiarDatos = findViewById(R.id.btnLimpiarDatos);
        etSelectAlumn = findViewById(R.id.etSelecAlumn);
        etSelectAsig = findViewById(R.id.etSelecAsig);
        etNotaExamen = findViewById(R.id.etNotaExamen);
        etNotaActividades = findViewById(R.id.etNotaActividades);
        etNotaFinal = findViewById(R.id.etNotaFinal);

        btnSeleccionarAlumno.setOnClickListener(this);
        btnSeleccionarAsignatura.setOnClickListener(this);
        btnCalcularNota.setOnClickListener(this);
        btnGuardarDatos.setOnClickListener(this);
        btnLimpiarDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSeleccionarAlumno) {
            obtenerAlumno();
        } else if (v.getId() == R.id.btnSeleccionarAsignatura) {
            obtenerAsignatura();
        } else if (v.getId() == R.id.btnCalcularNota) {
            calcularNotaFinal();
        } else if (v.getId() == R.id.btnGuardarDatos) {
            guardarDatos();
        } else if (v.getId() == R.id.btnLimpiarDatos) {
            limpiarCampos();
        }
    }

    private void obtenerAsignatura() {
        Intent i = new Intent(this, SeleccionarAsignatura.class);
        i.putExtra(CLAVE_DATO, dato);
        safr2.launch(i);
        btnSeleccionarAsignatura.setEnabled(false);
    }

    private void calcularNotaFinal() {
        if (etNotaExamen.getText().toString().isEmpty() ||
        etNotaActividades.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.toast_notas, Toast.LENGTH_SHORT).show();
        } else {
            double notaExamen = Double.parseDouble(etNotaExamen.getText().toString());
            double notaActividades = Double.parseDouble(etNotaActividades.getText().toString());

            double notaFinal;
            if (notaExamen >= 4 && notaActividades >= 7) {
                notaFinal = notaExamen * 0.6 + notaActividades * 0.4;
            } else if (notaExamen < 4) {
                notaFinal = notaExamen;
            } else {
                notaFinal = notaExamen * 0.7 + notaActividades * 0.3;
            }

            etNotaFinal.setText(String.valueOf(notaFinal));

            btnCalcularNota.setEnabled(false);
        }
    }

    private void guardarDatos() {
        if (etSelectAlumn.getText().toString().isEmpty() ||
                etSelectAsig.getText().toString().isEmpty() ||
                etNotaExamen.getText().toString().isEmpty() ||
                etNotaActividades.getText().toString().isEmpty() ||
                etNotaFinal.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.toast_registro, Toast.LENGTH_SHORT).show();
        } else {
            NotasAlumnAsig nota = new NotasAlumnAsig(
                    etSelectAlumn.getText().toString(),
                    etSelectAsig.getText().toString(),
                    Double.parseDouble(etNotaExamen.getText().toString()),
                    Double.parseDouble(etNotaActividades.getText().toString()),
                    Double.parseDouble(etNotaFinal.getText().toString())
            );
            btnGuardarDatos.setEnabled(false);
            guardarEnFichero(this, "notas.bin", nota);
        }
    }

    public static void guardarEnFichero(Context context, String nombreArchivo, Object objeto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(nombreArchivo, Context.MODE_PRIVATE))) {
            oos.writeObject(objeto);
            Toast.makeText(context, "Notas guardadas con exito", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, R.string.toast_errorGuardar, Toast.LENGTH_SHORT).show();
        }
    }


    private void limpiarCampos() {
        etSelectAlumn.setText("");
        etSelectAsig.setText("");
        etNotaExamen.setText("");
        etNotaActividades.setText("");
        etNotaFinal.setText("");
        btnCalcularNota.setEnabled(true);
        btnSeleccionarAlumno.setEnabled(true);
        btnSeleccionarAsignatura.setEnabled(true);
        btnGuardarDatos.setEnabled(true);
    }

    private void obtenerAlumno() {
        Intent i = new Intent(this, SeleccionarAlumno.class);
        i.putExtra(CLAVE_DATO, dato);
        safr1.launch(i);
        btnSeleccionarAlumno.setEnabled(false);
    }
}