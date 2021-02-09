package com.example.teach_me.models;

public class Tipo {

    private int cdTipo;
    private String nmTipo;

    public Tipo(int cdTipo, String nmTipo) {
        this.cdTipo = cdTipo;
        this.nmTipo = nmTipo;
    }

    public int getCdTipo() {
        return cdTipo;
    }

    public void setCdTipo(int cdTipo) {
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
