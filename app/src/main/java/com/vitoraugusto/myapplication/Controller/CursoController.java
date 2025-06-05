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

    public void salvarCurso(Curso curso) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nomeDoCurso", curso.getNomeDoCurso());
        editor.apply();
    }
public Curso carregarCurso(){
        String nomeDoCurso = sharedPreferences.getString("nomeDoCurso", "");
        return new Curso(nomeDoCurso);
}

}



