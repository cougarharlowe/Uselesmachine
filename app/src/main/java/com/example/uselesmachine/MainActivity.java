package com.example.uselesmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelfDestruct;
    private Switch Switch;

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
                    }
                }
            }
        });
    }

}
