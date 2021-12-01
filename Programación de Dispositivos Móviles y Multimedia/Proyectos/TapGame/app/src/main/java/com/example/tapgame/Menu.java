package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tapgame.model.User;

public class Menu extends AppCompatActivity {
    User loggedUser;
    Button btnPlay, btnLdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        loggedUser = User.fromString(this.getIntent().getStringExtra("loggedUser"));

        btnPlay = findViewById(R.id.menu_btnPlay);
        btnLdb = findViewById(R.id.menu_btnLdb);

        btnPlay.setOnClickListener(view -> {
            Intent i = new Intent(this, Game.class);
            i.putExtra("loggedUser", this.getIntent().getStringExtra("loggedUser"));
            startActivity(i);
        });

        btnLdb.setOnClickListener(view -> {
            Intent i = new Intent(this, Leaderboard.class);
            i.putExtra("loggedUser", this.getIntent().getStringExtra("loggedUser"));
            startActivity(i);
        });
    }
}