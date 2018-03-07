package com.example.axelcuevas.integradora_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText altura, peso;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altura = findViewById(R.id.height);
        peso = findViewById(R.id.weight);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        double height = Double.parseDouble(altura.getText().toString());
        double weight = Double.parseDouble(peso.getText().toString());

        double resultado = weight/(Math.pow(height, 2));
        System.out.println(resultado);

        Intent formulario = new Intent(this, formulario.class);
        formulario.putExtra("imc", resultado);
        startActivity(formulario);
    }
}
