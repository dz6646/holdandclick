package com.example.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    Intent gi;

    int clickResult;
    int holdResult;
    int flag;

    TextView tv ;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        gi = getIntent();
        tv = findViewById(R.id.textView);
        clickResult = gi.getIntExtra("clickResult", 0);
        holdResult = gi.getIntExtra("holdResult", 0);
        if(clickResult == holdResult)
        {
            flag = 3;
        }
        else if(clickResult > holdResult)
        {
            flag = 1;
        }

        else
        {
            flag = 2;
        }
        if(flag != 3) {
            tv.setText("Player 1 is the clicking player while player 2 is the holding player\n\n" +
                    "**Player 1** Click Result was: " + clickResult + "\n**Player 2** Hold Result was: " + holdResult +
                    "\nThe winner is: Player " + flag);
        }
        else
        {
            tv.setText("Player 1 is the clicking player while player 2 is the holding player\n\n" +
                    "**Player 1** Click Result was: " + clickResult + "\n**Player 2** Hold Result was: " + holdResult +
                    "\nIt ended with a tie !");
        }
    }

    public void returnToMain(View view) {
        gi.putExtra("click", 0);
        gi.putExtra("hold", 0);

        setResult(RESULT_OK, gi);
        finish();
    }

    public void onBackPressed() {
        gi.putExtra("click", 0);
        gi.putExtra("hold", 0);

        setResult(RESULT_OK, gi);
        finish();
    }
}