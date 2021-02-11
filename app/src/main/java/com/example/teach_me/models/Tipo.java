package com.example.teach_me.models;

public class Tipo {

    private String cdTipo;
    private String nmTipo;

    public Tipo(String cdTipo, String nmTipo) {
        this.cdTipo = cdTipo;
        this.nmTipo = nmTipo;
    }

    public String getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(String cdTipo) {
        this.cdTipo = cdTipo;
    }

    public String getNmTipo() {
        return nmTipo;
    }

    public void setNmTipo(String nmTipo) {
        this.nmTipo = nmTipo;
    }

    @Override
    public String toString() {
        return "ID: " + getCdTipo()
                + "\nTipo: " + getNmTipo();
    }
}
