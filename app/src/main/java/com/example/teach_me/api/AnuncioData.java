package com.example.teach_me.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnuncioData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("QtdAlunos")
    @Expose
    private Integer qtdAlunos;
    @SerializedName("Descricao")
    @Expose
    private String descricao;
    @SerializedName("CdDisciplina")
    @Expose
    private Integer cdDisciplina;
    @SerializedName("CdUsuario_Professor")
    @Expose
    private Integer cdUsuarioProfessor;
    @SerializedName("Valor")
    @Expose
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
}
