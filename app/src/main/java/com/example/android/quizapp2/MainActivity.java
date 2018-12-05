package com.example.android.quizapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declares and initializes a total score variable

    int totalScore = 0;

    // Declares and initializes a value 1 for when the answer is deemed correct

    int rightanswer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

// Tallies the score for the fill in the blank 1 question

    public void calculateFillInTheBlank() {
        EditText fillblankone = findViewById(R.id.fillblankone);
        String answerblankone = fillblankone.getText().toString();

        if (answerblankone.equals("lucky")) {

            totalScore += rightanswer;
        }
    }

    // Tallies the score for the checkbox question

    public void calculatecheckbox() {

        if (
                ((CheckBox) findViewById(R.id.piercecheck)).isChecked()

                        && ((CheckBox) findViewById(R.id.birdcheck)).isChecked()

                        && !((CheckBox) findViewById(R.id.perkinscheck)).isChecked()

                        && !((CheckBox) findViewById(R.id.delontecheck)).isChecked()

                ) {

            totalScore += rightanswer;
        }
    }

//Tallies the score for the Radio Button Question

    public void radiobuttonquestion() {

        if (
                ((RadioButton) findViewById(R.id.gordonRadio)).isChecked()

                        && !((RadioButton) findViewById(R.id.kyrieRadio)).isChecked()

                        && !((RadioButton) findViewById(R.id.marcusRadio)).isChecked()

                        && !((RadioButton) findViewById(R.id.jaysonRadio)).isChecked()
                ) {

            totalScore += rightanswer;
        }
    }

// Calculates the fill in the blank question 2

    public void calculateSecondFillInTheBlank() {
        EditText fillblanktwo = findViewById(R.id.fillblanktwo);
        String answerblanktwo = fillblanktwo.getText().toString();

        //Tallies score for fill in the blank 2 question

        if (answerblanktwo.equals("garden")) {

            totalScore += rightanswer;
        }
    }

    //Calculates the total score and displays a message about whether or not they passed the quiz

    public void submitanswers(View view) {
        calculateScore();

        displayScore();

    }

    //Calculate score method

    private void calculateScore() {

        calculateFillInTheBlank();
        calculatecheckbox();
        radiobuttonquestion();
        calculateSecondFillInTheBlank();

    }

    //Display score with toast messages method

    private void displayScore() {

        if (totalScore >= 3)

        {
            Toast.makeText(this, "Congratulations you passed with a score of " + totalScore + " out of 4 here is a lucky shamrock!", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Sorry your score of " + totalScore + " out of 4 does not exude Celtics Pride, try again!", Toast.LENGTH_LONG).show();
        }

    }

}