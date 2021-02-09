package com.example.teach_me.models;

public class Aula {

    private int cdAula;
    private Usuario aluno;
    private Anuncio anuncio;
    private String horario;

    public Aula(int cdAula, Usuario aluno, Anuncio anuncio, String horario) {
        this.cdAula = cdAula;
        this.aluno = aluno;
        this.anuncio = anuncio;
        this.horario = horario;
    }

    public int getCdAula() {
        return cdAula;
    }

    public void setCdAula(int cdAula) {
        this.cdAula = cdAula;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "ID: " + getAluno()
                + "\nAluno: " + getAluno().getNmUsuario()
                + "\nProfessor: " + getAnuncio().getCdUsuario_Professor().getNmUsuario()
                + "\nHorário: " + getHorario();
    }
}
