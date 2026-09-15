package com.professoraecio.projeto14.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class UtilActivity {

    public static void mudarTelaMantendoHistorico(Context context, Class<?> telaDestino) {
        Intent intent = new Intent(context, telaDestino);
        context.startActivity(intent);
    }

    public static void mudarTelaSemHistorico(Activity telaAtual, Class<?> telaDestino) {
        Intent intent = new Intent(telaAtual, telaDestino);
        telaAtual.startActivity(intent);
        telaAtual.finish(); // finaliza a tela atual sem manter histórico
    }

}
