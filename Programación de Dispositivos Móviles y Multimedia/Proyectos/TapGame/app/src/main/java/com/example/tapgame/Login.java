package com.example.tapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;

import com.example.tapgame.model.Database;
import com.example.tapgame.model.User;
import com.google.firebase.database.DataSnapshot;

public class Login extends AppCompatActivity {
    EditText txtUname, txtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        txtUname = findViewById(R.id.login_txtUname);
        txtPass = findViewById(R.id.login_txtPass);
        btnLogin = findViewById(R.id.login_btnLogin);

        // Login button. If the user does not exist, it creates it.
        btnLogin.setOnClickListener(view -> {
            String uname = txtUname.getText().toString();
            String pass = txtPass.getText().toString();
            User loggedUser = Database.getOrCreateUser(uname, pass);

            // Once the user is logged in, the game starts working and the user is taken to the
            // menu.
            Intent menu = new Intent(this, Menu.class);
            // It passes the users's id, to identify which user has logged in.
            menu.putExtra("loggedId", loggedUser.getId());
            startActivity(menu);
        });
    }


}