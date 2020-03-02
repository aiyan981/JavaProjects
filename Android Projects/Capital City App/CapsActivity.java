package com.example.user.caps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score = 0;
    private int qNum = 1;

    private void ask(){
        this.game = new Game();
        this.question = game.qa();
        this.answer = game.getAnswer();

        ((TextView) findViewById(R.id.question)).setText(this.question);
        ((TextView) findViewById(R.id.qNum)).setText(this.qNum);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);

        ask();
//        ((TextView) findViewById(R.id.question)).setText(this.question);
//        ((TextView) findViewById(R.id.qNum)).setText(this.qNum);
    }

    public void onDone(View v){
        if (this.qNum == 10){
            finish();
        }
        else{
            ask();

            String userA = ((EditText) findViewById(R.id.answer)).getText().toString().toUpperCase();
            if (userA.equalsIgnoreCase(this.answer)){
                this.score++;
            }

            String s = ((TextView) findViewById(R.id.log)).getText().toString();
            ((TextView) findViewById(R.id.log)).setText(s + "Q# " + this.qNum + ": " +
                    this.question + "\n Your answer: " + userA + "\n" +
                    "Correct Answer: " + this.answer + "\n \n ");

            this.qNum++;
            if (this.qNum == 10){
                System.out.println("Game Over");
            }
            else{
                ((TextView) findViewById(R.id.score)).setText(this.score);
                ((TextView) findViewById(R.id.qNum)).setText(this.qNum);
            }
        }
    }

//    public static void main(String[] args) {
//        Game game = new Game();
//        System.out.println(game.qa());
//        System.out.println(game.getAnswer());
//    }
}
