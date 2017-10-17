package com.example.android.countryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Score = 0;
    int Score1, Score2, Score3, Score4, Score5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submit(View view) {

        EditText nameField = (EditText) findViewById (R.id.name_view);
        String name = nameField.getText().toString();

        Question1(view);
        Question2(view);
        Question3(view);

        Score4 = 0;
        EditText countryField = (EditText) findViewById(R.id.question4_view);
        String q4 = countryField.getText().toString().trim();
        if (q4.equalsIgnoreCase("Russia")) {
            Score4 += 1;
        } else {
            Score4 = 0;
        }

        Question5(view);
        Score = Score1 + Score2 + Score3 + Score4 + Score5;

        //Toast message
        if (Score == 5) {
            String Message = "Excellent " + name + " :)";
            Message += "\n Your Score : " + Score + "/5 ";
            Toast toast = Toast.makeText(this, Message, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            String Message = name + ", Please try again :( ";
            Message += "\n Your Score : " + Score + "/5";
            Toast toast = Toast.makeText(this, Message, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void Question1(View view) {
        Score1 = 0;
        CheckBox firstChoice1 = (CheckBox) findViewById(R.id.Q_1_1);
        CheckBox secondChoice1 = (CheckBox) findViewById(R.id.Q_1_2);
        CheckBox thirdChoice1 = (CheckBox) findViewById(R.id.Q_1_3);

        if ((secondChoice1.isChecked() && thirdChoice1.isChecked()) && (!firstChoice1.isChecked())) {
            Score1 += 1;
        } else
            Score1 = 0;
    }

    public void Question2(View view) {
        Score2 = 0;
        RadioButton thirdChoice2 = (RadioButton) findViewById(R.id.Q_2_3);
        if (thirdChoice2.isChecked()) {
            Score2 += 1;
        } else
            Score2 = 0;
    }

    public void Question3(View view) {
        Score3 = 0;
        RadioButton thirdChoice3 = (RadioButton) findViewById(R.id.Q_3_3);
        if (thirdChoice3.isChecked()) {

            Score3 += 1;
        } else {
            Score3 = 0;
        }
    }

    public void Question5(View view) {
        Score5 = 0;
        RadioButton firstChoice5 = (RadioButton) findViewById(R.id.Q_5_1);
        if (firstChoice5.isChecked()) {
            Score5 += 1;
        } else {
            Score5 = 0;
        }

    }


    public void Reset(View view) {
        Score = 0;

        CheckBox cb1 = (CheckBox) findViewById(R.id.Q_1_1);
        cb1.setChecked(false);
        CheckBox cb2 = (CheckBox) findViewById(R.id.Q_1_2);
        cb2.setChecked(false);
        CheckBox cb3 = (CheckBox) findViewById(R.id.Q_1_3);
        cb3.setChecked(false);

        RadioGroup rq2 = (RadioGroup) findViewById(R.id.radio_group2);
        rq2.clearCheck();
        RadioGroup rq3 = (RadioGroup) findViewById(R.id.radio_group3);
        rq3.clearCheck();
        RadioGroup rq5 = (RadioGroup) findViewById(R.id.radio_group5);
        rq5.clearCheck();

        EditText q4 = (EditText) findViewById(R.id.question4_view);
        q4.setText("");
    }
}


