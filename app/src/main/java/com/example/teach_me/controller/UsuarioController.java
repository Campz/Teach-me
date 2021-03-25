package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Usuario;

public class UsuarioController extends AppDataBase implements ICRUD<Usuario> {

    ContentValues dados;

    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Usuario o) {
        dados = new ContentValues();
        dados.put(UsuarioDataModel.NMUSUARIO, o.getNmUsuario());
        dados.put(UsuarioDataModel.EMAIL, o.getEmail());
        dados.put(UsuarioDataModel.LOGIN, o.getLogin());
        dados.put(UsuarioDataModel.SENHA, o.getSenha());
        dados.put(UsuarioDataModel.DTNASCIMENTO, o.getDtNascimento());
        dados.put(UsuarioDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(UsuarioDataModel.DESCRICAO, o.getDescricao());
        dados.put(UsuarioDataModel.FOTO, o.getFoto());
        dados.put(UsuarioDataModel.CDINSTITUICAO, o.getCdInstituicao());
        return insert(UsuarioDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Usuario o) {
        dados = new ContentValues();
        dados.put(UsuarioDataModel.ID, o.getId());
        dados.put(UsuarioDataModel.NMUSUARIO, o.getNmUsuario());
        dados.put(UsuarioDataModel.EMAIL, o.getEmail());
        dados.put(UsuarioDataModel.LOGIN, o.getLogin());
        dados.put(UsuarioDataModel.SENHA, o.getSenha());
        dados.put(UsuarioDataModel.DTNASCIMENTO, o.getDtNascimento());
        dados.put(UsuarioDataModel.AVALIACAO, o.getAvaliacao());
        dados.put(UsuarioDataModel.DESCRICAO, o.getDescricao());
        dados.put(UsuarioDataModel.FOTO, o.getFoto());
        dados.put(UsuarioDataModel.CDINSTITUICAO, o.getCdInstituicao());
        return update(UsuarioDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(UsuarioDataModel.TABELA, id);
    }

    @Override
    public List<Usuario> listar() {
        return getAllUsuarios(UsuarioDataModel.TABELA);
    }

    public Usuario getUsuario(Integer id)throws Exception{
        return getUsuario(UsuarioDataModel.TABELA,id);
    }
}
