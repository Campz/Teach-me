package com.example.teach_me.models;

public class Disciplina {

    private String cdDisciplina;
    private String nmDisciplina;
    private Tipo tipo;

    public Disciplina(String cdDisciplina, String nmDisciplina, Tipo tipo) {
        this.cdDisciplina = cdDisciplina;
        this.nmDisciplina = nmDisciplina;
        this.tipo = tipo;
    }

    public String getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(String cdDisciplina) {
        this.cdDisciplina = cdDisciplina;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ID: " + getCdDisciplina()
                + "\nNome: " + getNmDisciplina()
                + "\nTipo: " + getTipo().getNmTipo();
    }
}
