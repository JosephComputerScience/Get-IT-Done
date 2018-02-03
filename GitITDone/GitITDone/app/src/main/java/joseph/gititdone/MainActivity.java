package joseph.gititdone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button doneBut;
    RadioButton radBut;
    RadioGroup radGroup;
    String radButString, task, time;
    int radioButton;
    //EditText task, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radGroup = (RadioGroup) findViewById(R.id.toggle);
        radioButton = radGroup.getCheckedRadioButtonId();

    }
    public void doneClick(View v) {
        radioButton = radGroup.getCheckedRadioButtonId();
        radBut = (RadioButton) findViewById(radioButton);
        radButString = radBut.getText().toString();
        task = 

    }

}
