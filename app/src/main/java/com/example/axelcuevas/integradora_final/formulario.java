package com.example.axelcuevas.integradora_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class formulario extends AppCompatActivity implements View.OnClickListener{

    private TextView imcTxt;
    private EditText nombre, edad;
    private RadioGroup sexGroup, personGroup;
    private RadioButton sex, person;
    private CheckBox casa, escuela, oficina, deporte;
    private Spinner fruta, carne, cereal, leguminosa;
    private Button check;

    private RelativeLayout personLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Intent main = getIntent();
        Double imc = main.getDoubleExtra("imc", 0.00);

        //Buttons
        check = findViewById(R.id.check);
        check.setOnClickListener(this);

        //TextView
        imcTxt = findViewById(R.id.imc);
        imcTxt.setText("Su IMC es: " + imc);

        //editText
        nombre = findViewById(R.id.name);
        edad = findViewById(R.id.age);

        //RadioGroups
        sexGroup = findViewById(R.id.sex);
        personGroup = findViewById(R.id.person);

        //Layouts
        personLayout = findViewById(R.id.personLay);
        personLayout.setVisibility(RelativeLayout.GONE);

        //Spinners
        fruta = findViewById(R.id.fruta);
        ArrayAdapter<CharSequence> dataf = ArrayAdapter.createFromResource(this,R.array.frutas, android.R.layout.simple_spinner_dropdown_item);
        dataf.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fruta.setAdapter(dataf);

        carne = findViewById(R.id.carne);
        ArrayAdapter<CharSequence> datac = ArrayAdapter.createFromResource(this,R.array.carne, android.R.layout.simple_spinner_dropdown_item);
        datac.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carne.setAdapter(datac);

        cereal = findViewById(R.id.cereal);
        ArrayAdapter<CharSequence> datace = ArrayAdapter.createFromResource(this,R.array.cereales, android.R.layout.simple_spinner_dropdown_item);
        datace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cereal.setAdapter(datace);

        leguminosa = findViewById(R.id.legumbres);
        ArrayAdapter<CharSequence> datal = ArrayAdapter.createFromResource(this,R.array.legumbres, android.R.layout.simple_spinner_dropdown_item);
        datal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        leguminosa.setAdapter(datal);

        //CheckBox
        casa = findViewById(R.id.home);
        escuela = findViewById(R.id.school);
        deporte = findViewById(R.id.sport);
        oficina = findViewById(R.id.office);

        personGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                person = findViewById(i);
                if(person.getText().toString().equals("Sedentario")){
                    personLayout.setVisibility(RelativeLayout.GONE);
                }
                else{
                    personLayout.setVisibility(RelativeLayout.VISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int sexselected = sexGroup.getCheckedRadioButtonId();
        sex = findViewById(sexselected);

        int perselected = personGroup.getCheckedRadioButtonId();
        person = findViewById(perselected);




        Intent finalform = new Intent(this, finalform.class);
        finalform.putExtra("nombre", nombre.getText().toString());
        finalform.putExtra("edad", edad.getText().toString());
        finalform.putExtra("sexo", sex.getText().toString());
        if(person.getText().toString().equals("Sedentario")){
            finalform.putExtra("person", person.getText().toString());
        }
        else{
            String chain = "";
            if(casa.isChecked()){
                chain += casa.getText().toString() + " ";
            }
            if(escuela.isChecked()){
                chain += escuela.getText().toString() + " ";
            }
            if(deporte.isChecked()){
                chain += deporte.getText().toString() + " ";
            }
            if(oficina.isChecked()){
                chain += oficina.getText().toString() + " ";
            }
            finalform.putExtra("person", "Mixta: " + chain);
        }
        finalform.putExtra("fruta", fruta.getSelectedItem().toString());
        finalform.putExtra("carne", carne.getSelectedItem().toString());
        finalform.putExtra("cereal", cereal.getSelectedItem().toString());
        finalform.putExtra("legumbre", leguminosa.getSelectedItem().toString());

        startActivity(finalform);

    }
}
