package com.example.teach_me.models;

public class Anuncio {
    private int cdAnuncio;
    private int qtdAlunos;
    private String descricao;
    private Disciplina disciplina;
    private Usuario cdUsuario_Professor;
    private double valor;

    public Anuncio(int cdAnuncio, int qtdAlunos, String descricao, Disciplina disciplina, Usuario cdUsuario_Professor, double valor) {
        this.cdAnuncio = cdAnuncio;
        this.qtdAlunos = qtdAlunos;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.cdUsuario_Professor = cdUsuario_Professor;
        this.valor = valor;
    }

    public int getCdAnuncio() {
        return cdAnuncio;
    }

    public void setCdAnuncio(int cdAnuncio) {
        this.cdAnuncio = cdAnuncio;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunoso(int qtdAlunos) {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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
