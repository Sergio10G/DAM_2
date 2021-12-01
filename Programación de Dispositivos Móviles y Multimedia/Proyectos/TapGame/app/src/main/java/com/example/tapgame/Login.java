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

        txtUname = findViewById(R.id.login_txtUname);
        txtPass = findViewById(R.id.login_txtPass);
        btnLogin = findViewById(R.id.login_btnLogin);

        btnLogin.setOnClickListener(view -> {
            String uname = txtUname.getText().toString();
            String pass = txtPass.getText().toString();
            User loggedUser = Database.getOrCreateUser(uname, pass);

            Intent menu = new Intent(this, Menu.class);
            menu.putExtra("loggedId", loggedUser.getId());
            startActivity(menu);
        });
    }


}