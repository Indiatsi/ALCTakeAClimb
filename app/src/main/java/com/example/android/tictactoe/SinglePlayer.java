package com.example.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
    }

    public void goBack(View view) {
        Intent intent = new Intent(SinglePlayer.this,GameModes.class);
        startActivity(intent);
    }

    public void play(View view){
        CheckBox playerXCheckBox = findViewById(R.id.x_player_check_box);
        boolean isPlayerXChecked = playerXCheckBox.isChecked();

        CheckBox playerOChecked = findViewById(R.id.o_player_check_box);
        boolean isPlayerOChecked = playerOChecked.isChecked();

        Intent intent = new Intent(SinglePlayer.this,Play.class);
        startActivity(intent);
    }
}

//TODO: Find out how to choose a player
