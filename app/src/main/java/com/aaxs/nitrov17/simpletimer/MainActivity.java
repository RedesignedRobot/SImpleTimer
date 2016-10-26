package com.aaxs.nitrov17.simpletimer;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Button button;
    CountDownTimer countDownTimer;
    Vibrator vibrator;
    int x;
    boolean isTimerActive=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);

        initView();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                x=i*1000;
                updateText((long)x);
                if(i==0)
                    correctText();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTimerActive==false) {
                    primeTimer(x);
                    isTimerActive = true;
                    countDownTimer.start();
                    seekBarEnabler();
                }
                else if(isTimerActive)
                {
                    timerReset();
                }
            }
        });


    }

    void initView()
    {
        seekBar.setMax(600);    //In Seconds
        seekBar.setProgress(0);
        textView.setText("0:00");
        button.setText("Start");
    }

    void updateText(long a)
    {
        int totalSecs =(int)a/1000;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        textView.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
    }

    void primeTimer(int a)
    {
        countDownTimer= new CountDownTimer(a,1000) {
            @Override
            public void onTick(long l) {

                updateText(l);

            }

            @Override
            public void onFinish() {

                textView.setText("Times Up!");
                isTimerActive=false;
                seekBarEnabler();
                userAlert();

            }
        };
    }

    void seekBarEnabler()
    {
        if(isTimerActive)
        {
            seekBar.setEnabled(false);
            button.setText("STOP");
        }

        else
        {
            seekBar.setEnabled(true);
            button.setText("START");
        }
    }

    void timerReset()
    {
        countDownTimer.cancel();
        textView.setText("Stopped");
        isTimerActive=false;
        seekBarEnabler();
        seekBar.setProgress(0);
    }

    void correctText()
    {
        textView.setText("0:00");
    }

    void userAlert()
    {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        vibrator=(Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
    }
}
