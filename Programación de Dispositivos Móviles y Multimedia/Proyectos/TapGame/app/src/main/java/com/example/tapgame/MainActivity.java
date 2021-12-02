package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;
import com.google.firebase.database.DataSnapshot;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Main activity. All it does is load the database and launch the login activity.
        Database.connect();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}