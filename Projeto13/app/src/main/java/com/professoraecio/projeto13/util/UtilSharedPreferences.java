package com.professoraecio.projeto13.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilSharedPreferences {

    private static final String PREFERENCE_NAME = "MyPreferences";

    public static void saveString(Context context, String chave , String valor){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(chave,valor);
        editor.apply();
    }

    public static String getString(Context context, String chave,String valorCasoNaoExista){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return  sharedPreferences.getString(chave,valorCasoNaoExista);
    }

    public static void zerarBanco(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
