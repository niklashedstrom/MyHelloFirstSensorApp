package com.example.myhellofirstsensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myhellofirstsensorapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
