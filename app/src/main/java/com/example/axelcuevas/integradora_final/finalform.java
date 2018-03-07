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

        int cfrutas, ccarne, ccereal, cleguminosa;

        cfrutas = 0;
        ccarne = 0;
        ccereal = 0;
        cleguminosa = 0;

        if(fruta.equals("Apio")){
            cfrutas = 50;
        }
        if(fruta.equals("Lechuga")){
            cfrutas = 13;
        }
        if(fruta.equals("Zanahoria")){
            cfrutas = 44;
        }
        if(fruta.equals("Tomate")){
            cfrutas = 13;
        }
        if(carne.equals("Res Asada")){
            ccarne = 240;
        }
        if(carne.equals("Res Molida")){
            ccarne = 120;
        }
        if(carne.equals("Pechuga de Pollo")){
            ccarne = 320;
        }
        if(carne.equals("Pierna de Pollo")){
            ccarne = 120;
        }
        if(cereal.equals("Arroz")){
            ccereal = 230;
        }
        if(cereal.equals("Hojuelas")){
            ccereal = 109;
        }
        if(cereal.equals("Pan de molde")){
            ccereal = 80;
        }
        if(cereal.equals("Pan frances")){
            ccereal = 116;
        }
        if(legumbre.equals("Frijol")){
            cleguminosa = 145;
        }
        if(legumbre.equals("Chicharo")){
            cleguminosa = 157;
        }
        if(legumbre.equals("Haba")){
            cleguminosa = 157;
        }
        if(legumbre.equals("Lenteja")){
            cleguminosa = 160;
        }

        int total = cfrutas + ccarne + ccereal + cleguminosa;

        String mensaje = "";
        if(total>700){
            mensaje = "Debes controlar más lo que comes!!";
        }
        if(400<total && total<700){
            mensaje = "Sigue así, excelente dieta!";
        }
        if(total<400){
            mensaje = "Deberías aumentar lo que comes!";
        }

        info = findViewById(R.id.info);
        info.setText(nombre + " de " + edad +  " años de edad has elegido:\n" +
                "Sexo: " + sexo + "\n" +
                "Tipo de persona " + persona + "\n" +
                "Fruta: " + fruta + " ("+cfrutas+" cal)" + "\n" +
                "Origen Animal: " + carne + " ("+ccarne+" cal)" + "\n" +
                "Cereal: " + cereal + " ("+ccereal+" cal)" +  "\n" +
                "Leguminosa: " + legumbre + " ("+cleguminosa+" cal)" + "\n" +
                "Total: " + total + "cal" + "\n" +
                mensaje);
    }
}
