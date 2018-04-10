package com.example.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Settings extends AppCompatActivity {

    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initializa checkBox.
        checkBoxOne = findViewById(R.id.check_box_one);
        checkBoxTwo = findViewById(R.id.check_box_two);
        checkBoxThree = findViewById(R.id.check_box_three);
    }

    public void goBack(View view)
    {
        Intent intent = new Intent(Settings.this,HomePage.class);
        startActivity(intent);
    }

    public void chooseBoard(View view){
        if (checkBoxOne.isChecked()) {
            checkBoxOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Settings.this, Play.class);
                    startActivity(intent);
                }
            });
        } else if (checkBoxTwo.isChecked()){
            checkBoxTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Settings.this,FourbyFour.class);
                    startActivity(intent);
                }
            });
        } else if (checkBoxThree.isChecked()){
            checkBoxThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Settings.this,FivebyFive.class);
                    startActivity(intent);
                }
            });
        }

    }

}

//TODO: Work on size settings of the board
