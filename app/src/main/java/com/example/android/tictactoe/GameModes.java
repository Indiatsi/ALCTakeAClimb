package com.example.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameModes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_modes);
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(GameModes.this,HomePage.class);
        startActivity(intent);
    }

    public void openSinglePlayer(View view) {
        Intent intent = new Intent(GameModes.this,SinglePlayer.class);
        startActivity(intent);
    }

    public void openMultiPlayer(View view) {
        Intent intent = new Intent(GameModes.this,Multiplayer.class);
        startActivity(intent);
    }
}
