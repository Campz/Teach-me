package com.example.teach_me.model;

public class Aula {

    private Integer id;
    private Integer cdUsuarioAluno;
    private Integer cdAnuncio;
    private String horario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCdUsuarioAluno() {
        return cdUsuarioAluno;
    }

    public void setCdUsuarioAluno(Integer cdUsuarioAluno) {
        this.cdUsuarioAluno = cdUsuarioAluno;
    }

    public Integer getCdAnuncio() {
        return cdAnuncio;
    }

    public void setCdAnuncio(Integer cdAnuncio) {
        this.cdAnuncio = cdAnuncio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nAluno: " + getCdUsuarioAluno()
                + "\nAnúncio: " + getCdAnuncio()
                + "\nHorário: " + getHorario();
    }
}
