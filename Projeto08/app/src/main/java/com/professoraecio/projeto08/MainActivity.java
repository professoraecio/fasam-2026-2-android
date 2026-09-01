package com.professoraecio.projeto08;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout activity_main;
    Switch notificacoesSwitch;
    Switch darkModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        activity_main = findViewById(R.id.activity_main);
        notificacoesSwitch = findViewById(R.id.notificacoesSwitch);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);

        notificacoesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b){
                    notificacoesSwitch.setText(R.string.label_ligado);
                    Toast.makeText(MainActivity.this,
                            "Notificações: " +
                            getString(R.string.label_ligado),Toast.LENGTH_LONG).show();
                }else{
                    notificacoesSwitch.setText(R.string.label_desligado);
                    notificacoesSwitch.setText(R.string.label_desligado);
                    Toast.makeText(MainActivity.this,
                            "Notificações: " +
                                    getString(R.string.label_desligado),Toast.LENGTH_LONG).show();
                }
            }
        });

        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b){
                    activity_main.setBackgroundColor(Color.GRAY);
                    darkModeSwitch.setText(R.string.label_ligado);
                }else{
                    activity_main.setBackgroundColor(Color.WHITE);
                    darkModeSwitch.setText(R.string.label_desligado);
                }
            }
        });

    }
}