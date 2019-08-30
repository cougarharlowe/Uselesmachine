package com.example.uselesmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruct;
    private Switch Switch;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

    }

    private void wireWidgets() {
        buttonSelfDestruct = findViewById(R.id.button_main_self_destruct);
        Switch = findViewById(R.id.switch_onoff);
        constraintLayout = findViewById(R.id.constraint_layout_main);

    }
    private void setListeners() {
        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    new CountDownTimer(2000, 10) {
                        @Override
                        public void onTick(long l) {
                            if(!Switch.isChecked())
                                cancel();
                        }

                        @Override
                        public void onFinish() {
                            Switch.setChecked(false);
                            finish();

                        }
                    };
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

                    @Override
                    public void onTick(long l) {



                    changebackgroundcolor();
                    }

                    private void changebackgroundcolor() {

                        int r =+ 100;
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
    }


}
