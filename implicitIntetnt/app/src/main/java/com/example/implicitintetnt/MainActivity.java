package com.example.implicitintetnt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.emailText);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void sendEmail(View view){
        String emailStr = emailText.getText().toString();
        if(emailStr.length()==0){
            Toast.makeText(this , "Enter Text First" , Toast.LENGTH_SHORT).show();
            return;
        }
        String[] addresses = {"code.rajansinhrajput@gmail.com" , "jaybhavani6996@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Testing Email Services and Implicit Intent");
        intent.putExtra(Intent.EXTRA_TEXT, emailStr);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}