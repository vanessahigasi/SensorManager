package com.example.sensormanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List <Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        StringBuilder sensorsStringBuilder = new StringBuilder();
        for (Sensor sensor : sensorList) {
            sensorsStringBuilder.append(sensor.getName()).append("\n");
        }
        Toast.makeText(this,
                sensorsStringBuilder.toString(),
                Toast.LENGTH_LONG).show();

    }
}
