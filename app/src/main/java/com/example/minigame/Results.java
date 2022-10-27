package com.example.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    Intent gi = getIntent();
    int clickResult;
    int holdResult;
    int flag;
    TextView tv = findViewById(R.id.textView);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        clickResult = gi.getIntExtra("clickResult", 0);
        holdResult = gi.getIntExtra("holdResult", 0);
        if(clickResult > holdResult)
        {
            flag = 1;
        }
        else
        {
            flag = 2;
        }
        tv.setText("Player 1 is the clicking player while player 2 is the holding player\n" +
                "Click Result was: " + clickResult + "\nHold Result was: " + holdResult +
                "\nThe winner is: Player " + flag);

    }
}