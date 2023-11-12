package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button ansBtn, againBtn;
    TextView showAns;
    EditText getVal;
    RadioButton c2f, f2c;
    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = findViewById(R.id.ansBtn);
        againBtn = findViewById(R.id.againBtn);
        showAns = findViewById(R.id.showAns);
        getVal = findViewById(R.id.getValue);
        c2f = findViewById(R.id.c2f);
        f2c = findViewById(R.id.f2c);

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getVal.getText().toString().isEmpty()){
                    showAns.setText("Enter the temperature");
                }
                else {
                    x = Double.parseDouble(String.valueOf(getVal.getText()));
                    if (c2f.isChecked()){
                        x = (x*9/5)+32;
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(String.valueOf(x) + " Degree Fahrenheit");
                    }
                    else if (f2c.isChecked()){
                        x = (x-32)*5/9;
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        showAns.setText(String.valueOf(x) + " Degree Celsius");
                    }
                    else {
                        showAns.setText("Select the conversion type");
                    }
                }
            }
        });
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVal.setText("");
                showAns.setText("0.0");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }
}