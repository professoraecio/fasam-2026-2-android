package com.professoraecio.projeto13;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.professoraecio.projeto13.util.UtilSharedPreferences;
import com.professoraecio.projeto13.util.UtilToast;

public class MainActivity extends AppCompatActivity {

    EditText usuarioEditText;
    EditText senhaEditText;

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

        usuarioEditText = findViewById(R.id.usuarioEditText);
        senhaEditText = findViewById(R.id.senhaEditText);

    }

    public void salvar(View view){
        String usuario = usuarioEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        UtilSharedPreferences.saveString(this,"usuario.chave",usuario);
        UtilSharedPreferences.saveString(this,"senha.chave",senha);
        UtilToast.alertaLongo(this,"Dados salvos!");
    }

    public void recuperar(View view){
        String usuario = UtilSharedPreferences.getString(this,"usuario.chave","admin");
        String senha = UtilSharedPreferences.getString(this,"senha.chave","admin");
        usuarioEditText.setText(usuario);
        senhaEditText.setText(senha);
        UtilToast.alertaCurto(this,"Dados carregados");
    }

    public void zerarBanco(View view){
        UtilSharedPreferences.zerarBanco(this);
        UtilToast.alertaLongo(this,"Banco de dados apagado!");
    }



}