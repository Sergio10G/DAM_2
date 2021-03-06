package com.example.tapgame.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tapgame.R;

public class UserDataView extends Fragment {
    private String uname;
    private int score;
    private float multiplier;
    private float clicker;
    private String color;
    private int colorInt;

    TextView txtUname, txtScore, txtMultiplier, txtClicker;

    public UserDataView() {
        // Required empty public constructor
    }

    // Creates a new fragment instance with all the values initialized.
    public static UserDataView newInstance(String uname, int score, float multiplier, float clicker, String color) {
        UserDataView fragment = new UserDataView();
        Bundle args = new Bundle();
        args.putString("uname", uname);
        args.putInt("score", score);
        args.putFloat("multiplier", multiplier);
        args.putFloat("clicker", clicker);
        args.putString("color", color);
        fragment.setArguments(args);
        return fragment;
    }

    // Get the parameters and save them.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            uname = getArguments().getString("uname");
            score = getArguments().getInt("score");
            multiplier = getArguments().getFloat("multiplier");
            clicker = getArguments().getFloat("clicker");
            color = getArguments().getString("color");
            colorInt = Color.parseColor("#" + color);
            System.out.println("Received color:" + color + " - " + colorInt);
        }


    }

    // Assing the views to the variables created, and initialize them with the values passed
    // as parameters.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_user_data_view, container, false);
        txtUname = baseView.findViewById(R.id.userdataview_lblUname);
        txtScore = baseView.findViewById(R.id.userdataview_lblScore);
        txtMultiplier = baseView.findViewById(R.id.userdataview_lblMultiplier);
        txtClicker = baseView.findViewById(R.id.userdataview_lblClicker);

        txtUname.setText(uname);
        txtUname.setTextColor(colorInt);
        txtScore.setText(score + "PTS");
        txtMultiplier.setText("x " + String.format("%.2f", multiplier));
        txtClicker.setText("+ " + String.format("%.2f", clicker));

        return baseView;
    }

}