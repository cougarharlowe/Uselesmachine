package com.example.uselesmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruct;
    private Switch uselessSwitch;
    private ConstraintLayout constraintLayout;
    private Button buttonLookBusy;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

    }

    private void wireWidgets() {
        buttonSelfDestruct = findViewById(R.id.button_main_self_destruct);
        uselessSwitch = findViewById(R.id.switch_onoff);
        constraintLayout = findViewById(R.id.constraint_layout_main);
        buttonLookBusy = findViewById(R.id.button_main_lookBusy);
        progressBar = findViewById(R.id.progressBar_main_busyBar);


    }
    private void setListeners() {

        uselessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    new CountDownTimer(300, 100) {
                        @Override
                        public void onTick(long l) {
                            if(!uselessSwitch.isChecked())
                               cancel();
                        }

                        @Override
                        public void onFinish() {
                            uselessSwitch.setChecked(false);


                        }

                    }.start();

                }
            }
        });
        // set the on click listener for the self destruct button
        // make a 10 second countdown timer
        //display how much time is left on the countdown on the button
        //when the timer is complete, call the finish() method to close the activity
        // make the background blink red
        buttonSelfDestruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000,1000) {
                    int x = 10;
                    private int r = 50;
                    @Override
                    public void onTick(long l) {
                        x--;
                        buttonSelfDestruct.setText(String.valueOf(x));

                        r += 20;
                        int color = Color.rgb(r, 0, 0);
                        constraintLayout.setBackgroundColor(color);

                    }



                    @Override
                    public void onFinish() {
                        finish();

                    }
                }.start();

            }
        });
        buttonLookBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                buttonSelfDestruct.setVisibility(View.GONE);
                uselessSwitch.setVisibility(View.GONE);
                buttonLookBusy.setVisibility(View.GONE);
                new CountDownTimer(10000, 100){

                    int progress = 1;
                    @Override
                    public void onTick(long l) {
                        progressBar.setProgress(progress);
                        progress++;


                    }

                    @Override
                    public void onFinish() {
                        progressBar.setVisibility(View.GONE);
                        buttonSelfDestruct.setVisibility(View.VISIBLE);
                        uselessSwitch.setVisibility(View.VISIBLE);
                        buttonLookBusy.setVisibility(View.VISIBLE);

                    }
                }.start();

            }
        });
    }


}
