package com.example.teach_me.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstituicaoData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("NmInstituicao")
    @Expose
    private String nmInstituicao;
    @SerializedName("Endereco")
    @Expose
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
}
