package com.vitoraugusto.myapplication.Controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.vitoraugusto.myapplication.Model.Curso;


public class CursoController {
    private static final String NOMES_PREFERENCES = "usuarios";
    private final SharedPreferences sharedPreferences;


    public CursoController(Context context) {
        this.sharedPreferences = context.getSharedPreferences(NOMES_PREFERENCES, Context.MODE_PRIVATE);
    }


    public void salvarPosicao(int posicao){
        SharedPreferences.Editor listavip = sharedPreferences.edit();
        listavip.putInt("posicao", posicao);
        listavip.apply();
    }



public int carregarCurso(){
        int posicao = 0;
        posicao =  sharedPreferences.getInt("posicao", 0);
        return posicao;
}
}



