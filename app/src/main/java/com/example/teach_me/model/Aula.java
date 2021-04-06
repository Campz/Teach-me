package com.example.teach_me.model;

public class Aula {

    private Integer id;
    private Integer cdUsuarioAluno;
    private Integer cdAnuncio;
    private String horario;

    private String titulo;
    private String descricao;
    private double avaliacao;
    private Integer isAvaliado;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getIsAvaliado() {
        return isAvaliado;
    }

    public void setIsAvaliado(Integer isAvaliado) {
        this.isAvaliado = isAvaliado;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nAluno: " + getCdUsuarioAluno()
                + "\nAnúncio: " + getCdAnuncio()
                + "\nHorário: " + getHorario();
    }
}
