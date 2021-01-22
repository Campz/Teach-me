package com.example.teach_me.models;

public class Disciplina {

    private int cdDisciplina;
    private String nmDisciplina;
    private Tipo tipo;

    public Disciplina(int cdDisciplina, String nmDisciplina, Tipo tipo) {
        this.cdDisciplina = cdDisciplina;
        this.nmDisciplina = nmDisciplina;
        this.tipo = tipo;
    }

    public int getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(int cdDisciplina) {
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
}
