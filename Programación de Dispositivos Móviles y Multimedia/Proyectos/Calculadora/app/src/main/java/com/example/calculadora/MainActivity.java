package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button  btn_calc, btn_form, btn_dados, btn_listas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Initialization
        btn_calc = findViewById(R.id.btn_calc);
        btn_form = findViewById(R.id.btn_form);
        btn_dados = findViewById(R.id.btn_dados);
        btn_listas = findViewById(R.id.btn_listas);

        //  Event handlers
        btn_calc.setOnClickListener(view -> {
            Intent calculadora = new Intent(this, Calculadora.class);
            startActivity(calculadora);
        });
        btn_form.setOnClickListener(view -> {
            Intent formulario = new Intent(this, Form.class);
            startActivity(formulario);
        });
        btn_dados.setOnClickListener(view -> {
            Intent dados = new Intent(this, Dados.class);
            startActivity(dados);
        });
        btn_listas.setOnClickListener(view -> {
            Intent listas = new Intent(this, Listas.class);
            startActivity(listas);
        });
    }
}
