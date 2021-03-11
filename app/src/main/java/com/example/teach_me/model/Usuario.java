package com.example.teach_me.model;

public class Usuario {

    private Integer id;
    private String nmUsuario;
    private String email;
    private String login;
    private String senha;
    private String dtNascimento;
    private String avaliacao;
    private String descricao;
    private String foto;
    private Integer cdInstituicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCdInstituicao() {
        return cdInstituicao;
    }

    public void setCdInstituicao(Integer cdInstituicao) {
        this.cdInstituicao = cdInstituicao;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nNome: " + getNmUsuario()
                + "\nNota: " + getAvaliacao()
                + "\nDescrição: " + getDescricao()
                + "\nDT Nascimento: " + getDtNascimento()
                + "\nEmail: " + getEmail();
                //+ "\nInstituição: " + getInstituicao().getNmInstituicao();
    }
}
