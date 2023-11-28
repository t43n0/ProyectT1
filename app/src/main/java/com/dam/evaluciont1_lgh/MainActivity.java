package com.dam.evaluciont1_lgh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegistrarNota;
    Button btnConsultarNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConsultarNota = findViewById(R.id.btnConsultarNota);
        btnRegistrarNota = findViewById(R.id.btnRegistrarNota);

        btnRegistrarNota.setOnClickListener(this);
        btnConsultarNota.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRegistrarNota) {
            Intent i = new Intent(this, RegistrarNota.class);
            startActivity(i);
        } else if (v.getId() == R.id.btnConsultarNota) {
            Intent i = new Intent(this, ConsultarNota.class);
            startActivity(i);
        }
    }
}