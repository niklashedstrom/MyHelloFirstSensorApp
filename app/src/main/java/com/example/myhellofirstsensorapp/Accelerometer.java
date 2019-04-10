package com.example.myhellofirstsensorapp;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;




public class Accelerometer extends AppCompatActivity implements SensorEventListener {


    private SensorManager sensorManager;
    Sensor accelerometer;

    TextView xValue, yValue, zValue, dir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        xValue = (TextView) findViewById(R.id.x_axis);
        yValue = (TextView) findViewById(R.id.y_axis);
        zValue = (TextView) findViewById(R.id.z_axis);
        dir =  findViewById(R.id.dir);

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public float convert(float a ){
        float p = a*100;
        float l = Math.round(p);
        float h = l / 100;
        return h;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        xValue.setText(Float.toString(convert(event.values[0])));
        yValue.setText(Float.toString(convert(event.values[1])));
        zValue.setText(Float.toString(convert(event.values[2])));

        if(event.values[0] <= -4.0){
            dir.setText("Höger");
        }

        if(event.values[0] >= 4.0){
            dir.setText("Vänster");
        }

        if( -4.0 < event.values[0] && event.values[0] < 4.0){
            dir.setText("");
        }

        if(event.values[0] <= -8.0 || event.values[0] >= 8.0){
            v.vibrate(400);

        }
    }


}


