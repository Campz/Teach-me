package com.example.teach_me.models;

public class Instituicao {

    private int cdInstituicao;
    private String nmInstituicao;
    private String endereco;

    public Instituicao(int cdInstituicao, String nmInstituicao, String endereco) {
        this.cdInstituicao = cdInstituicao;
        this.nmInstituicao = nmInstituicao;
        this.endereco = endereco;
    }

    public int getCdInstituicao() {
        return cdInstituicao;
    }

    public void setCdInstituicao(int cdInstituicao) {
        this.cdInstituicao = cdInstituicao;
    }

    public String getNmInstituicao() {
        return nmInstituicao;
    }

    public void setNmInstituicao(String nmInstituicao) {
        this.nmInstituicao = nmInstituicao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
