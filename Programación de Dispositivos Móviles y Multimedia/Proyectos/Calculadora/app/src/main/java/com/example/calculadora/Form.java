package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    EditText    txt_name, txt_surname, txt_tlf, txt_captcha;
    TextView    num_captcha;
    Button      btn_verify;
    String      captcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //  Var inits
        captcha = generateRandomNum(6);

        //  View inits
        txt_name = findViewById(R.id.txt_name);
        txt_surname = findViewById(R.id.txt_surname);
        txt_tlf = findViewById(R.id.txt_tlf);
        txt_captcha = findViewById(R.id.txt_captcha);
        num_captcha = findViewById(R.id.num_captcha);
        btn_verify = findViewById(R.id.btn_verify);

        //  Event handlers
        btn_verify.setOnClickListener(view -> verify());

        //  Starting values
        num_captcha.setText(captcha);
    }

    //  Vacía todos los campos y genera otro captcha
    public void resetValues() {
        txt_name.setText("");
        txt_surname.setText("");
        txt_tlf.setText("");
        txt_captcha.setText("");
        captcha = generateRandomNum(6);
        num_captcha.setText(captcha);
    }

    //  Generador de números aleatorios de n dígitos
    public String generateRandomNum(int n) {
        StringBuilder num;

        if (n < 1)
            return "";
        num = new StringBuilder(Integer.toString((int) (Math.random() * Math.pow(10, n))));
        // El número siempre tendrá como máximo 6 dígitos, pero también puede tener menos.
        // Como volver a generar números aleatorios sería costoso en ejecución, simplemente
        // relleno el número de ceros hasta alcanzar la longitud deseada.
        while (num.length() < n)
            num.append('0');
        return num.toString();
    }

    //  Checkeo del formulario. De momento solo detecta si los campos están vacíos.
    public boolean checkForm() {
        return !txt_name.getText().toString().equals("") &&
                !txt_surname.getText().toString().equals("") &&
                !txt_tlf.getText().toString().equals("");
    }

    //  Checkea que el captcha introducido coincida con el que se pide.
    public boolean checkCaptcha() {
        return captcha.equals(txt_captcha.getText().toString());
    }

    //  Reune los dos checkeos anteriores, y según el resultado, muestra diferentes alertas al
    //  usuario
    public void verify() {

        if (checkForm()) {
            if (checkCaptcha()) {
                Toast.makeText(getApplicationContext(), "¡Formulario enviado con éxito!.",
                        Toast.LENGTH_SHORT).show();
                printValues();
            }
            else
                Toast.makeText(getApplicationContext(), "ERROR: el captcha introducido " +
                        "es erróneo.", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "ERROR: El formulario debe estar relleno " +
                    "por completo.", Toast.LENGTH_SHORT).show();
        resetValues();
    }

    public void printValues() {
        System.out.println( "\n---------\tDATOS\t---------\n" +
                            "Nombre:\t" + txt_name.getText() + "\n" +
                            "Apellidos:\t" + txt_surname.getText() + "\n" +
                            "Teléfono:\t" + txt_tlf.getText() + "\n" +
                            "---------------------------");
    }
}