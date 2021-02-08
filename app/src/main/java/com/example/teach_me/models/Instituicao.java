package com.example.teach_me.models;

public class Instituicao {

    private String cdInstituicao;
    private String nmInstituicao;
    private String endereco;

    public Instituicao(String cdInstituicao, String nmInstituicao, String endereco) {
        this.cdInstituicao = cdInstituicao;
        this.nmInstituicao = nmInstituicao;
        this.endereco = endereco;
    }

    public String getCdInstituicao() {
        return cdInstituicao;
    }

    public void setCdInstituicao(String cdInstituicao) {
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

    @Override
    public String toString() {
        return "ID: " + getCdInstituicao()
                + "\nNome: " + getNmInstituicao()
                + "\nEndereço: " + getEndereco();
    }

}
