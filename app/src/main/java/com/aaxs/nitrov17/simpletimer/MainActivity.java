package com.aaxs.nitrov17.simpletimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Chronometer chronometer;
    Button button;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar =(SeekBar) findViewById(R.id.seekBar);
        chronometer=(Chronometer) findViewById(R.id.chronometer2);
        button = (Button) findViewById(R.id.button);

        seekBar.setMax(600); //Max in seconds
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                updateChronometer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void updateChronometer(int a)
    {
        int val = a*1000;
        chronometer.setCountDown(true);
        
    }

}
