package com.example.tariq.getitdone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.support.design.widget.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button doneBut;
    RadioButton radioBy;
    RadioButton radioIn;
    RadioButton radButton;
    RadioGroup radGroup;
    String taskString, timeString;
    int selectedRadioButton;
    EditText task, time;
    int radType;
    int timeOption;

    TextInputLayout text_input_layout;
    ToggleButton timeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radGroup = (RadioGroup) findViewById(R.id.toggle);
        radType = 0;
        // timeOption at 0 is AM/HR, at 1 is PM/MIN
        timeOption = 0;
        timeButton = (ToggleButton) findViewById(R.id.timeButton);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTimeOption();
            }
        });
    }
    public void setTimeOption(){
        if (timeOption == 0){
            timeOption = 1;
        } else
            timeOption = 0;
    }
    public void doneClick(View v) {
        selectedRadioButton = radGroup.getCheckedRadioButtonId();
        radButton = (RadioButton) findViewById(selectedRadioButton);
        //receives integer type to call function for Alejandro
        radType = getType(radButton.getText().toString());
        task = (EditText) findViewById(R.id.taskInput);
        taskString = task.getText().toString();
        time = (EditText) findViewById(R.id.timeInput);
        timeString = time.getText().toString();
        Toast.makeText(getBaseContext(), task.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), time.getText(), Toast.LENGTH_LONG).show();
//        if(radType == 0)
//        {   //GET AM/PM FROM BUTTON
//            //timeOption =
//        } else if(radType == 1)
//        {
//
//        }



        //create a boolean method to check correct format


    }
    public int getType(String switchButton){
        if (switchButton.compareTo("By") == 0){
            return 0;
        } else
            return 1;
    }
//    public boolean checkFormat(String timeString, int inType){
//        if(radType == 0){
//            switch(timeString.length())
//            {
//                case 0:
//                    return false;
//                break;
//                case 1:
//                    if(!timeString.charAt(0).isNumeric())
//                        return false;
//                    break;
//                case 2:
//                    try {
//                        int temp = Integer.parseInt(timeString);
//                        if(temp > 13)
//                            return false;
//                    }
//                    catch(NumberFormatException ex)
//                    {
//                        return false;
//                    }
//                    break;
//                case 3:
//                    return false;
//                break;
//                case 4:
//                    if(timeString.charAt(1) != ':')
//                        return false;
//                    break;
//                case 5:
//                    if(timeString.charAt(2) != ':')
//                        return false;
//                    break;
//            }
//
//        }
//        else {
//            try{
//                int temp = Integer.parseInt(timeString);
//                if()
//            }
//            catch (NumberFormatException ex)
//            {
//                return false;
//            }
//        }
//
//    }

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
                if (checked) {
                    timeButton.setText("AM");
                    text_input_layout.setHint("Hour:Minute");
                    timeButton.setTextOn("AM");
                    timeButton.setTextOff("PM");
                }
                break;
            case R.id.radioIn:
                if (checked)
                {
                    timeButton.setText("HR");
                    text_input_layout.setHint("Hours");
                timeButton.setTextOn("HR");
                timeButton.setTextOff("MIN");}
                break;
        }
    }
}