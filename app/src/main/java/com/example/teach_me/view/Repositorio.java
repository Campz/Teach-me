package com.example.teach_me.view;

import com.example.teach_me.RetrofitClientInstance;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Instituicao;
import com.example.teach_me.model.Tipo;
import com.example.teach_me.model.Usuario;

import java.util.ArrayList;

public class Repositorio {
    private static Repositorio repositorio;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Anuncio> anuncios;
    private ArrayList<Aula> aulas;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Tipo> tipos;
    private ArrayList<Instituicao> instituicoes;

    private Repositorio(){
        this.usuarios = new ArrayList<>();
        this.anuncios = new ArrayList<>();
        this.aulas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.instituicoes = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (repositorio == null){
            repositorio = new Repositorio();
            return repositorio;
        }else{
            return  repositorio;
        }
    }

    // *************** GET Povoamento ***************
    public ArrayList<Usuario> getListUsuarios(){
        return usuarios;
    }
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public ArrayList<Anuncio> getAnuncios(){
        return anuncios;
    }

    public ArrayList<Aula> getAulas(){
        return aulas;
    }

    public ArrayList<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public ArrayList<Instituicao> getInstituicoes(){
        return instituicoes;
    }

    public ArrayList<Tipo> getTipos(){
        return tipos;
    }

    // *************** Povoamento ***************
}
