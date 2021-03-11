package com.example.teach_me.model;

public class Instituicao {

    private Integer id;
    private String nmInstituicao;
    private String endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "ID: " + getId()
                + "\nNome: " + getNmInstituicao()
                + "\nEndereço: " + getEndereco();
    }
}
