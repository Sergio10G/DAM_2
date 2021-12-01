package com.example.tapgame.model;

public class User implements Comparable<User>{
    // ATTRIBUTES

    private int id;
    private String uname;
    private String pass;
    private long score;
    private float multiplier;
    private float clicker;

    // CONSTRUCTORS

    public User() {}

    public User(String uname, String pass) {
        this.id = -1;
        this.uname = uname;
        this.pass = pass;
        this.score = 0;
        this.multiplier = 1.0f;
        this.clicker = 0.0f;
        removeIllegalChars();
    }

    public User(int id, String uname, String pass) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.score = 0;
        this.multiplier = 1.0f;
        this.clicker = 0.0f;
        removeIllegalChars();
    }

    public User(int id, String uname, String pass, long score, float multiplier, float clicker) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.score = score;
        this.multiplier = multiplier;
        this.clicker = clicker;
    }

    // METHODS
    private void removeIllegalChars() {
        uname.replace(",", ".");
        pass.replace(",", ".");
    }

    @Override
    public String toString() {
        return    id + ","
                + uname + ","
                + pass + ","
                + score + ","
                + multiplier + ","
                + clicker;
    }

    public static User fromString(String userData) {
        String[] userValues = userData.split(",");

        int id = Integer.parseInt(userValues[0]);
        String uname = userValues[1];
        String pass = userValues[2];
        Long score = Long.parseLong(userValues[3]);
        float multiplier = Float.parseFloat(userValues[4]);
        float clicker = Float.parseFloat(userValues[5]);

        return new User(id, uname, pass, score, multiplier, clicker);
    }

    @Override
    public int compareTo(User u) {
        if (this.getScore() > u.getScore())
            return 1;
        else
            return -1;
    }

    public void incrementScore() {
        this.score += this.multiplier;
    }


    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public float getClicker() {
        return clicker;
    }

    public void setClicker(float clicker) {
        this.clicker = clicker;
    }
}
