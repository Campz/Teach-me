package com.example.teach_me.models;

public class Anuncio {
    private String cdAnuncio;
    private String qtdAlunos;
    private String descricao;
    private Disciplina disciplina;
    private Usuario cdUsuario_Professor;
    private String valor;

    public Anuncio(String cdAnuncio, String qtdAlunos, String descricao, Disciplina disciplina, Usuario cdUsuario_Professor, String valor) {
        this.cdAnuncio = cdAnuncio;
        this.qtdAlunos = qtdAlunos;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.cdUsuario_Professor = cdUsuario_Professor;
        this.valor = valor;
    }

    public String getCdAnuncio() {
        return cdAnuncio;
    }

    public void setCdAnuncio(String cdAnuncio) {
        this.cdAnuncio = cdAnuncio;
    }

    public String getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunoso(String qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Usuario getCdUsuario_Professor() {
        return cdUsuario_Professor;
    }

    public void setCdUsuario_Professor(Usuario cdUsuario_Professor) {
        this.cdUsuario_Professor = cdUsuario_Professor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ID: " + getCdAnuncio()
                + "\nDescrição: " + getDescricao()
                + "\nProfessor: " + getCdUsuario_Professor().getNmUsuario()
                + "\nQTD Alunos: " + getQtdAlunos()
                + "\nDisciplina: " + getDisciplina().getNmDisciplina()
                + "\nValor: " + getValor();
    }
}
