package com.example.tariq.getitdone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Tariq on 2/3/2018.
 */

public class schedulepage extends AppCompatActivity {

    Button but1;
    Button but2;
    TextView textView;







    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();

//Extract the data…
        String stuff = bundle.getString("stuff");
        textView = (TextView)findViewById(R.id.textView);
        textView.setText(stuff);
    }




}
