package com.vitoraugusto.myapplication.Model;



import androidx.annotation.NonNull;




public class Pessoa {

    private String primeiroNome;
    private String sobrenome;
    private String curso;

    private String telefoneContato;


    public Pessoa() {
    }
    public Pessoa(String primeiroNome, String sobrenome,String curso,  String telefoneContato) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.telefoneContato = telefoneContato;
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    @NonNull
    public String toString(){
        return "Primeiro Nome: "+ getPrimeiroNome() +"\n"
                +"Sobrenome: "+ getSobrenome() + "\n"+
                "Curso: " + curso+ "\n"+
                "Telefone para contato: "+ getTelefoneContato();
    }


}



