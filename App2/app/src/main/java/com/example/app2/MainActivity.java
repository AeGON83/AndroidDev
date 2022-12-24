package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView enterName;
    public static String passedName = "com.example.app2.extra.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterName = findViewById(R.id.editTextTextPersonName);
    }

    public void passName(View view){
        String name = enterName.getText().toString();
        if(name.length()==0){
            Toast.makeText(this , "Enter Text First" , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent currIntent = new Intent(this , MainActivity2.class);
        currIntent.putExtra(passedName , name);
        startActivity(currIntent);
    }
}