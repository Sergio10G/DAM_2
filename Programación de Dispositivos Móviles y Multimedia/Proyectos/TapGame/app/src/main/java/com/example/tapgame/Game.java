package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;

public class Game extends AppCompatActivity {
    User loggedUser;
    TextView lblScore, lblMultiplier, lblClicker;
    Button btnSave, btnMultiplierUp, btnClickerUp;
    ProgressBar pbarDecimals;
    int multiplierCost, clickerCost;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize the logged user
        int loggedId = this.getIntent().getIntExtra("loggedId", 0);
        loggedUser = Database.getUserById(loggedId);

        // Initialize all views
        lblScore = findViewById(R.id.game_lblScore);
        lblMultiplier = findViewById(R.id.game_lblMultiplier);
        lblClicker = findViewById(R.id.game_lblClicker);
        btnSave = findViewById(R.id.game_btnSave);
        btnMultiplierUp = findViewById(R.id.game_btnMultiplierUp);
        btnClickerUp = findViewById(R.id.game_btnClickerUp);
        pbarDecimals = findViewById(R.id.game_pbarDecimals);

        // Add some event listeners to the buttons
        btnSave.setOnClickListener(view -> {
            Database.saveUser(loggedUser);
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        });
        this.btnMultiplierUp.setOnClickListener(view -> {
            if (loggedUser.getScore() >= multiplierCost) {
                loggedUser.incrementMultiplier(multiplierCost);
                calculateMultiplierCost();
                updateViews();
            }
        });
        this.btnClickerUp.setOnClickListener(view -> {
            if (loggedUser.getScore() >= clickerCost) {
                loggedUser.incrementClicker(clickerCost);
                calculateClickerCost();
                updateViews();
            }
        });

        // Update all the views to their initial values
        calculateMultiplierCost();
        calculateClickerCost();
        updateViews();
        updateDecimalProgressBar(getTwoDecimals(loggedUser.getScore()));
        this.lblScore.setText(Integer.toString((int) loggedUser.getScore()));
        this.lblMultiplier.setText(prepareMultiplier());
        this.lblClicker.setText(prepareClicker());
    }

    // Return the 2 first decimals of a float number
    private int getTwoDecimals(float num) {
        if (num == 0)
            return 0;
        // This is kind of dirty, but it does it's job
        num += 0.000001;
        String numStr = Float.toString(num);
        int upperBound = 3;
        if (numStr.indexOf(".") + 3 > numStr.length()) {
            upperBound -= (numStr.indexOf(".") + 3 - numStr.length());
        }
        String decimals = numStr.substring(numStr.indexOf(".") + 1, numStr.indexOf(".") + upperBound);
        return Integer.parseInt(decimals);
    }

    // Increase the progress bar with bounds
    private void updateDecimalProgressBar(int progress){
        if (progress < 0) {
            progress = 0;
        }
        else if (progress > 100){
            progress = 100;
        }
        pbarDecimals.setProgress(progress);
    }

    // Calculate the price for the next upgrade
    private void calculateMultiplierCost() {
        this.multiplierCost = (int) (1000 * loggedUser.getMultiplier());
    }

    // Calculate the price for the next upgrade
    private void calculateClickerCost() {
        this.clickerCost = (int) (100 * loggedUser.getClicker());
    }

    // Update all the views
    @SuppressLint("SetTextI18n")
    private void updateViews() {
        lblMultiplier.setText(prepareMultiplier());
        lblClicker.setText(prepareClicker());
        btnMultiplierUp.setText(multiplierCost + "PTS");
        btnClickerUp.setText(clickerCost + "PTS");
        lblScore.setText(Integer.toString((int) loggedUser.getScore()));
    }

    // Formats the multiplier value to show it on it's textView (adds spaces in between)
    public String prepareMultiplier() {
        String multiplierVal = String.format("%.2f", loggedUser.getMultiplier());
        StringBuilder multiplierText = new StringBuilder("x ");
        for (int i = 0; i < multiplierVal.length(); i++) {
            multiplierText.append(multiplierVal.charAt(i));
            if (i != multiplierVal.length() - 1)
                multiplierText.append(" ");
        }
        return multiplierText.toString();
    }

    // Formats the clicker value to show it on it's textView (adds spaces in between)
    public String prepareClicker() {
        String clickerVal = String.format("%.2f", loggedUser.getClicker());
        StringBuilder clickerText = new StringBuilder("+ ");
        for (int i = 0; i < clickerVal.length(); i++) {
            clickerText.append(clickerVal.charAt(i));
            clickerText.append(" ");
        }
        return clickerText.toString();
    }

    // Routine that executes when the screen is tapped. Increments score and updates the views.
    public void screenTapped(View view) {
        loggedUser.incrementScore();

        updateDecimalProgressBar(getTwoDecimals(loggedUser.getScore()));
        calculateMultiplierCost();
        calculateClickerCost();
        updateViews();
    }
}