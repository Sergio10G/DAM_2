package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.tapgame.fragment.UserDataView;
import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;

public class Menu extends AppCompatActivity {
    User loggedUser;
    Button btnPlay, btnLdb;
    FragmentContainerView fcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize the logged user
        int loggedId = this.getIntent().getIntExtra("loggedId", 0);
        loggedUser = Database.getUserById(loggedId);

        // Initialize views
        btnPlay = findViewById(R.id.menu_btnPlay);
        btnLdb = findViewById(R.id.menu_btnLdb);
        fcv = findViewById(R.id.menu_fcv);

        // Add button listeners.
        // This one launches the game activity.
        btnPlay.setOnClickListener(view -> {
            Intent i = new Intent(this, Game.class);
            i.putExtra("loggedId", loggedId);
            startActivity(i);
        });

        // This one launches the leaderboard activity.
        btnLdb.setOnClickListener(view -> {
            Intent i = new Intent(this, Leaderboard.class);
            i.putExtra("loggedId", loggedId);
            startActivity(i);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Load the user data fragment each time the activity resumes, so if some value has changed,
        // it is updated.
        loggedUser = Database.getUserById(loggedUser.getId());

        super.onPostResume();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.menu_fcv, UserDataView.newInstance(loggedUser.getUname(),
                (int) loggedUser.getScore(),
                loggedUser.getMultiplier(),
                loggedUser.getClicker()), null)
                .addToBackStack(null)
                .commit();
    }
}