package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    int score;

    TextView lblScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = 0;

        this.lblScore = findViewById(R.id.game_lblScore);
    }

    public void screenTapped(View view) {
        score++;

        lblScore.setText(Integer.toString(score));
    }
}