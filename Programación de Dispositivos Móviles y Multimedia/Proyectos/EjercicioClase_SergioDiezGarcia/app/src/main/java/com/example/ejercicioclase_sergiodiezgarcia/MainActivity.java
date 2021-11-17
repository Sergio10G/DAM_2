package com.example.ejercicioclase_sergiodiezgarcia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button btn;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cont = 0;
        btn = findViewById(R.id.button1);
        text = findViewById(R.id.text1);
        btn.setText("Contador de clicks");
        text.setText("Clickado 0 veces.");
    }

    public void algo(View view) {
        cont++;
        text.setText("Clickado " + cont);
        if (cont == 1)
            text.append(" vez.");
        else
            text.append(" veces.");
    }
}