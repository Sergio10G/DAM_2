package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;
import com.google.firebase.database.DataSnapshot;

public class MainActivity extends AppCompatActivity {

    public static User loggedUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Database.connect();

        Intent intent = null;
        if (loggedUser == null) {
            intent = new Intent(this, Login.class);
        }
        else {
            intent = new Intent(this, Game.class);
        }
        startActivity(intent);
    }
}