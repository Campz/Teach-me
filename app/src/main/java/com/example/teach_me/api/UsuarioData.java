package com.example.teach_me.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsuarioData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("NmUsuario")
    @Expose
    private String nmUsuario;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Login")
    @Expose
    private String login;
    @SerializedName("Senha")
    @Expose
    private String senha;
    @SerializedName("DtNascimento")
    @Expose
    private String dtNascimento;
    @SerializedName("Avaliacao")
    @Expose
    private String avaliacao;
    @SerializedName("Descricao")
    @Expose
    private String descricao;
    @SerializedName("Foto")
    @Expose
    private String foto;
    @SerializedName("CdInstituicao")
    @Expose
    private String cdInstituicao;

    public UsuarioData(String id, String nmUsuario, String email, String login, String senha, String dtNascimento, String avaliacao, String descricao, String foto, String cdInstituicao) {
        this.id = id;
        this.nmUsuario = nmUsuario;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.foto = foto;
        this.cdInstituicao = cdInstituicao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCdInstituicao() {
        return cdInstituicao;
    }

    public void setCdInstituicao(String cdInstituicao) {
        this.cdInstituicao = cdInstituicao;
    }

}