package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dados extends AppCompatActivity {
    Button      btn_d12, btn_d4, btn_d20, btn_d8, btn_share;
    TextView    txt_d12, txt_d4, txt_d20, txt_d8, txt_total;
    int         r_d12, r_d4, r_d20, r_d8, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        //  Var inits
        r_d12 = 0;
        r_d4 = 0;
        r_d20 = 0;
        r_d8 = 0;
        total = 0;

        //  View inits
        btn_d12 = findViewById(R.id.btn_d12);
        btn_d4 = findViewById(R.id.btn_d4);
        btn_d20 = findViewById(R.id.btn_d20);
        btn_d8 = findViewById(R.id.btn_d8);
        btn_share = findViewById(R.id.btn_share);
        txt_d12 = findViewById(R.id.txt_d12);
        txt_d4 = findViewById(R.id.txt_d4);
        txt_d20 = findViewById(R.id.txt_d20);
        txt_d8 = findViewById(R.id.txt_d8);
        txt_total = findViewById(R.id.txt_total);

        //  Event handlers
        btn_d12.setOnClickListener(view ->  {
            r_d12 = throwDice(12);
            btn_d12.setClickable(false);
            btn_d12.setBackgroundTintList(btn_d12.getResources().getColorStateList(R.color.black));
            update();
        });
        btn_d4.setOnClickListener(view ->   {
            r_d4 = throwDice(4);
            btn_d4.setClickable(false);
            btn_d4.setBackgroundTintList(btn_d4.getResources().getColorStateList(R.color.black));
            update();
        });
        btn_d20.setOnClickListener(view ->  {
            r_d20 = throwDice(20);
            btn_d20.setClickable(false);
            btn_d20.setBackgroundTintList(btn_d20.getResources().getColorStateList(R.color.black));
            update();
        });
        btn_d8.setOnClickListener(view ->   {
            r_d8 = throwDice(8);
            btn_d8.setClickable(false);
            btn_d8.setBackgroundTintList(btn_d8.getResources().getColorStateList(R.color.black));
            update();
        });
        btn_share.setOnClickListener(view -> {
            Toast.makeText(this, "Compartiendo...", Toast.LENGTH_SHORT).show();
        });
    }

    // Simple, le decimos cuantos lados tiene el dado, y nos da un número entre 1 y el número
    // de lados especificado
    public int throwDice(int sides) {
        return (int) (Math.random() * sides + 1);
    }

    // Función principal del programa. Se encargará de reunir los valores de todas las tiradas en
    // una variable llamada "total". Además, asignará el valor de cada tirada al TextView que le
    // corresponde a cada dado. Por último, hará las comprobaciones necesarias para lanzar la
    // actividad con el mensaje de victoria o derrota, o mostrará el botón para compartir la
    // tirada.
    public void update() {
        total = r_d12 + r_d4 + r_d20 + r_d8;
        txt_d4.setText(Integer.toString(r_d4));
        txt_d12.setText(Integer.toString(r_d12));
        txt_d20.setText(Integer.toString(r_d20));
        txt_d8.setText(Integer.toString(r_d8));
        txt_total.setText(Integer.toString(total));
        if (r_d4 != 0 && r_d12 != 0 && r_d8 != 0 && r_d20 != 0) {
            // total = 41;
            if (total >= 40)
                showShareButton();
            else
                launchActivity();
        }
    }

    // ...
    public void showShareButton(){ btn_share.setVisibility(View.VISIBLE); }

    // Esta función reune las sentencias necesarias para lanzar la actividad con el mensaje de
    // victoria o derrota.
    public void launchActivity() {
        Intent inTexto = new Intent(this, TextoDados.class);
        inTexto.setAction(Intent.ACTION_SEND);
        inTexto.putExtra("total", Integer.toString(total));
        inTexto.setType("text/plain");
        startActivity(inTexto);
    }
}