package com.example.converterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected Button conButton;
    protected TextView pndOutput;
    protected EditText kgInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conButton = findViewById(R.id.button);
        pndOutput = findViewById(R.id.outputText);
        kgInput = findViewById(R.id.inputView);

        conButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = kgInput.getText().toString();
                if(s.length() == 0){
                    Toast.makeText(MainActivity.this , "please enter input" , Toast.LENGTH_SHORT).show();
                    kgInput.setBackgroundColor(0xFFE46363);
                    pndOutput.setBackgroundColor(0xFFE46363);
                    return;
                }
                else if(s.charAt(0) == '-'){
                    Toast.makeText(MainActivity.this , "weight can be only positive number" , Toast.LENGTH_SHORT).show();
                    kgInput.setBackgroundColor(0xFFE46363);
                    pndOutput.setBackgroundColor(0xFFE46363);
                    return;
                }
                double kg = Double.parseDouble(s);
//              1kg =  2.205 pound
                double pnd = kg * 2.205;
                pndOutput.setText("" + pnd);
                Toast.makeText(MainActivity.this , "converted in pound" , Toast.LENGTH_SHORT).show();
                kgInput.setBackgroundColor(0xFFD3D4D4);
                pndOutput.setBackgroundColor(0xFFD3D4D4);
            }
        });


    }
}