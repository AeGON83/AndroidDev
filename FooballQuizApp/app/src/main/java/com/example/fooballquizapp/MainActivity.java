package com.example.fooballquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView currQue;
    Button cr7;
    Button lm10;
    byte score;
    byte currQueIndex=0;
    String [] ques = {"1. Who has most career goals?" , "2. Who plays in farmers league?" , "3. Which one we call Mr.Champions League?" , "4. Who missed more penalties?" , "5. Which one has better international career?" , "6. Who owns Atlético de Madrid?" , "7. So say the GOAT's name?"};
    Boolean [] ans = {true , false , true , false , true , true , true};



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currQue = findViewById(R.id.questionView);
        cr7 = findViewById(R.id.cr7);
        lm10 = findViewById(R.id.lm10);
        currQue.setText(ques[currQueIndex]);

    cr7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(ans[currQueIndex]){
                score++;
            }
            currQueIndex++;
            if(currQueIndex==7){
                currQueIndex=0;
                Intent i = new Intent(MainActivity.this , MainActivity2.class);
                i.putExtra("GOAT" , true);
                i.putExtra("SCORE" , score);
                Toast.makeText(getApplicationContext() , String.format("your score is %s", score) , Toast.LENGTH_SHORT).show();
                score = 0;
                startActivity(i);
            }
            currQue.setText(ques[currQueIndex]);
        }
    });
    lm10.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(!ans[currQueIndex]){
                score++;
            }
            currQueIndex++;
            if(currQueIndex==7){
                currQueIndex=0;
                Intent i = new Intent(MainActivity.this , MainActivity2.class);
                i.putExtra("GOAT" , false);
                i.putExtra("SCORE" , score);
                Toast.makeText(getApplicationContext() , String.format("your score is %s", score) , Toast.LENGTH_SHORT).show();
                score = 0;
                startActivity(i);
            }
            currQue.setText(ques[currQueIndex]);
        }
    });
    }

}
