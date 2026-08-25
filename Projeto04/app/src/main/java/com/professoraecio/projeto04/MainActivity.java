package com.professoraecio.projeto04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String [] personagens = new String[3];

    TextView personagemTextView;
    ImageView personagemImageView;
    NumberPicker personagensNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personagemTextView = findViewById(R.id.personagemTextView);
        personagemImageView = findViewById(R.id.personagemImageView);
        personagensNumberPicker = findViewById(R.id.personagensNumberPicker);

        personagemTextView.setText("Tio Donald");

        personagens[0] = "Tio Donald";
        personagens[1] = "Mickey";
        personagens[2] = "Tio Patinhas";

        personagensNumberPicker.setDisplayedValues(personagens);
        personagensNumberPicker.setMinValue(0);
        personagensNumberPicker.setMaxValue(2);

        personagensNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int valorAntigo, int i) {
                String personagem = personagens[i];
                if(personagem.equalsIgnoreCase("Tio Donald")){
                    personagemImageView.setImageResource(R.drawable.donald);
                    personagemTextView.setText("Tio Donald");
                }else{
                    if(personagem.equalsIgnoreCase("Mickey")){
                        personagemImageView.setImageResource(R.drawable.mickey);
                        personagemTextView.setText("Mickey");
                    }else{
                        personagemImageView.setImageResource(R.drawable.tio_patinhas);
                        personagemTextView.setText("Tio Patinhas");
                    }
                }
            }
        });


    }
}