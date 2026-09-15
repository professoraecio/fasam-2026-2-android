package com.professoraecio.projeto15;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.professoraecio.projeto15.util.UtilToast;

public class MainActivity extends AppCompatActivity {

    String [] frutas = {"Abacate","Abacaxi","Maçã","Manga","Uva"};

    ListView frutasListView;

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

        frutasListView = findViewById(R.id.frutasListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.fruta_cell,R.id.frutaTextView, frutas);
        frutasListView.setAdapter(adapter);

        frutasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fruta = adapter.getItem(position);
                UtilToast.alertaLongo(MainActivity.this,fruta);
            }
        });

    }
}