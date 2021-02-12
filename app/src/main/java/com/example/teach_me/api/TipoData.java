package com.example.teach_me.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TipoData {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("NmTipo")
    @Expose
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

}
