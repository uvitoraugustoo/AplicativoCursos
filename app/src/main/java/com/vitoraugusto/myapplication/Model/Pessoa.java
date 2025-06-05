package com.vitoraugusto.myapplication.Model;



import androidx.annotation.NonNull;




public class Pessoa {

    private String primeiroNome;
    private String sobrenome;

private String nomeDoCurso;



    private String telefoneContato;


    public Pessoa() {
    }
    public Pessoa(String primeiroNome, String sobrenome,String nomeDoCurso,String telefoneContato) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
this.nomeDoCurso = nomeDoCurso;
        this.telefoneContato = telefoneContato;
    }
    public String getNomeDoCurso() {
        return nomeDoCurso;
    }
    public String getTelefoneContato() {
        return telefoneContato;
    }


    public String getPrimeiroNome() {
        return primeiroNome;
    }



    public String getSobrenome() {
        return sobrenome;
    }


    @NonNull
    public String toString(){
        return "Primeiro Nome: "+ getPrimeiroNome() +"\n"
                +"Sobrenome: "+ getSobrenome() + "\n"+
                "Telefone para contato: "+ getTelefoneContato();
    }


}



