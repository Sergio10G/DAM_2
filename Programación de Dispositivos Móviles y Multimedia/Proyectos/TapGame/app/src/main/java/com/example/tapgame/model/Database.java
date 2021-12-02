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
    private static final String TAG = "DB";
    private static FirebaseDatabase firebaseDatabase;
    private static List<User> users = new ArrayList<User>();

    // METHODS

    // This is the main database reading function. It will read all users to the list "users", and
    // it will also return it.
    public static List<User> getUsers() {
        DatabaseReference myRef = firebaseDatabase.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<User> extractedUsers = new ArrayList<User>();
                Log.i(TAG, "Extracting data from db...");

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    User u = child.getValue(User.class);
                    extractedUsers.add(u);
                }

                users = extractedUsers;
                Log.i(TAG, "Users extracted: " + users.size());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read db.");
            }
        });
        return users;
    }

    // Get the firebase database instance
    public static void connect() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://tapgame-67136-default-rtdb.europe-west1.firebasedatabase.app/");
        getUsers();
    }

    // Save all data from an user on the db
    public static void saveUser(User user) {
        if (firebaseDatabase == null)
            connect();
        DatabaseReference myRef = firebaseDatabase.getReference("Users")
                .child(Integer.toString(user.getId()));
        myRef.setValue(user);
        Log.i(TAG, "User data saved from (" + user.getId() + ") " + user.getUname());
    }

    // Tries to find a user by name. If it does not exist, it creates a new one.
    public static User getOrCreateUser(String uname, String pass) {
        if (firebaseDatabase == null || users == null)
            connect();
        User user = getUserByUname(uname);
        if (user == null) {
            int id = getLastId() + 1;
            user = new User(id, uname, pass);
            saveUser(user);
        }
        return user;
    }

    // Gets the last id introduced in the db
    public static int getLastId() {
        if (firebaseDatabase == null || users == null)
            connect();
        if (users.size() == 0)
            return 0;
        System.out.println("Users loaded on id func: " + users.size());
        return users.get(users.size() - 1).getId();
    }

    // Gets a user by their name
    public static User getUserByUname(String uname) {
        if (firebaseDatabase == null)
            connect();
        users = getUsers();
        for (User user : users) {
            if (user.getUname().equals(uname))
                return user;
        }
        return null;
    }

    // Gets a user by their id
    public static User getUserById(int id) {
        if (firebaseDatabase == null)
            connect();
        users = getUsers();
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

}
