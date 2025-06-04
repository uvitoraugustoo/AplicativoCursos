package com.vitoraugusto.myapplication.Model;

public class Curso {
    private String nomeDoCurso;



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