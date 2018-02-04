package com.example.tariq.getitdone;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.support.design.widget.TextInputLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    private DatabaseReference mDatabase;
    private static final String TAG = "MainActivity";
    private ProgressDialog mProgressDialog;
    private static final String REQUIRED = "Required";
    private int random;






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

    public static String tokenString()
    {
        final int LENGTH = 12;
        Random r = new Random();
        String output =  "";


        for(int i = 0; i < LENGTH; i++)
            output += Character.toChars(r.nextInt(90)+33)[0];

        return output;
    }

    public void doneClick(View v) {
        selectedRadioButton = radGroup.getCheckedRadioButtonId();
        radButton = (RadioButton) findViewById(selectedRadioButton);

        //receives integer type to call function for Alejandro
        radType = getType(radButton.getText().toString());
        task = (EditText) findViewById(R.id.taskInput);
        time = (EditText) findViewById(R.id.timeInput);
        Toast.makeText(getBaseContext(), task.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(), time.getText(), Toast.LENGTH_LONG).show();


        mDatabase = FirebaseDatabase.getInstance().getReference();
        taskString = task.getText().toString();
        timeString = time.getText().toString();

        random += 1;
        String s = Integer.toString(random);
        //int r = (int)Math.random();

        //char c = (char)r;
        mDatabase.child("tasks").child("task"+s).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

//                mProgressDialog.setMessage("Uploading Image ...");
//                mProgressDialog.show();


                Task task = new Task(taskString, timeString);
                Map<String, Object> postValues = task.toMap();

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/tasks/" + random, postValues);
                mDatabase.updateChildren(childUpdates);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "Write Error", databaseError.toException());

            }
        });

    }


    public int getType(String switchButton){
        if (switchButton.compareTo("By") == 0){
            return 0;
        } else
            return 1;
    }


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

