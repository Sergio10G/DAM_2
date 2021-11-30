package com.example.tapgame.model;

import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    // ATTRIBUTES
    private static FirebaseDatabase firebaseDatabase;
    private static List<User> users;

    // METHODS

    public static void connect() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://tapgame-67136-default-rtdb.europe-west1.firebasedatabase.app/");
        users = new ArrayList<User>();

        DatabaseReference myRef = firebaseDatabase.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Data extracted from db-------------------------");

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    int id = Integer.parseInt(child.getKey());
                    // Por alguna razón, si convertía los valores a un mapa de strings y strings
                    // daba error, así que he tenido que dejar los valores en Object y pasarlos
                    // por varias conversiones para que no de errores de tipo.
                    // Lo siento por esto que he escrito aquí abajo.
                    HashMap<String, Object> userValues = (HashMap<String, Object>) child.getValue();
                    String uname = userValues.get("uname").toString();
                    String pass = userValues.get("pass").toString();
                    long score = Long.parseLong(userValues.get("score").toString());
                    float multiplier = Float.parseFloat(userValues.get("multiplier").toString());
                    float clicker = Float.parseFloat(userValues.get("clicker").toString());

                    users.add(new User(id, uname, pass, score, multiplier, clicker));
                }

                System.out.println("Users loaded: " + users.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    public static void saveUser(User user) {
        if (firebaseDatabase == null)
            connect();
        DatabaseReference myRef = firebaseDatabase.getReference("Users")
                .child(Integer.toString(user.getId()));
        myRef.setValue(user);
    }

    public static User createAndSaveUser(String uname, String pass) {
        if (firebaseDatabase == null || users == null)
            connect();
        int id = getLastId();
        User user = new User(id, uname, pass);
        saveUser(user);
        return user;
    }

    public static List<User> getAllUsers() {
        if (firebaseDatabase == null || users == null)
            connect();
        return users;
    }

    public static int getLastId() {
        if (firebaseDatabase == null || users == null)
            connect();
        if (users.size() == 0)
            return 0;
        System.out.println("Users loaded on id func: " + users.size());
        return users.get(users.size() - 1).getId();
    }

    public static void changeValueByKey(User user, String key, Object value) {
        if (firebaseDatabase == null)
            connect();
        DatabaseReference myRef = firebaseDatabase.getReference("Users")
                .child(Integer.toString(user.getId()))
                .child(key);
        myRef.setValue(value);
    }

}
