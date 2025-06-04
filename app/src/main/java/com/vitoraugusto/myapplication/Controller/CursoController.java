package com.vitoraugusto.myapplication.Controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.vitoraugusto.myapplication.Model.Curso;


public class CursoController {
   Curso curso;


    @NonNull
    public String toString(){
        Log.d("MVC Controller ", "Controller Iniciado...");
        return super.toString();
    }


    public void salvar(Curso curso){
        Log.d("MVC_Controller", "Salvo: \n"+ curso.toString());
    }


}



