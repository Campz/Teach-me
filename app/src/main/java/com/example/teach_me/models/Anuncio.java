package com.example.teach_me.models;

import com.example.teach_me.api.AnuncioData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Anuncio {
    @SerializedName("data")
    @Expose
    private AnuncioData data;

    public AnuncioData getData() {
        return data;
    }
    public void setData(AnuncioData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + data.getId()
                + "\nDescrição: " + data.getDescricao()
                + "\nProfessor: " + data.getCdUsuarioProfessor()
                + "\nQTD Alunos: " + data.getQtdAlunos()
                + "\nDisciplina: " + data.getCdDisciplina()
                + "\nValor: " + data.getValor();
    }
}
