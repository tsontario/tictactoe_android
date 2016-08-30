package com.tictactoe.timothysmith.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CurrentPlayer currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentPlayer = CurrentPlayer.X;
    }

    protected void turn(View view) {

        Button b = (Button) findViewById(view.getId());
        if (b.getText().equals("")) {
            b.setText(currentPlayer.toString());
            switchPlayer();
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
}
