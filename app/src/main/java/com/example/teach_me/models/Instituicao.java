package com.example.teach_me.models;

import com.example.teach_me.api.InstituicaoData;
import com.example.teach_me.api.UsuarioData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Instituicao {

    @SerializedName("data")
    @Expose
    private InstituicaoData data;

    public InstituicaoData getData() {
        return data;
    }

    public void setData(InstituicaoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nNome: " + data.getNmInstituicao()
                + "\nEndereço: " + data.getEndereco();
    }
}
