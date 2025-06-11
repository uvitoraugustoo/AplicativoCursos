package com.vitoraugusto.myapplication.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vitoraugusto.myapplication.BancoDeDados.BancoDeDados;

public class DbController {

    private final BancoDeDados banco;

    public DbController(Context context) {
        banco = new BancoDeDados(context);
    }

    public String insertData(String nome, String sobrenome, String telefone, String cursoDesejado) {
        ContentValues valores = new ContentValues();
        SQLiteDatabase db = banco.getWritableDatabase();

        valores.put(BancoDeDados.PRIMEIRO_NOME, nome);
        valores.put(BancoDeDados.SOBRENOME, sobrenome);
        valores.put(BancoDeDados.TELEFONE, telefone);
        valores.put(BancoDeDados.CURSO_DESEJADO, cursoDesejado);

        long resultado = db.insert(BancoDeDados.NOME_TABELA, null, valores);


        if (resultado == -1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }
}



