package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TextoDados extends AppCompatActivity {
    TextView        txt_res_dados;
    int             total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto_dados);

        // Inicializamos dos variables, una para el total de las tiradas, y otra para el TextView
        total = 0;
        txt_res_dados = findViewById(R.id.txt_res_dados);

        // Recogemos el intent que invocó esta actividad
        Intent i = getIntent();
        // Del intent cogemos los datos, en este caso el total
        total = Integer.parseInt(i.getStringExtra("total"));
        // En base al total obtenido en las tiradas, mostramos el mensaje de victoria o derrota
        if (total <= 20)
            txt_res_dados.setText("YOU DIED");
        else
            txt_res_dados.setText("VICTORY!");

    }
}