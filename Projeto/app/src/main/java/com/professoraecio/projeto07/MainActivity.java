package com.professoraecio.projeto07;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView gorjetaTextView;
    CheckBox gorjetaCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gorjetaTextView = findViewById(R.id.gorjetaTextView);
        gorjetaCheckBox = findViewById(R.id.gorjetaCheckBox);

        gorjetaTextView.setText("Modo de Pagamento: Sem Gorjeta");
        gorjetaCheckBox.setText("Gorjeta");

        gorjetaCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                if(b){
                    gorjetaTextView.setText("Modo de Pagamento: Com Gorjeta");
                }else{
                    gorjetaTextView.setText("Modo de Pagamento: Sem Gorjeta");
                }
            }
        });

    }
}