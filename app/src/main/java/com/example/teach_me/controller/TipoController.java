package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import com.example.teach_me.datamodel.TipoDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Tipo;

public class TipoController extends AppDataBase implements ICRUD<Tipo> {

    ContentValues dados;
    private static TipoController tipoController;

    private TipoController(Context context) {
        super(context);
    }

    public static TipoController getInstance(Context context){
        if (tipoController == null){
            tipoController = new TipoController(context);
        }
        return tipoController;
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
        return getAllTipos(TipoDataModel.TABELA);
    }

    @Override
    public Tipo get(Integer id) throws Exception {
        return getTipoById(TipoDataModel.TABELA, id);
    }
}
