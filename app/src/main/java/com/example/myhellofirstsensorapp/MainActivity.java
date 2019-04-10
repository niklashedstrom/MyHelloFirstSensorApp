package com.example.myhellofirstsensorapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myhellofirstsensorapp.MESSAGE";
    Button bt;
    Boolean playing;
    Long then;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.nalle);
        playing = true;
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (playing){
                    mp.start();
                    playing = false;
                    count++;
                }else{
                    playing = true;
                    mp.pause();

                }


            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, compass.class);
        startActivity(intent);
    }

    public void goToAccelerometer(View view) {
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }
}
