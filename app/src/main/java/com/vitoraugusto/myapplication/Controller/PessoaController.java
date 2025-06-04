package com.vitoraugusto.myapplication.Controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.vitoraugusto.myapplication.Model.Pessoa;


public class PessoaController {

    Pessoa pessoa;


    @NonNull
    public String toString(){
        Log.d("MVC Controller ", "Controller Iniciado...");
        return super.toString();
    }


    public void salvar(Pessoa pessoa){
        Log.d("MVC_Controller", "Salvo: \n"+ pessoa.toString());
    }


}

