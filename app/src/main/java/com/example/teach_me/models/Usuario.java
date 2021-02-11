package com.example.teach_me.models;

import com.example.teach_me.api.UsuarioData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("data")
    @Expose
    private UsuarioData data;

    public UsuarioData getData() {
        return data;
    }

    public void setData(UsuarioData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nNome: " + data.getNmUsuario()
                + "\nNota: " + data.getAvaliacao()
                + "\nDescrição: " + data.getDescricao()
                + "\nDT Nascimento: " + data.getDtNascimento()
                + "\nEmail: " + data.getEmail();
                //+ "\nInstituição: " + getInstituicao().getNmInstituicao();
    }
}
