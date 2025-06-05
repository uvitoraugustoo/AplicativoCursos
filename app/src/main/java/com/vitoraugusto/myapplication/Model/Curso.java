package com.vitoraugusto.myapplication.Model;

public class Curso {
    private String nomeDoCurso;


    public Curso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public String toString(){
        return "curso: "+ nomeDoCurso;
    }


}