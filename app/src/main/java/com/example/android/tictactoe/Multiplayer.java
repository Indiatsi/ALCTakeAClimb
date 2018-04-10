package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Multiplayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
    }

    public void play(View view){
        CheckBox playerXCheckBox = findViewById(R.id.x_player_check_box);
        boolean isPlayerXChecked = playerXCheckBox.isChecked();

        CheckBox playerOChecked = findViewById(R.id.o_player_check_box);
        boolean isPlayerOChecked = playerOChecked.isChecked();

    }
}
