package com.example.android.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContinue = findViewById(R.id.continue_main);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEditTextValidation();

                Intent intent = new Intent(MainActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
    }

    public void checkEditTextValidation()
    {
        EditText name = findViewById(R.id.enter_your_name);
        String username = name.getText().toString();

        if (TextUtils.isEmpty(username)) {
            name.setError("Please enter your name");
            return;
        }
    }
}

//TODO: Add a working validation code