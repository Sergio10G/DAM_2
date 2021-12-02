package com.example.tapgame.model;

public class UserListener {
    // This class is a wrapper for user that adds a change listener. The idea behind it is that
    // every time that the autoClicker increments the user's score, that change is listened
    // and the things done on change can be implemented wherever.
    private User user;
    private ChangeListener listener;

    public UserListener(User user) {
        this.user = user;
    }

    public void incrementScoreWithListener() {
        this.user.incrementScore();
        if (listener != null) listener.onChange();
    }

    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public interface ChangeListener {
        void onChange();
    }
}