package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;

public class ColorPicker extends AppCompatActivity {
    User loggedUser;
    SeekBar barRed, barGreen, barBlue;
    Button btnSet;
    TextView txtPreview;
    int redVal, greenVal, blueVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        // Initialize the logged user
        int loggedId = this.getIntent().getIntExtra("loggedId", 0);
        loggedUser = Database.getUserById(loggedId);

        // Vars that will hold color values, from 0 to 255
        redVal = 0;
        greenVal = 0;
        blueVal = 0;

        barRed = findViewById(R.id.color_barRed);
        barGreen = findViewById(R.id.color_barGreen);
        barBlue = findViewById(R.id.color_barBlue);
        btnSet = findViewById(R.id.color_btnSet);
        txtPreview = findViewById(R.id.color_txtPreview);

        // Events: These will define what happens when any of the seekBars' value is changed.
        // It will store the color value and update the preview.
        barRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redVal = 255 * i / 100;
                updatePreviewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        barGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                greenVal = 255 * i / 100;
                updatePreviewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        barBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blueVal = 255 * i / 100;
                updatePreviewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // This button will set the users' color to the one picked, and then it will save the
        // changes in the db. Finally, it will send a toast to the user.
        btnSet.setOnClickListener(view -> {
            loggedUser.setColor(rgbToHex());
            Database.saveUser(loggedUser);
            Toast.makeText(this, "Color saved...", Toast.LENGTH_SHORT).show();
        });
    }

    // Updates the background color of the textView that acts as a color preview.
    private void updatePreviewColor() {
        txtPreview.setBackgroundColor(Color.parseColor("#" + rgbToHex()));
    }

    // Gets all color values, turns them into hex, and returns them all together.
    private String rgbToHex() {
        String r = String.format("%02X", (0xFF & redVal));
        String g = String.format("%02X", (0xFF & greenVal));
        String b = String.format("%02X", (0xFF & blueVal));
        return r + g + b;
    }
}