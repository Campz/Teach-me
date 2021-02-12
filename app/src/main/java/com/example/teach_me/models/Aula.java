package com.example.teach_me.models;

import com.example.teach_me.api.AulaData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aula {

    @SerializedName("data")
    @Expose
    private AulaData data;

    public AulaData getData() {
        return data;
    }

    public void setData(AulaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nAluno: " + data.getCdUsuarioAluno()
                + "\nAnúncio: " + data.getCdAnuncio()
                + "\nHorário: " + data.getHorario();
    }
}
