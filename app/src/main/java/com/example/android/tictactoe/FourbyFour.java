package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FourbyFour extends AppCompatActivity {
    int c[][];
    int i, j, k = 0;
    Button b[][];
    TextView textView;
    AI ai;

    private TicTacToeGame mGame;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        setBoard();

        mGame = new TicTacToeGame();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add("New Game");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        setBoard();
        return true;
    }

    public void clearBoard(View view) {
        mGame.resetBoard();
    }


    // Set up the game board.
    private void setBoard() {
        ai = new AI();
        b = new Button[5][5];
        c = new int[5][5];


        textView = findViewById(R.id.dialogue);


        b[1][4] = findViewById(R.id.button_one);
        b[1][3] = findViewById(R.id.button_two);
        b[1][2] = findViewById(R.id.button_three);
        b[1][1] = findViewById(R.id.button_four);


        b[2][4] = findViewById(R.id.button_five);
        b[2][3] = findViewById(R.id.button_six);
        b[2][2] = findViewById(R.id.button_seven);
        b[2][1] = findViewById(R.id.button_eight);


        b[3][4] = findViewById(R.id.button_nine);
        b[3][3] = findViewById(R.id.button_ten);
        b[3][2] = findViewById(R.id.button_eleven);
        b[3][1] = findViewById(R.id.button_twelve);

        b[4][4] = findViewById(R.id.button_thirteen);
        b[4][3] = findViewById(R.id.button_fourteen);
        b[4][2] = findViewById(R.id.button_fifteen);
        b[4][1] = findViewById(R.id.button_sixteen);


        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 4; j++)
                c[i][j] = 3;
        }

        // add the click listeners for each button
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 4; j++) {
                b[i][j].setOnClickListener(new MyClickListener(i, j));
                if(!b[i][j].isEnabled()) {
                    b[i][j].setText(" ");
                    b[i][j].setEnabled(true);
                }
            }
        }
    }


    class MyClickListener implements View.OnClickListener {
        int x;
        int y;


        public MyClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public void onClick(View view) {
            if (b[x][y].isEnabled()) {
                b[x][y].setEnabled(false);
                b[x][y].setBackgroundDrawable(getResources().getDrawable(R.drawable.o_player));
                c[x][y] = 0;
                textView.setText("");
                if (!checkBoard()) {
                    ai.takeTurn();
                }
            }
        }
    }

    private class AI {
        public void takeTurn() {
            if(c[1][1]==2 &&
                    ((c[1][2]==0 && c[1][3]==0 && c[1][4]==0) ||
                            (c[2][2]==0 && c[3][3]==0 && c[4][4]==0) ||
                            (c[2][1]==0 && c[3][1]==0) && c[4][1]==0)) {
                markSquare(1,1);
            } else if (c[1][2]==2 &&
                    ((c[2][2]==0 && c[3][2]==0 && c[4][2]==0) ||
                            (c[1][1]==0 && c[1][3]==0 && c[1][4]==0))) {
                markSquare(1,2);
            } else if(c[1][3]==2 &&
                    ((c[1][1]==0 && c[1][2]==0) && c[1][4]==0 ||
                            (c[2][3]==0 && c[3][3]==0 && c[4][3]==0))) {
                markSquare(1,3);
            } else if (c[1][4] == 2 &&
                    ((c[1][1]==0 && c[1][2]==0 && c[1][3]==0) ||
                        (c[2][3]==0 && c[3][2]==0 && c[4][1]==0) ||
                        (c[2][4] ==0 && c[3][4]==0 && c[4][4]==0))) {
                markSquare(1, 4);
            }
            else if(c[2][1]==2 &&
                    ((c[2][2]==0 && c[2][3]==0 && c[2][4]==0) ||
                            (c[1][1]==0 && c[3][1]==0 && c[4][1]==0))){
                markSquare(2,1);
            } else if(c[2][2]==2 &&
                    ((c[1][1]==0 && c[3][3]==0 && c[4][4]==0) ||
                            (c[1][2]==0 && c[3][2]==0 && c[4][2]==0) ||
                            (c[2][1]==0 && c[2][3]==0 && c[2][4]==0))) {
                markSquare(2,2);
            } else if(c[2][3]==2 &&
                    ((c[2][1]==0 && c[2][2]==0 && c[2][4]==0) ||
                            (c[1][3]==0 && c[3][3]==0 && c[4][3]==0) ||
                            (c[1][4]==0 && c[3][2]==0 && c[4][1]==0))) {
                markSquare(2,3);
            } else if (c[2][4]==2 &&
                    ((c[1][4]==0 && c[3][4]==0 && c[4][4]==0) ||
                            (c[2][1]==0 && c[2][2]==0 && c[2][3]==0))) {
                markSquare(2, 4);
            } else if(c[3][1]==2 &&
                    ((c[1][1]==0 && c[2][1]==0 && c[4][1]==0) ||
                            (c[3][2]==0 && c[3][3]==0 && c[3][4]==0))) {
                markSquare(3,1);
            } else if(c[3][2]==2 &&
                    ((c[1][2]==0 && c[2][2]==0 && c[4][2]==0) ||
                            (c[3][1]==0 && c[3][3]==0 && c[3][4]==0))) {
                markSquare(3,2);
            } else if (c[3][3]==2 &&
                    ((c[1][1]==0 && c[2][2]==0 && c[4][4]==0) ||
                            (c[1][3]==0 && c[2][3]==0 && c[4][3]==0) ||
                            (c[3][1]==0 && c[3][2]==0 && c[3][4]==0) ||
                            (c[1][1]==0 && c[2][2]==0 && c[4][4]==0))) {
                markSquare(3,3);
            } else if (c[3][4]==2 &&
                    ((c[1][4]==0 && c[2][4]==0 & c[4][4]==0) ||
                            (c[3][1]==0 && c[3][2]==0 && c[3][3]==0))) {
                markSquare(3, 4);
            } else if (c[4][1]==2 &&
                    ((c[1][1]==0 && c[2][1]==0 && c[3][1]==0) ||
                    (c[1][4]==0 && c[2][3]==0 && c[3][2]==0) ||
                            (c[4][2]==0 && c[4][3]==0 && c[4][4]==0))) {
                markSquare(4, 1);
            } else if (c[4][2]==2 &&
                    ((c[1][2]==0 && c[2][2]==0 && c[3][2]==0) ||
                            (c[4][1]==0 && c[4][3]==0 && c[4][4]==0))) {
                markSquare(4, 2);
            } else if (c[4][3]==2 &&
                    ((c[1][3]==0 && c[2][3]==0 && c[3][3]==0) ||
                            (c[4][1]==0 && c[4][2]==0 && c[4][4]==0))) {
                markSquare(4,3);
            } else if (c[4][4]==2 &&
                    ((c[1][4]==0 && c[2][4]==0 && c[3][4]==0) ||
                            (c[4][1]==0 && c[4][2]==0 && c[4][3]==0) ||
                            (c[1][1]==0 && c[2][2]==0 && c[3][3]==0))) {
                markSquare(4, 4);
            } else {
                Random rand = new Random();

                int a = rand.nextInt(4);
                int b = rand.nextInt(4);
                while(a==0 || b==0 || c[a][b]!=2) {
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);
                }
                markSquare(a,b);
            }
        }


        private void markSquare(int x, int y) {
            b[x][y].setEnabled(false);
            b[x][y].setBackgroundDrawable(getResources().getDrawable(R.drawable.x_player));
            c[x][y] = 1;
            checkBoard();
        }
    }


    // check the board to see if someone has won
    private boolean checkBoard() {
        boolean gameOver = false;
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0 && c[4][4]==0)
                || (c[1][4] == 0 && c[2][3] == 0 && c[3][2] == 0 && c[4][1] == 0)
                || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0 && c[4][2] == 0)
                || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0 && c[4][3] == 0)
                || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0 && c[1][4] == 0)
                || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0 && c[2][4] == 0)
                || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0 && c[3][4] == 0)
                || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0 && c[4][1] == 0)) {
            textView.setText("Game over. You win!");
            gameOver = true;
        } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1 && c[4][4] == 1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1 && c[4][2] == 1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1 && c[4][3] == 1)
                || (c[1][4] == 1 && c[2][4] == 1 && c[3][4] == 1 && c[4][4] == 1)
                || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1 && c[1][4] == 1)
                || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1 && c[2][4] == 1)
                || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1 && c[3][4] == 1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1 && c[4][1] == 1)) {
            textView.setText("Game over. You lost!");
            gameOver = true;
        } else {
            boolean empty = false;
            for(i=1; i<=3; i++) {
                for(j=1; j<=3; j++) {
                    if(c[i][j]==2) {
                        empty = true;
                        break;
                    }
                }
            }
            if(!empty) {
                gameOver = true;
                textView.setText("Game over. It's a draw!");
            }
        }
        return gameOver;
    }
}