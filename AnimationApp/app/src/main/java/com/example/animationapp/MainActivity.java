package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView like;
    TextView thankYou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like);
        thankYou = findViewById(R.id.thankYou);

        like.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                    like.playAnimation();
                    thankYou.setText("ThankYou");
                    Toast.makeText(getApplicationContext(),"Thank You" , Toast.LENGTH_SHORT).show();
            }
        });

    }

}