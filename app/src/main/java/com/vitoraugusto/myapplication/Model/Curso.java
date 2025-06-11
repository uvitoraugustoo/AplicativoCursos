package com.vitoraugusto.myapplication.Model;

import androidx.annotation.NonNull;

public class Curso {
    private String nomeDoCurso;

    public Curso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String toString(){
        return "curso: "+ nomeDoCurso;
    }


}