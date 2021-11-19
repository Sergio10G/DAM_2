package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class Listas extends AppCompatActivity {
    //private FragmentContainerView fcv;
    private FragmentManager fm;
    private Button btnAdd, btnAdd2, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        //fcv = findViewById(R.id.fcv1);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd2 = findViewById(R.id.btnAdd2);
        btnRemove = findViewById(R.id.btnRemove);
        fm = getSupportFragmentManager();

        btnAdd.setOnClickListener(view -> {
            fm.beginTransaction()
                    .setCustomAnimations(
                            R.anim.fade_in,
                            R.anim.fade_out,
                            R.anim.slide_in,
                            R.anim.slide_out
                    )
                    .replace(R.id.fcv1, Fragmento1.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("Fragmento1")
                    .commit();
        });

        btnAdd2.setOnClickListener(view -> {
            fm.beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.slide_out,
                            R.anim.fade_in,
                            R.anim.fade_out
                    )
                    .replace(R.id.fcv1, Fragmento2.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("Fragmento2")
                    .commit();
        });

        btnRemove.setOnClickListener(view -> {
            try {
                fm.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.slide_in,
                                R.anim.slide_out
                        )
                        .remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.fcv1)))
                        .commit();
            }
            catch (Exception e) {

            }
        });
    }
}