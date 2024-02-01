package com.example.promedio_examen;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    private EditText nota1E;
    private EditText nota2E;
    private EditText promedioE;
    private EditText mejoramientoE;
    private TextView promE;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1E = findViewById(R.id.nota1);
        nota2E = findViewById(R.id.nota2);
        promedioE = findViewById(R.id.promedio);
        mejoramientoE=findViewById(R.id.mejoramiento);
        promE=findViewById(R.id.profinal);

        Button calcularButton = findViewById(R.id.boton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularPromedio();
            }
        });
        Button calcularMejoramiento = findViewById(R.id.boton2);
       calcularMejoramiento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calcularMejorP();
           }
       });
    }
    private void calcularPromedio() {
        float nota1 = Float.parseFloat(nota1E.getText().toString());
        float nota2 = Float.parseFloat(nota2E.getText().toString());

        float suma = nota1 + nota2;
        float promedioT = suma / 2;

        promedioT= Math.round(promedioT*100.0)/100.0f;

        promedioE.setText(String.valueOf(promedioT));
    }
    private void calcularMejorP(){
        float mejoramiento=Float.parseFloat(mejoramientoE.getText().toString());
        float promediototal=Float.parseFloat(promedioE.getText().toString());
        double sum= (mejoramiento*0.6)+(promediototal*0.4);

        sum=Math.round(sum*100.0)/100.0;

        promE.setText(String.format("%.2f",sum));
    }
}




