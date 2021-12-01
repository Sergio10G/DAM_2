package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;

public class Game extends AppCompatActivity {

    User loggedUser;
    TextView lblScore;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        loggedUser = User.fromString(this.getIntent().getStringExtra("loggedUser"));

        this.lblScore = findViewById(R.id.game_lblScore);
        this.btnSave = findViewById(R.id.game_btnSave);

        this.btnSave.setOnClickListener(view -> Database.saveUser(loggedUser));

        this.lblScore.setText(Long.toString(loggedUser.getScore()));
    }

    public void screenTapped(View view) {
        loggedUser.incrementScore();

        lblScore.setText(Long.toString(loggedUser.getScore()));
    }
}