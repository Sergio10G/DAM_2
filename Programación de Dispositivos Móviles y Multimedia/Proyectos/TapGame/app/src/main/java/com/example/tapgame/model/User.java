package com.example.tapgame.model;

public class User implements Comparable<User>{
    // ATTRIBUTES
    private int id;
    private String uname;
    private String pass;
    private float score;
    private float multiplier;
    private float clicker;
    private String color;

    // CONSTRUCTORS
    public User() {}

    public User(int id, String uname, String pass) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.score = 0;
        this.multiplier = 1.0f;
        this.clicker = 1.0f;
        this.color = "000000";
    }

    // METHODS


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                ", score=" + score +
                ", multiplier=" + multiplier +
                ", clicker=" + clicker +
                ", color=" + color +
                '}';
    }

    // Compare a user to another one. It won't be possible to use it with streams because
    // API level 22 btw
    @Override
    public int compareTo(User u) {
        if (this.getScore() > u.getScore())
            return 1;
        return -1;
    }

    // Increment user score. It is calculated like so: NextScore = score + (clicker * multiplier)
    public void incrementScore() {
        this.score += (this.clicker * this.multiplier);
    }

    // Increments multiplier and deduces the cost from user score
    public void incrementMultiplier(int cost) {
        this.score -= cost;
        this.multiplier += 0.5;
    }

    // Increments clicker and deduces the cost from user score
    public void incrementClicker(int cost) {
        this.score -= cost;
        this.clicker += 1.1;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
