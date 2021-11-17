package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    Button      btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_dot,
                btn_mult, btn_div, btn_sum, btn_sub, btn_eq,
                btn_delete, btn_clear;
    TextView    display_main, display_second;
    float       oper1, oper2, result;
    char        operand;
    int         original_txt_size, cur_txt_size;
    boolean     finished_oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  Initialization
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        display_main = findViewById(R.id.display_main);
        display_second = findViewById(R.id.display_second);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_dot = findViewById(R.id.btn_dot);
        btn_mult = findViewById(R.id.btn_mult);
        btn_div = findViewById(R.id.btn_div);
        btn_sum = findViewById(R.id.btn_sum);
        btn_sub = findViewById(R.id.btn_sub);
        btn_eq = findViewById(R.id.btn_eq);
        btn_delete = findViewById(R.id.btn_delete);
        btn_clear = findViewById(R.id.btn_clear);
        operand = '\0';
        oper1 = 0.0f;
        oper2 = 0.0f;
        result = 0.0f;
        original_txt_size = 96;
        cur_txt_size = original_txt_size;
        finished_oper = false;

        //  Event handlers

        //      Numbers
        btn1.setOnClickListener(view -> numberClicked(1));
        btn2.setOnClickListener(view -> numberClicked(2));
        btn3.setOnClickListener(view -> numberClicked(3));
        btn4.setOnClickListener(view -> numberClicked(4));
        btn5.setOnClickListener(view -> numberClicked(5));
        btn6.setOnClickListener(view -> numberClicked(6));
        btn7.setOnClickListener(view -> numberClicked(7));
        btn8.setOnClickListener(view -> numberClicked(8));
        btn9.setOnClickListener(view -> numberClicked(9));
        btn0.setOnClickListener(view -> {
            if (display_main.getText().equals("0"))
                return;
            numberClicked(0);
        });
        btn_dot.setOnClickListener(view -> periodClicked());
        //      End numbers

        //      Operands
        btn_mult.setOnClickListener(view -> operandClicked('*'));
        btn_div.setOnClickListener(view -> operandClicked('/'));
        btn_sum.setOnClickListener(view -> operandClicked('+'));
        btn_sub.setOnClickListener(view -> operandClicked('-'));
        btn_eq.setOnClickListener(view -> equals());
        //      End Operands

        //      Action Buttons
        btn_clear.setOnClickListener(view -> clearClicked());
        btn_delete.setOnClickListener(view -> deleteClicked());
        //      End Action Buttons

        //  Method calls
        zeroMainDisplay();
        clearSecondDisplay();
    }

    //  Poner el display principal a 0.
    public void zeroMainDisplay() {
        this.display_main.setText("0");
    }

    // Borrar los contenidos del display secundario.
    public void clearSecondDisplay() {
        this.display_second.setText("");
    }

    // Esta función ajustará el tamaño del texto en el display dependiendo del número de dígitos que
    // se hayan introducido.
    public void adjustDisplayTextSize() {
        if (this.display_main.getText().length() < 5)
            this.cur_txt_size = this.original_txt_size;
        else
            this.cur_txt_size = 500 / this.display_main.getText().length();
        this.display_main.setTextSize(this.cur_txt_size);
    }

    // Rutina que se llevará a cabo cuando se pulse un número.
    public void numberClicked(int n) {
        if (finished_oper) {
            finished_oper = false;
            clearClicked();
            this.display_main.setText("" + n);
            return;
        }
        if (display_main.getText().toString().equals("0"))
            this.display_main.setText("" + n);
        else
            this.display_main.append("" + n);
        adjustDisplayTextSize();
    }

    // Funcionalidad al pulsar la tecla del punto.
    public void periodClicked() {
        if (!this.display_main.getText().toString().contains(".")) {
            this.display_main.append(".");
        }
    }

    // Función que borra todos los datos introducidos. Será la funcionalidad de el botón "clear",
    // aunque lo uso en otras partes del código.
    public void clearClicked() {
        clearSecondDisplay();
        zeroMainDisplay();
        adjustDisplayTextSize();
        this.oper1 = 0.0f;
        this.oper2 = 0.0f;
        this.operand = '\0';
    }

    // Función que borra el último número representado en el display.
    public void deleteClicked() {
        if (finished_oper)
            finished_oper = false;
        if (this.display_main.getText().equals("0"))
            return;
        this.display_main.setText(
                this.display_main.getText().subSequence(
                        0, this.display_main.getText().length() - 1));
        if (this.display_main.getText().toString().equals(""))
            zeroMainDisplay();
        adjustDisplayTextSize();
    }

    // Funcionalidad al pulsar cualquier operando.
    public void operandClicked(char operand) {
        if (finished_oper)
            finished_oper = false;
        try {
            oper1 = Float.parseFloat(this.display_main.getText().toString());
            this.operand = operand;
            this.display_second.setText(display_main.getText() + " " + operand + " ");
            zeroMainDisplay();
            adjustDisplayTextSize();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Funcionalidad al pulsar el botón de "igual". Se podría decir que es la función principal
    // del programa, pero no por eso la más importante.
    public void equals() {
        if (this.operand == '\0')
            return;
        try {
            this.oper2 = Float.parseFloat(this.display_main.getText().toString());
            this.display_second.setText(this.oper1 + " " + this.operand + " " + this.oper2);
            switch (this.operand) {
                case '+':
                    result = sum(this.oper1, this.oper2);
                    break;
                case '-':
                    result = sub(this.oper1, this.oper2);
                    break;
                case '*':
                    result = mult(this.oper1, this.oper2);
                    break;
                case '/':
                    result = div(this.oper1, this.oper2);
                    break;
                default:
                    this.display_second.setText("ERROR");
                    zeroMainDisplay();
                    break;
            }
            this.display_main.setText(Float.toString(result));
            adjustDisplayTextSize();
            finished_oper = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Functions
    public float sum(float oper1, float oper2) {
        return oper1 + oper2;
    }

    public float sub(float oper1, float oper2) {
        return oper1 - oper2;
    }

    public float mult(float oper1, float oper2) {
        return oper1 * oper2;
    }

    public float div(float oper1, float oper2) {
        if (oper2 == 0)
            return Float.NaN;
        return oper1 / oper2;
    }
}