package com.example.teach_me.models;

import com.example.teach_me.api.TipoData;
import com.example.teach_me.api.UsuarioData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tipo {
    @SerializedName("data")
    @Expose
    private TipoData data;

    public TipoData getData() {
        return data;
    }

    public void setData(TipoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nTipo: " + data.getNmInstituicao();
    }
}
