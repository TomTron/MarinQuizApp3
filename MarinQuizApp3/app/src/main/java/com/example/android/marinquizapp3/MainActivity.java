package com.example.android.marinquizapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void gradeQuiz(View v) {
        int points = 0;
        // Retrieve the name of the user
        TextView nameField = (TextView)findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Retrieve the answer user picked for question 1
        RadioGroup radioGroupQ1 = (RadioGroup)findViewById(R.id.radioAnswer);
        int selectedButtonQ1 = radioGroupQ1.getCheckedRadioButtonId();
        RadioButton radioAnswerQ1 =  (RadioButton) findViewById(selectedButtonQ1);
        String answer1 = radioAnswerQ1.getText().toString();


        // Retrieve the answer user picked for question 2
        RadioGroup radioGroupQ2 = (RadioGroup)findViewById(R.id.radioAnswer2);
        int selectedButtonQ2 = radioGroupQ1.getCheckedRadioButtonId();
        RadioButton radioAnswerQ2 =  (RadioButton) findViewById(selectedButtonQ2);
        String answer2 = radioAnswerQ1.getText().toString();


        // Retrieve the answer user picked for question 3
        CheckBox checkBoxTrue = (CheckBox)findViewById(R.id.check_box_true);
        CheckBox checkBoxFalse = (CheckBox)findViewById(R.id.check_box_false);
        String answer3 = "";
        if(checkBoxTrue.isChecked())
            answer3 += checkBoxTrue.getText().toString();
        if(checkBoxFalse.isChecked())
            answer3 += checkBoxFalse.getText().toString();


        // Retrieve the answer user picked for question 4
        RatingBar rBar = (RatingBar) findViewById(R.id.rtbHighScore);
        float rating = rBar.getRating();

        // Retrieve correct answers:

        String correctAnswer1 = getResources().getString(R.string.Q1correct);
        String correctAnswer2 = getResources().getString(R.string.Q2correct);
        String correctAnswer3 = getResources().getString(R.string.Q3correct);

        // Check if answer on Q1 is correct
        if(answer1.equals(correctAnswer1))
            points++;
        else
            points--;

        // Check if answer on Q2 is correct
        if(answer2.equals(correctAnswer2))
            points++;
        else
            points--;

        // Check if answer on Q3 is correct
        if(answer3.equals(correctAnswer3))
            points++;
        else
            points--;

        // Check if answer on Q4 is correct - if user picked any rating it's correct, if he didn't answer it's incorrect
        if(rating > 0)
            points++;
        else
            points--;

        String message = name + ", you scored " + points + " points!";

        toastMsg(message);
    }

}
