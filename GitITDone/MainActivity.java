package joseph.gititdone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button doneBut;
    RadioButton radBut;
    RadioGroup radGroup;
    String radButString;
    int radioButton;
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
    }

}
