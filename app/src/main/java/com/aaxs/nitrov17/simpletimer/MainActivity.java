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
    }


}
