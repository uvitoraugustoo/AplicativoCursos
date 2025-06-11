package com.vitoraugusto.myapplication.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    private static final String NOME_DATABASE = "dados_usuarios";
    private static final int VERSAO_DATABASE = 1;

    public static final String NOME_TABELA = "usuarios";

    public static final String ID = "id";
    public static final String PRIMEIRO_NOME = "primeiroNome";
    public static final String SOBRENOME = "sobrenome";
    public static final String CURSO_DESEJADO = "cursoDesejado";
    public static final String TELEFONE = "telefone";

    private static final String SQL_CRIAR_TABELA =
            "CREATE TABLE " + NOME_TABELA + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PRIMEIRO_NOME + " TEXT, " +
                    SOBRENOME + " TEXT, " +
                    CURSO_DESEJADO + " TEXT, " +
                    TELEFONE + " TEXT)";


    public BancoDeDados(Context context) {
        super(context, NOME_DATABASE, null, VERSAO_DATABASE);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CRIAR_TABELA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOME_TABELA);
        onCreate(db);
    }
}
