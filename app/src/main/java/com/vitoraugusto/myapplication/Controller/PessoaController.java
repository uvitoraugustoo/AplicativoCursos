package com.vitoraugusto.myapplication.Controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.vitoraugusto.myapplication.Model.Curso;
import com.vitoraugusto.myapplication.Model.Pessoa;


public class PessoaController {



    SharedPreferences sharedPreferences;
    public static final String NOMES_PREFERENCES = "usuarios";


    public PessoaController(Context context) {
        sharedPreferences = context.getSharedPreferences(NOMES_PREFERENCES, 0);
    }

    public void salvarPessoa(Pessoa pessoa) {
        SharedPreferences.Editor listaVip = sharedPreferences.edit();
        listaVip.putString("nome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("curso", pessoa.getNomeDoCurso());
        listaVip.putString("telefone", pessoa.getTelefoneContato());
        listaVip.apply();
    }


    public Pessoa carregarPessoa() {
        String primeiroNome = sharedPreferences.getString("nome", "");
        String sobrenome = sharedPreferences.getString("sobrenome", "");
        String nomeDoCurso = sharedPreferences.getString("curso", "");
        String telefone = sharedPreferences.getString("telefone", "");
        return new Pessoa(primeiroNome, sobrenome, nomeDoCurso,telefone);


    }


    @NonNull
    public String toString() {
        Log.d("MVC Controller ", "Controller Iniciado...");
        return super.toString();

    }
    public void deleterPessoa(){
        sharedPreferences.edit().clear().apply();
    }


}

