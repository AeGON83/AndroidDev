package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        outputView = findViewById(R.id.textView2);

        Intent currIntent = getIntent();
        String name = currIntent.getStringExtra(MainActivity.passedName);
        StringBuilder outputName = new StringBuilder();
        String alphaStr = "abcdefghijklmnopqrstuvwxyz";
        String numStr = "0123456789";

        if (name.length() != 4 || (name.charAt(0)!='1' && name.charAt(0) != '2')) {
            name = name.toUpperCase();
            for (int j = name.length() - 1; j >= 0; j--) {
                outputName.append(name.charAt(j));
            }
            outputView.setText(outputName.toString());
        }
        else{
            byte steps;
            if(name.charAt(0)=='1'){
                steps = 3;
            }
            else{
                steps = 2;
            }
            int currIndex;

            name = name.toLowerCase();

            for(int i=1;i<=3;i++){
                if(Character.isDigit(name.charAt(i)))
                {
                    currIndex = (numStr.indexOf(name.charAt(i)) + steps) % numStr.length();
                    outputName.append(numStr.charAt(currIndex));
                }
                else
                {
                currIndex = (alphaStr.indexOf(name.charAt(i)) + steps) % alphaStr.length();
                outputName.append(alphaStr.charAt(currIndex));
                }
            }
            if(steps==2){
                outputName.append("@833283");
            }else{
                outputName.append("#832383");
            }
            outputName = new StringBuilder(outputName.substring(0, 1).toUpperCase() + outputName.substring(1));

            outputView.setText(outputName.toString());
        }

    }
        public void copyText(View view){
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("copiedText", outputView.getText().toString());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(MainActivity2.this , "Copied" , Toast.LENGTH_SHORT).show();
        }

}