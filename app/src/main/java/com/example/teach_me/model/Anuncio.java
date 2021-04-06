package com.example.teach_me.model;

public class Anuncio {

    private Integer id;
    private Integer qtdAlunos;
    private String descricao;
    private Integer cdDisciplina;
    private Integer cdUsuarioProfessor;
    private String valor;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(Integer qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCdDisciplina() {
        return cdDisciplina;
    }

    public void setCdDisciplina(Integer cdDisciplina) {
        this.cdDisciplina = cdDisciplina;
    }

    public Integer getCdUsuarioProfessor() {
        return cdUsuarioProfessor;
    }

    public void setCdUsuarioProfessor(Integer cdUsuarioProfessor) {
        this.cdUsuarioProfessor = cdUsuarioProfessor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nDescrição: " + getDescricao()
                + "\nProfessor: " + getCdUsuarioProfessor()
                + "\nQTD Alunos: " + getQtdAlunos()
                + "\nDisciplina: " + getCdDisciplina()
                + "\nValor: " + getValor();
    }
}
