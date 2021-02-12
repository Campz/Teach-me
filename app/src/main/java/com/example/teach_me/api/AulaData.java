package com.example.teach_me.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AulaData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("CdUsuario_Aluno")
    @Expose
    private Integer cdUsuarioAluno;
    @SerializedName("CdAnuncio")
    @Expose
    private Integer cdAnuncio;
    @SerializedName("Horario")
    @Expose
    private String horario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCdUsuarioAluno() {
        return cdUsuarioAluno;
    }

    public void setCdUsuarioAluno(Integer cdUsuarioAluno) {
        this.cdUsuarioAluno = cdUsuarioAluno;
    }

    public Integer getCdAnuncio() {
        return cdAnuncio;
    }

    public void setCdAnuncio(Integer cdAnuncio) {
        this.cdAnuncio = cdAnuncio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
