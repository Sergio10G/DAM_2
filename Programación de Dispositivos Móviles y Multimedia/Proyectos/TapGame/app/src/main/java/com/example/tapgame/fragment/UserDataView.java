package com.example.tapgame.fragment;

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

    TextView txtUname, txtScore, txtMultiplier, txtClicker;

    public UserDataView() {
        // Required empty public constructor
    }

    public static UserDataView newInstance(String uname, int score, float multiplier, float clicker) {
        UserDataView fragment = new UserDataView();
        Bundle args = new Bundle();
        args.putString("uname", uname);
        args.putInt("score", score);
        args.putFloat("multiplier", multiplier);
        args.putFloat("clicker", clicker);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            uname = getArguments().getString("uname");
            score = getArguments().getInt("score");
            multiplier = getArguments().getFloat("multiplier");
            clicker = getArguments().getFloat("clicker");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View baseView = inflater.inflate(R.layout.fragment_user_data_view, container, false);
        txtUname = baseView.findViewById(R.id.userdataview_lblUname);
        txtScore = baseView.findViewById(R.id.userdataview_lblScore);
        txtMultiplier = baseView.findViewById(R.id.userdataview_lblMultiplier);
        txtClicker = baseView.findViewById(R.id.userdataview_lblClicker);

        txtUname.setText(uname);
        txtScore.setText(Integer.toString(score) + "PTS");
        txtMultiplier.setText("x " + String.format("%.2f", multiplier));
        txtClicker.setText("+ " + String.format("%.2f", clicker));

        return baseView;
    }


}