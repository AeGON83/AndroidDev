package com.example.fooballquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    TextView scoreNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        boolean ronnie = i.getBooleanExtra("GOAT" , true);
        byte score = i.getByteExtra("SCORE" , (byte) 8);

        //set score
        scoreNum = findViewById(R.id.scoreNum);
        scoreNum.setText(String.format("%s/7" , score));

        //set color
        ConstraintLayout mainBody = findViewById(R.id.mainBody);

        if(score>=5){
        mainBody.setBackgroundColor(0xFF00C853);//green
        }
        else if(score >=3){
        mainBody.setBackgroundColor(0xFFFFD600);//yellow
        }
        else{
        mainBody.setBackgroundColor(0xFFFF5252);//red
        }


        //set video
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        TextView endMsg = findViewById(R.id.endMsg);
        if(ronnie){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.ronniegoat);
            endMsg.setText("FAX");
        }else{
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messigoat);
        endMsg.setText("Bro Litrally chose messi , lol");
        }
        videoView.start();


        // set loop
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                if(!ronnie){
                mp.setVolume(0.03f,0.03f);
                }
            }
        });

    }
}