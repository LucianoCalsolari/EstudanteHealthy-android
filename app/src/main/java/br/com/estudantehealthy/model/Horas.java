package br.com.estudantehealthy.model;

public class Horas {

    private CharSequence horas;
    private String nome;

    public Horas( String nome, CharSequence horas ) {
        this.horas = horas;
        this.nome = nome;
    }

    public CharSequence getHoras() {
        return horas;
    }

    public void setHoras(CharSequence horas) {
        this.horas = horas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
