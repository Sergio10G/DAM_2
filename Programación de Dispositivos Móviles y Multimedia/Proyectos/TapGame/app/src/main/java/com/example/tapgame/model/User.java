package com.example.tapgame.model;

public class User {
    // ATTRIBUTES

    private int id;
    private String uname;
    private String pass;
    private int score;
    private float multiplier;

    // CONSTRUCTORS

    public User(int id, String uname, String pass) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.score = 0;
        this.multiplier = 1.0f;
    }

    // METHODS

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                ", score=" + score +
                '}';
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }
}
