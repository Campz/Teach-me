package com.example.teach_me.model;

public class Tipo {

    private Integer id;
    private String nmTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmTipo() {
        return nmTipo;
    }

    public void setNmTipo(String nmTipo) {
        this.nmTipo = nmTipo;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nTipo: " + getNmTipo();
    }
}
