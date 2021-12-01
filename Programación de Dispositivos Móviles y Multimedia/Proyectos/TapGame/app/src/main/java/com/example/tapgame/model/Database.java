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

    public static void connect() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://tapgame-67136-default-rtdb.europe-west1.firebasedatabase.app/");
        getUsers();
    }

    public static boolean userExists(User user) {
        if (firebaseDatabase == null || users == null)
            connect();

        for (User usr : users) {
            if(usr.getUname().equals(user.getUname())
                    && user.getPass().equals(user.getPass())) {
                return true;
            }
        }
        return false;
    }

    public static void saveUser(User user) {
        if (firebaseDatabase == null)
            connect();
        DatabaseReference myRef = firebaseDatabase.getReference("Users")
                .child(Integer.toString(user.getId()));
        myRef.setValue(user);
        Log.i(TAG, "User data saved from (" + user.getId() + ") " + user.getUname());
    }

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
