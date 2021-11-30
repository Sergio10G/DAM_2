package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    long score;
    TextView lblScore;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = 0;

        this.lblScore = findViewById(R.id.game_lblScore);
        this.btnSave = findViewById(R.id.game_btnSave);
    }

    public void screenTapped(View view) {
        score++;

        lblScore.setText(Long.toString(score));
    }
}