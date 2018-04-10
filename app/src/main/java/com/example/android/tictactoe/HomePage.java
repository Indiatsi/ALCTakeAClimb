package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button btnGameModes = findViewById(R.id.choose_game_mode);
        btnGameModes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,GameModes.class);
                startActivity(intent);
            }
        });
    }

    public void openSettings(View view) {
        Intent intent = new Intent(HomePage.this,Settings.class);
        startActivity(intent);
    }

    public void openAbout(View view) {
        Intent intent = new Intent(HomePage.this,About.class);
        startActivity(intent);
    }

    public void openGameModes(View view)
    {
        Intent intent = new Intent(HomePage.this,GameModes.class);
        startActivity(intent);
    }
}

//TODO: Find out if continue button is appropriate
