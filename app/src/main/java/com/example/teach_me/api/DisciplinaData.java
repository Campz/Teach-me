package com.example.teach_me.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisciplinaData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("NmDisciplina")
    @Expose
    private String nmDisciplina;
    @SerializedName("CdTipo")
    @Expose
    private Integer cdTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public Integer getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(Integer cdTipo) {
        this.cdTipo = cdTipo;
    }
}
