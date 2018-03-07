package com.example.axelcuevas.integradora_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class finalform extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalform);

        Intent get = getIntent();
        String nombre = get.getStringExtra("nombre");
        String edad = get.getStringExtra("edad");
        String sexo = get.getStringExtra("sexo");
        String persona = get.getStringExtra("person");
        String fruta = get.getStringExtra("fruta");
        String carne = get.getStringExtra("carne");
        String cereal = get.getStringExtra("cereal");
        String legumbre = get.getStringExtra("legumbre");

        info = findViewById(R.id.info);
        info.setText("nombre");
    }
}
