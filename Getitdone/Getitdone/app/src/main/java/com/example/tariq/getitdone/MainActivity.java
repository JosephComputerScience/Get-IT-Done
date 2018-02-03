package com.example.tariq.getitdone;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.support.design.widget.BottomNavigationView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radioBy;
    RadioButton radioIn;


    Button doneBut;
    RadioButton radBut;
    RadioGroup radGroup;
    String radType, taskString, timeString;
    int radioButton;
    EditText task, time;

    TextInputLayout text_input_layout;
    ToggleButton timeButton;
    public void onRadioButtonClicked(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        radioBy = (RadioButton) findViewById(R.id.radioBy);
        radioIn = (RadioButton) findViewById(R.id.radioIn);
        text_input_layout = (TextInputLayout) findViewById(R.id.text_input_layout);



        // Check which radio button was clicked
        // Need to fix logic to make button toggle once to get correct button text
        switch(view.getId()) {
            case R.id.radioBy:
                if (checked)
                    text_input_layout.setHint("Hour:Minute");
                timeButton.setTextOn("AM");
                timeButton.setTextOff("PM");
                    break;
            case R.id.radioIn:
                if (checked)
                    text_input_layout.setHint("Hours");
                    timeButton.setTextOn("HR");
                    timeButton.setTextOff("MIN");
                    break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radGroup = (RadioGroup) findViewById(R.id.toggle);
        radioButton = radGroup.getCheckedRadioButtonId();
        timeButton = (ToggleButton) findViewById(R.id.timeButton);
//        but.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                but.setTextOn("PM");
//            }
//        });
//        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_naviation)
    }

    public void doneClick(View v) {
        radioButton = radGroup.getCheckedRadioButtonId();
        radBut = (RadioButton) findViewById(radioButton);
        radType = radBut.getText().toString();
        task = (EditText) findViewById(R.id.taskInput);
        taskString = task.getText().toString();
        Toast.makeText(getBaseContext(), taskString, Toast.LENGTH_SHORT).show();

    }


}
