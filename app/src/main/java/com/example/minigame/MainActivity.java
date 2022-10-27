package com.example.minigame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button hold, click;
    int clickCounter = 0;
    int holdCounter = 0;
    Intent si;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        si = new Intent(this, Results.class);
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

        hold.setOnLongClickListener(this);
    }

    @Override
    public void onActivityResult(int source, int good, @Nullable Intent data_back) {

        super.onActivityResult(source, good, data_back);
        if(data_back != null)
        {
            clickCounter = data_back.getIntExtra("click", 0);
            holdCounter = data_back.getIntExtra("hold", 0);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        holdCounter += 2;
        return false;
    }

    public void pass2Res(View view) {
        si.putExtra("clickResult", clickCounter);
        si.putExtra("holdResult", holdCounter);
        startActivityForResult(si, 19);
    }

}