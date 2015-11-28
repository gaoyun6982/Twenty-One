package com.android.gaoyun.twenty_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends ActionBarActivity {

    Game twentyOne = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        TextView headText = (TextView) findViewById(R.id.headText);
        TextView gameText = (TextView) findViewById(R.id.gameText);

        Button leftButton = (Button) findViewById(R.id.buttonLeft);
        Button rightButton = (Button) findViewById(R.id.buttonRight);


        headText.setText("Hello! Let's play!");
        gameText.setText("");
        leftButton.setText("Add card");
        rightButton.setText("Ok, enough");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    public void leftButtonClick(View view) {

        TextView gameText = (TextView) findViewById(R.id.gameText);

        if (twentyOne.play){
            gameText.setText(twentyOne.playerTurn());
            if (!twentyOne.play) partOver();
        }
        else {

            newPart();
            gameText.setText("");
            gameText.setText(twentyOne.playerTurn());

        }


    }

    public void rightButtonClick(View view) {

        TextView gameText = (TextView) findViewById(R.id.gameText);

        if (twentyOne.play) {
            gameText.setText(twentyOne.croupierGame());
            partOver();
        } else {
            gameOver();
            gameText.setText("");

        }
    }

    public void partOver() {

        Button leftButton = (Button) findViewById(R.id.buttonLeft);
        Button rightButton = (Button) findViewById(R.id.buttonRight);
        TextView headText = (TextView) findViewById(R.id.headText);

        leftButton.setText("New Game");
        rightButton.setText("Game Over");
        headText.setText("PART OVER");

    }

    public void gameOver(){

        Button leftButton = (Button) findViewById(R.id.buttonLeft);
        Button rightButton = (Button) findViewById(R.id.buttonRight);
        TextView headText = (TextView) findViewById(R.id.headText);

        leftButton.setClickable(false);
        rightButton.setClickable(false);
        headText.setText("GAME OVER.");

    }

    public void newPart(){

        Button leftButton = (Button) findViewById(R.id.buttonLeft);
        Button rightButton = (Button) findViewById(R.id.buttonRight);
        TextView headText = (TextView) findViewById(R.id.headText);

        leftButton.setText("Add card");
        rightButton.setText("Ok, enough");
        headText.setText("Let's play!");

        twentyOne.newPart();

    }

    public void aboutClick(MenuItem item) {

        Intent about = new Intent(GameActivity.this, AboutActivity.class);
        startActivity(about);

    }
}
