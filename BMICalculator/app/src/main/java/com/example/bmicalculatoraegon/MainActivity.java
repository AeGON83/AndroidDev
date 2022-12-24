package com.example.bmicalculatoraegon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputHeight = findViewById(R.id.inputH) , inputWeight = findViewById(R.id.inputW);
        TextView outputResult = findViewById(R.id.outputResult);
        Button checkBtn = findViewById(R.id.checkButton);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                if(inputHeight.getText().toString().equals("") || inputWeight.getText().toString().equals("")){
                Toast.makeText(MainActivity.this , "Please fill the fields" , Toast.LENGTH_LONG).show();
                    outputResult.setBackgroundColor(Color.parseColor("#FF03DAC5"));

                    return;
                }
                double height = Double.parseDouble(inputHeight.getText().toString());
                double weight = Double.parseDouble(inputWeight.getText().toString());
                double BMI = weight/Math.pow((height/100),2);

                if(BMI<18.5){
                    outputResult.setText("BMI : " + String.format("%.2f", BMI) + "\nYou are Underweight");
                    outputResult.setBackgroundColor(Color.parseColor("#FFC6C210"));

                }
                else if(BMI>18.5 && BMI <24.9){
                    outputResult.setText("BMI : " + String.format("%.2f", BMI) + "\nYou are Healthy");
                    outputResult.setBackgroundColor(Color.parseColor("#FF43DA03"));

                }else if(BMI>25.0 && BMI <29.9){
                    outputResult.setText("BMI : " + String.format("%.2f", BMI) + "\nYou are Overweight");
                    outputResult.setBackgroundColor(Color.parseColor("#FFC6C210"));

                }else{
                    outputResult.setText("BMI : " + String.format("%.2f", BMI) + "\nYou have Obesity");
                    outputResult.setBackgroundColor(Color.parseColor("#C61010"));

                }

            }
        });


    }
}