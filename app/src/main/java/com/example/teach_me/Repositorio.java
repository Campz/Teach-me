package com.example.teach_me;

import com.example.teach_me.api.UsuarioData;
import com.example.teach_me.models.Anuncio;
import com.example.teach_me.models.Disciplina;
import com.example.teach_me.models.Tipo;
import com.example.teach_me.models.Usuario;

import java.util.ArrayList;

public class Repositorio {
    private static Repositorio repositorio;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Anuncio> anuncios;

    private Repositorio(){
        this.usuarios = new ArrayList<>();
        this.anuncios = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (repositorio == null){
            return new Repositorio();
        }else{
            return  repositorio;
        }
    }

    public ArrayList<Usuario> getUsuarios(){
        Usuario usuario = new Usuario();
        usuario.setData(new UsuarioData("1","Ruan",null,null,null,null,"4.0",null,"https://i.imgur.com/VBPTe69.jpg",null));
        usuarios.add(usuario);
        usuarios.add(usuario);
        usuarios.add(usuario);
        usuarios.add(usuario);
        return usuarios;
    }

    public ArrayList<Anuncio> getAnuncios(){
        Tipo tipo = new Tipo();
        Disciplina disciplina = new Disciplina();
        Anuncio anuncio = new Anuncio();
        anuncios.add(anuncio);
        anuncios.add(anuncio);
        anuncios.add(anuncio);
        anuncios.add(anuncio);
        anuncios.add(anuncio);
        anuncios.add(anuncio);
        return anuncios;
    }

}
