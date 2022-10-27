package com.example.minigame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button hold, click;
    int clickCounter = 0;
    int holdCounter = 0;
    Intent si = new Intent(this, Results.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hold = findViewById(R.id.Hold);
        click = findViewById(R.id.Click);

        click.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                clickCounter++;
            }
        });

        hold.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        holdCounter += 2;
    }

    public void Move(View view) {
        si.putExtra("clickResult", clickCounter);
        si.putExtra("holdResult", holdCounter);
        startActivityForResult(si, 19);
    }
}