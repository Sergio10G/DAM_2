package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private FragmentContainerView fcv;
    private FragmentManager fm;
    private Button btnAdd, btnRemove;
    private boolean fragmentPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         fcv = findViewById(R.id.fcv1);
         btnAdd = findViewById(R.id.btnAdd);
         btnRemove = findViewById(R.id.btnRemove);
         fm = getSupportFragmentManager();
         fragmentPresent = false;

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
             if (!fragmentPresent)
                 fragmentPresent = true;
         });

         btnRemove.setOnClickListener(view -> {
             if (fragmentPresent) {
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
             fragmentPresent = false;
         });
    }

}