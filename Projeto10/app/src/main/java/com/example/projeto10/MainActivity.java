package com.example.projeto10;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projeto10.util.UtilAlertDialog;

public class MainActivity extends AppCompatActivity {

    TextView resultadoTextView;

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


        resultadoTextView = findViewById(R.id.resultadoTextView);

    }

    public void testeDeAvisoButtonAction(View view){
        UtilAlertDialog.alerta(this,
                "Alerta simples",
                "Nenhuma ação gerada...");
    }

    public void testeDeConfirmacaoButtonAction(View view){
        UtilAlertDialog.alertaComConfirmacao(this,
                "Alerta com ação",
                "Deseja excluir?",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // sim
                        resultadoTextView.setText("Usuario clicou em sim");
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // não
                        resultadoTextView.setText("Usuario clicou em não");
                    }
                });

    }


}