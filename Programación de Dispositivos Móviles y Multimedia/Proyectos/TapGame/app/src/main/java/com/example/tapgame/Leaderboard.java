package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard extends AppCompatActivity {
    User loggedUser;
    ListView lstLeaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // Initialize the listView
        this.lstLeaderboard = findViewById(R.id.leaderboard_lstLeaderboard);

        // Sort the users by myself because API 22 btw
        List<User> users = Database.getUsers();
        if (users.size() > 0) {
            List<User> usersSorted = new ArrayList<>();
            int initialSize = users.size();
            for (int i = 0; i < initialSize; i++) {
                User lowestScoreUser = users.get(0);
                for (int j = 0; j < users.size(); j++) {
                    if (lowestScoreUser.compareTo(users.get(j)) < 0) {
                        lowestScoreUser = users.get(j);
                    }
                }
                usersSorted.add(lowestScoreUser);
                users.remove(lowestScoreUser);
            }
            List<String> entries = new ArrayList<>();
            int pos = 1;
            for (User user : usersSorted) {
                String entry = "#" + pos + " " + user.getUname() + " - " + (int) user.getScore() + "PTS";
                entries.add(entry);
                pos++;
            }

            // Introduce the sorted list into an adapter, which then goes into the listView
            // to show the items.
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entries);
            lstLeaderboard.setAdapter(adapter);
        }

    }

}