package com.example.elbhwashy.educationalapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    private int score1, score2, score3, score4, score5,score6, score7, score8,  totalScore;
    private boolean checked1, checked2, checked3,checked4, checked7,checked8;
    private String anwser6 ,anwser5;
    //@BindView(R.id.button51)
    CheckBox CheckBox1;
    CheckBox CheckBox2;
    CheckBox CheckBox3;
    CheckBox CheckBox4;
    CheckBox CheckBox5;
    CheckBox CheckBox6;
    CheckBox CheckBox7;
    CheckBox CheckBox8;

    EditText EditTextQ5;
    EditText EditTextQ6;

    RadioGroup RadioGroup1;
    RadioGroup RadioGroup2;
    RadioGroup RadioGroup3;
    RadioGroup RadioGroup4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
    }

    public void onClickQ1(View view) {

         checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Q1_An1:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.Q1_An2:
                if (checked1) {
                    score1 = 10;
                    break;
                }
            case R.id.Q1_An3:
                if (checked1) {
                    score1 = 0;
                    break;
                }
            case R.id.Q1_An4:
                if (checked1) {
                    score1 = 0;
                    break;
                }
        }
    }

    public void onClickQ2(View view) {

        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Q2_An1:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.Q2_An2:
                if (checked2) {
                    score2 = 0;
                    break;
                }
            case R.id.Q2_An3:
                if (checked2) {
                    score2 = 10;
                    break;
                }
            case R.id.Q2_An4:
                if (checked2) {
                    score2 = 0;
                    break;
                }
        }
    }
    public void onClickQ3(View view) {
        CheckBox1 = (CheckBox) findViewById(R.id.Q3_An1);
        CheckBox2 = (CheckBox) findViewById(R.id.Q3_An2);
        CheckBox3 = (CheckBox) findViewById(R.id.Q3_An3);
        CheckBox4 = (CheckBox) findViewById(R.id.Q3_An4);
        checked3 = CheckBox1.isChecked() || CheckBox2.isChecked() || CheckBox3.isChecked() || CheckBox4.isChecked();
        score3 = 0;
        if(CheckBox1.isChecked()) {
            score3 += 10;
        }
        if(CheckBox2.isChecked()) {
            score3 += 10;
        }
        if(CheckBox3.isChecked()) {
            score3 += -10;
        }
        if(CheckBox4.isChecked()) {
            score3 += -10;
        }
        if (score3 < 0 ) {
            score3 = 0;

        }
    }

    public void onClickQ4(View view) {
        CheckBox5 = (CheckBox) findViewById(R.id.Q4_An1);
        CheckBox6 = (CheckBox) findViewById(R.id.Q4_An2);
        CheckBox7 = (CheckBox) findViewById(R.id.Q4_An3);
        CheckBox8 = (CheckBox) findViewById(R.id.Q4_An4);
        checked4 = CheckBox5.isChecked() || CheckBox6.isChecked() || CheckBox7.isChecked() || CheckBox8.isChecked();
        score4 = 0;
        if(CheckBox5.isChecked()) {
            score4 += -10;
        }
        if(CheckBox6.isChecked()) {
            score4 += 10;
        }
        if(CheckBox7.isChecked()) {
            score4 += 10;
        }
        if(CheckBox8.isChecked()) {
            score4 += -10;
        }

        if ( score4 < 0) {
            score4 = 0;

        }
    }
    public void onClickQ7(View view) {

        checked7 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Q7_An1:
                if (checked7) {
                    score7 = 10;
                    break;
                }
            case R.id.Q7_An2:
                if (checked7) {
                    score7 = 0;
                    break;
                }
            }
    }
    public void onClickQ8(View view) {

        checked8 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Q8_An1:
                if (checked8) {
                    score8 = 0;
                    break;
                }
            case R.id.Q8_An2:
                if (checked8) {
                    score8 = 10;
                    break;
                }

        }
    }


    public void submitQuiz(View view) {
        EditTextQ5 = (EditText) findViewById(R.id.Q5_An1);
        EditTextQ6 = (EditText) findViewById(R.id.Q6_An1);
        anwser5 = EditTextQ5.getText().toString();
        anwser6 = EditTextQ6.getText().toString();
        if(checked1 && checked2 && checked3 && checked4 && !anwser5.equals("") && !anwser6.equals("")&& checked7&& checked8 ) {

            // count question 5 ,6
            if(anwser5.toLowerCase().equals("2") && anwser6.toLowerCase().equals("20" )) {
                score5 = 10;
                score6 = 10;
            }
            else {
                score5 = 0;
                score6 = 0;
            }






            totalScore = score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 ;
            String anwser = createOrderSummary(totalScore);
            displayMessage(anwser);
        }
        else {
            String anwser = "Make Sure You Answer all Q";
            displayMessage(anwser);
        }
    }
    private String createOrderSummary(int score) {
        String scoreMessage = "your score is :" + score + "  (" +"%"+(score*100)/100 +" )";

        return scoreMessage;
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.quizScore);
        orderSummaryTextView.setText(message);
    }

    public void onClickReset(View view) {
        EditTextQ5 = (EditText) findViewById(R.id.Q5_An1);
        EditTextQ6 = (EditText) findViewById(R.id.Q6_An1);
        RadioGroup1 = (RadioGroup) findViewById(R.id.radio_Q1);
        RadioGroup2 = (RadioGroup) findViewById(R.id.radio_Q2);
        RadioGroup3 = (RadioGroup) findViewById(R.id.radio_Q7);
        RadioGroup4 = (RadioGroup) findViewById(R.id.radio_Q8);
        uncheckRadioGroup(RadioGroup1);
        uncheckRadioGroup(RadioGroup2);
        uncheckRadioGroup(RadioGroup3);
        uncheckRadioGroup(RadioGroup4);


        EditTextQ5.setText("");
        EditTextQ6.setText("");



        CheckBox1 = (CheckBox) findViewById(R.id.Q3_An1);
        CheckBox2 = (CheckBox) findViewById(R.id.Q3_An2);
        CheckBox3 = (CheckBox) findViewById(R.id.Q3_An3);
        CheckBox4 = (CheckBox) findViewById(R.id.Q3_An4);
        CheckBox5 = (CheckBox) findViewById(R.id.Q4_An1);
        CheckBox6 = (CheckBox) findViewById(R.id.Q4_An2);
        CheckBox7 = (CheckBox) findViewById(R.id.Q4_An3);
        CheckBox8 = (CheckBox) findViewById(R.id.Q4_An4);
        CheckBox1.setChecked(false);
        CheckBox2.setChecked(false);
        CheckBox3.setChecked(false);
        CheckBox4.setChecked(false);
        CheckBox5.setChecked(false);
        CheckBox6.setChecked(false);
        CheckBox7.setChecked(false);
        CheckBox8.setChecked(false);
        checked3 = false;
        checked4 = false;
    }



    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }


}
