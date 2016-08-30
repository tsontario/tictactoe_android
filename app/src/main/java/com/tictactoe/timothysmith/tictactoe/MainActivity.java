package com.tictactoe.timothysmith.tictactoe;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CurrentPlayer currentPlayer;
    Button[][] gameBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentPlayer = CurrentPlayer.X;
        gameBoard = new Button[3][3];
        initializeGameBoard();
    }

    protected void turn(View view) {

        Button b = (Button) findViewById(view.getId());

        if (b.getText().equals("")) {
            b.setText(currentPlayer.toString());
            if (hasWinCondition()) {
                endGame();
            } else {
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        String toastString = "";
        if (currentPlayer == CurrentPlayer.X) {
            currentPlayer = CurrentPlayer.O;
            toastString = "Player 'O's Turn";
        }
        else {
            currentPlayer = CurrentPlayer.X;
            toastString = "Player 'X's Turn";
        }

        Toast.makeText(MainActivity.this, toastString, Toast.LENGTH_SHORT).show();
    }

    private boolean hasWinCondition() {
        return (checkRows() || checkCols() || checkDiags());
    }

    private boolean checkRows() {
        for (int i=0; i<3; i++) {
            if (gameBoard[i][0].getText().equals("")) {
                continue;
            }
            else if (gameBoard[i][0].getText().equals(gameBoard[i][1].getText()) &&
                    gameBoard[i][0].getText().equals(gameBoard[i][2].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCols() {
        for (int i=0; i<3; i++) {
            if (gameBoard[0][i].getText().equals("")) {
                continue;
            }
            else if (gameBoard[0][i].getText().equals(gameBoard[1][i].getText()) &&
                    gameBoard[0][i].getText().equals(gameBoard[2][i].getText())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiags() {
        if (gameBoard[1][1].getText().equals("")) {
            return false;
        }
        if (gameBoard[0][0].getText().equals(gameBoard[1][1].getText()) &&
                gameBoard[0][0].getText().equals(gameBoard[2][2].getText())) {

            return true;
        }
        else if (gameBoard[0][2].getText().equals(gameBoard[1][1].getText()) &&
                gameBoard[0][2].getText().equals(gameBoard[2][0].getText())) {
            return true;
        }

        return false;
    }

    private void endGame() {
        System.exit(1);
    }

    private void initializeGameBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                String b = "button" + ((i*3)+j);  // Get Button ID #
                gameBoard[i][j] = (Button) findViewById(getResources().
                        getIdentifier(b, "id", getPackageName()));
            }
        }
    }
}
