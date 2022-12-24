package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button reset = findViewById(R.id.reset);
        TextView winner = findViewById(R.id.winner);
        Button[] btnList = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
        final boolean[] currPlayer = {true};
        AtomicReference<Byte> checkVar = new AtomicReference<>((byte) 0);
        final byte[] filled = {0};

        reset.setOnClickListener(view ->{
            for(Button b:btnList){
               b.setText("");
               b.setBackgroundColor(Color.parseColor("#FFAAAAAA"));
               winner.setText("");
               checkVar.set((byte)0);
            }
        });

        for(Button b:btnList){
            b.setOnClickListener(view -> {
                if(checkVar.get() != 0){
                    return;
                }
                if(!b.getText().toString().equals("")){
                    return;
                }
                filled[0]++;
                if(currPlayer[0]){
                    b.setText("X");
                    b.setBackgroundColor(Color.parseColor("#2962FF"));
                    currPlayer[0] = false;
                }else {
                    b.setText("O");
                    b.setBackgroundColor(Color.parseColor("#FF6D00"));
                    currPlayer[0] = true;
                }

                checkVar.set(check(btnList));

                if(checkVar.get() == 1){
                    winner.setText("Player 1 Won");
                    winner.setTextColor(Color.parseColor("#2962FF"));
                }
                else if(checkVar.get() == 2){
                    winner.setText("Player 2 Won");
                    winner.setTextColor(Color.parseColor("#FF6D00"));
                }
                else if(filled[0] == 9 && checkVar.get() == 0){
                    winner.setText("DRAW");
                    winner.setTextColor(Color.parseColor("#FF00C853"));
                }
            });
        }
    }
    public byte check(Button[] buttonList){
        String[] btnText = new String[9];
        for(int i=0;i<9;i++){
            btnText[i] = buttonList[i].getText().toString();
        }

        String winner="";

        if(btnText[0].equals(btnText[1]) && btnText[0].equals(btnText[2]) && !btnText[0].equals("")){
            winner = btnText[0];
        }else if(btnText[3].equals(btnText[4]) && btnText[3].equals(btnText[5]) && !btnText[3].equals("")){
            winner = btnText[3];
        }else if(btnText[6].equals(btnText[7]) && btnText[6].equals(btnText[8]) && !btnText[6].equals("")){
            winner = btnText[6];
        }else if(btnText[0].equals(btnText[3]) && btnText[0].equals(btnText[6]) && !btnText[0].equals("")){
            winner = btnText[0];
        }else if(btnText[1].equals(btnText[4]) && btnText[1].equals(btnText[7]) && !btnText[1].equals("")){
            winner = btnText[1];
        }else if(btnText[2].equals(btnText[5]) && btnText[2].equals(btnText[8]) && !btnText[2].equals("")){
            winner = btnText[2];
        }else if(btnText[0].equals(btnText[4]) && btnText[0].equals(btnText[8]) && !btnText[0].equals("")){
            winner = btnText[0];
        }else if(btnText[2].equals(btnText[4]) && btnText[2].equals(btnText[6]) && !btnText[2].equals("")){
            winner = btnText[2];
        }

        if(winner.equals("")){
            return(0);
        }
        if (winner.equals("X")){
            return 1;
        }
        if(winner.equals("O")){
            return 2;
        }
        return 0;
    }


}