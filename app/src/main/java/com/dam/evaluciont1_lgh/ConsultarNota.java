package com.dam.evaluciont1_lgh;

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
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import datos.ListaNotas;
import datos.NotasAlumnAsig;

public class ConsultarNota extends AppCompatActivity implements View.OnClickListener {

    public static final String CLAVE_DATO = "DATO";
    private String dato;
    private ListaNotas listaNotas;
    private boolean btnLimpiar = false;
    Button btnPrincipal;
    EditText etAlumno;
    TextView tvPmdm;
    TextView tvAd;
    TextView tvPsp;
    TextView tvDi;
    TextView tvSge;
    TextView tvIacc;
    TextView tvIos;

    ActivityResultLauncher<Intent> safr1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            int resultCode = o.getResultCode();
            if (resultCode == SeleccionarAlumno.RESULT_OK_ALUMN) {
                assert o.getData() != null;
                etAlumno.setText(o.getData().getStringExtra(CLAVE_DATO));
                mostrarAsignaturasAprovadas();
                activarBtnLimpiar(true);
            } else if (resultCode == RESULT_CANCELED) {
                activarBtnLimpiar(false);
            }
        }
    });

    private void mostrarAsignaturasAprovadas() { //TODO terminar
        ArrayList<NotasAlumnAsig> notas = listaNotas.obtenerNotasPorAlumno(etAlumno.getText().toString());
        for (NotasAlumnAsig nota : notas) {
            if (nota.getNotaFinal() >= 5.0) {
                if (nota.getAsignatura().equals(getString(R.string.pmdm))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvPmdm.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.ad))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvAd.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.psp))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvPsp.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.di))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvDi.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.sge))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvSge.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.iacc))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvIacc.setText(displayedTxt);
                } else if (nota.getAsignatura().equals(getString(R.string.ios))) {
                    String displayedTxt = nota.getAsignatura() + getString(R.string.space) + nota.getNotaFinal();
                    tvIos.setText(displayedTxt);
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_nota);
        listaNotas = new ListaNotas();
        btnPrincipal = findViewById(R.id.btnSeleccionarAlumno);
        etAlumno = findViewById(R.id.etSelecAlumn);
        tvPmdm = findViewById(R.id.tvPmdm);
        tvAd = findViewById(R.id.tvAd);
        tvPsp = findViewById(R.id.tvPsp);
        tvDi = findViewById(R.id.tvDi);
        tvSge = findViewById(R.id.tvSge);
        tvIacc = findViewById(R.id.tvIacc);
        tvIos = findViewById(R.id.tvIos);

        NotasAlumnAsig notas = leerObjetoDesdeArchivo(this, "notas.bin");
        assert notas != null;
        tvIos.setText(notas.getNombreAlumno());

        btnPrincipal.setOnClickListener(this);
    }

    public static NotasAlumnAsig leerObjetoDesdeArchivo(Context context, String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(context.openFileInput(nombreArchivo))) {
            Object objeto = ois.readObject();
            // Puedes agregar lógica adicional aquí, como mostrar un mensaje de éxito
            return (NotasAlumnAsig) objeto;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSeleccionarAlumno) {
            if (btnLimpiar) {
                activarBtnLimpiar(false);
            } else {
                Intent i = new Intent(this, SeleccionarAlumno.class);
                i.putExtra(CLAVE_DATO, dato);
                safr1.launch(i);
            }
        }
    }

    public void activarBtnLimpiar(boolean b) {
        if (b) {
            btnPrincipal.setText(R.string.btn_limpiar_datos);
            btnLimpiar = true;
        } else {
            etAlumno.setText("");
            tvPmdm.setText("");
            tvAd.setText("");
            tvPsp.setText("");
            tvDi.setText("");
            tvSge.setText("");
            tvIacc.setText("");
            tvIos.setText("");
            btnPrincipal.setText(R.string.btn_selec_alumn);
            btnLimpiar = false;
        }
    }
}