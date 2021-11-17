package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "A2_State";
    EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editTxt = findViewById(R.id.editTxt);
        if (savedInstanceState != null)
            editTxt.setText(savedInstanceState.getCharSequence("texto"));
        Log.i(TAG, "Created");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editTxt.setText(savedInstanceState.getCharSequence("texto"));
        Log.d(TAG, "RECREADO ADSDAKSJDASJDKLASJDAKLSDJAKLSDJLAKSJDKLASODAKSDJA");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("texto", editTxt.getText());
        Log.d(TAG, "GUARDADO ADSDAKSJDASJDKLASJDAKLSDJAKLSDJLAKSJDKLASODAKSDJA");
    }
}