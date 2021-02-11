package com.example.teach_me.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"message","success"})
public class Usuario {

    private String data;
    private String id;
    private String NmUsuario;
    private String Email;
    private String Login;
    private String Senha;
    private String DtNascimento;
    private String Avaliacao;
    private String Descricao;
    private String Foto;
    private Instituicao Instituicao;

    public Usuario(String id, String NmUsuario, String email, String login, String senha, String dtNascimento, String avaliacao, String descricao, String foto, Instituicao instituicao) {
        this.id = id;
        this.NmUsuario = NmUsuario;
        this.Email = email;
        this.Login = login;
        this.Senha = senha;
        this.DtNascimento = dtNascimento;
        this.Avaliacao = avaliacao;
        this.Descricao = descricao;
        this.Foto = foto;
        this.Instituicao = instituicao;
    }

    public Usuario() {}

    public String getId() {
        return id;
    }

    public String getData(){
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNmUsuario() {
        return NmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.NmUsuario = nmUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        this.Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public String getDtNascimento() {
        return DtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.DtNascimento = dtNascimento;
    }

    public String getAvaliacao() {
        return Avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.Avaliacao = avaliacao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        this.Foto = foto;
    }

    public Instituicao getInstituicao() {
        return Instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.Instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nNome: " + getNmUsuario()
                + "\nNota: " + getAvaliacao()
                + "\nDescrição: " + getDescricao()
                + "\nDT Nascimento: " + getDtNascimento()
                + "\nEmail: " + getEmail()
                + "\nInstituição: " + getInstituicao().getNmInstituicao();
    }
}
