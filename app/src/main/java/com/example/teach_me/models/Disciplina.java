package com.example.teach_me.models;

import com.example.teach_me.api.DisciplinaData;
import com.example.teach_me.api.UsuarioData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Disciplina {

    @SerializedName("data")
    @Expose
    private DisciplinaData data;

    public DisciplinaData getData() {
        return data;
    }

    public void setData(DisciplinaData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nNome: " + data.getNmDisciplina()
                + "Tipo: " + data.getCdTipo();
    }
}
