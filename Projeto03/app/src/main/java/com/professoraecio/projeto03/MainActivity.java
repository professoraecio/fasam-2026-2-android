package com.professoraecio.projeto03;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView idadeTextView;
    NumberPicker idadeNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idadeTextView = findViewById(R.id.idadeTextView);
        idadeNumberPicker = findViewById(R.id.idadeNumberPicker);

        idadeTextView.setText("Idade Selecionada: Nenhuma");

        idadeNumberPicker.setMinValue(0);
        idadeNumberPicker.setMaxValue(150);

        idadeNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int valorAntigo, int valor) {
                idadeTextView.setText("Idade Selecionada: " + valor);
            }
        });

    }
}