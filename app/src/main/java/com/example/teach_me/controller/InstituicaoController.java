package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import com.example.teach_me.datamodel.InstituicaoDataModel;
import com.example.teach_me.datamodel.UsuarioDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Instituicao;

public class InstituicaoController extends AppDataBase implements ICRUD<Instituicao> {

    ContentValues dados;
    private static InstituicaoController instituicaoController;

    public InstituicaoController(Context context) {
        super(context);
    }

    public static InstituicaoController getInstance(Context context){
        if (instituicaoController == null){
            instituicaoController = new InstituicaoController(context);
            return instituicaoController;
        }else{
            return  instituicaoController;
        }
    }

    @Override
    public boolean incluir(Instituicao o) {
        dados = new ContentValues();
        dados.put(InstituicaoDataModel.NMINSTITUICAO, o.getNmInstituicao());
        dados.put(InstituicaoDataModel.ENDERECO, o.getEndereco());
        return insert(InstituicaoDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Instituicao o) {
        dados = new ContentValues();
        dados.put(InstituicaoDataModel.ID, o.getId());
        dados.put(InstituicaoDataModel.NMINSTITUICAO, o.getNmInstituicao());
        dados.put(InstituicaoDataModel.ENDERECO, o.getEndereco());
        return update(InstituicaoDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(InstituicaoDataModel.TABELA, id);
    }

    @Override
    public List<Instituicao> listar() {
        return getAllInstituicoes(InstituicaoDataModel.TABELA);
    }

    @Override
    public Instituicao get(Integer id) throws Exception {
        return getInstituicaoById(InstituicaoDataModel.TABELA,id);
    }
}
