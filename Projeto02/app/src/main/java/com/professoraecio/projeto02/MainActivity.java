package com.professoraecio.projeto02;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView alturaTextView;
    SeekBar alturaSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alturaTextView = findViewById(R.id.alturaTextView);
        alturaSeekBar = findViewById(R.id.alturaSeekBar);

        alturaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String alturaFormatada;
                if(i < 10){
                    alturaFormatada = "00" + i;
                }else{
                    if(i >= 10 && i < 100){
                        alturaFormatada = "0" + i;
                    }else{
                        alturaFormatada = "" + i;
                    }
                }

                alturaTextView.setText(alturaFormatada);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}