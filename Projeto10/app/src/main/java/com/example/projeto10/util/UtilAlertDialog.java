package com.example.projeto10.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class UtilAlertDialog {

    public static void alerta(Context context, String titulo, String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("OK",null)
                .show();
    }

    public static void alertaComConfirmacao(Context context,
                                            String titulo,
                                            String mensagem,
                                            DialogInterface.OnClickListener listenerSim,
                                            DialogInterface.OnClickListener listenerNao) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("Sim",listenerSim)
                .setNegativeButton("Não",listenerNao)
                .show();
    }

}
