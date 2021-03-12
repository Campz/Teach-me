package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.teach_me.datamodel.TipoDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Tipo;

import java.util.List;

public class TipoController extends AppDataBase implements ICRUD<Tipo> {

    ContentValues dados;

    public TipoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Tipo o) {
        dados = new ContentValues();
        dados.put(TipoDataModel.NMTIPO, o.getNmTipo());
        return insert(TipoDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Tipo o) {
        dados = new ContentValues();
        dados.put(TipoDataModel.ID, o.getId());
        dados.put(TipoDataModel.NMTIPO, o.getNmTipo());
        return update(TipoDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(TipoDataModel.TABELA, id);
    }

    @Override
    public List<Tipo> listar() {
        return null;
    }
}
