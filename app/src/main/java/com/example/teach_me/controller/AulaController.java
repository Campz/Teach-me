package com.example.teach_me.controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.teach_me.datamodel.AulaDataModel;
import com.example.teach_me.datasource.AppDataBase;
import com.example.teach_me.model.Aula;

import java.util.List;

public class AulaController extends AppDataBase implements ICRUD<Aula> {

    ContentValues dados;

    public AulaController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Aula o) {
        dados = new ContentValues();
        dados.put(AulaDataModel.CDUSUARIOALUNO, o.getCdUsuarioAluno());
        dados.put(AulaDataModel.CDANUNCIO, o.getCdAnuncio());
        dados.put(AulaDataModel.HORARIO, o.getHorario());
        return insert(AulaDataModel.TABELA, dados);
    }

    @Override
    public boolean alterar(Aula o) {
        dados = new ContentValues();
        dados.put(AulaDataModel.ID, o.getId());
        dados.put(AulaDataModel.CDUSUARIOALUNO, o.getCdUsuarioAluno());
        dados.put(AulaDataModel.CDANUNCIO, o.getCdAnuncio());
        dados.put(AulaDataModel.HORARIO, o.getHorario());
        return update(AulaDataModel.TABELA, dados);
    }

    @Override
    public boolean deletar(int id) {
        return deleteById(AulaDataModel.TABELA, id);
    }

    @Override
    public List<Aula> listar() {
        return getAllAulas(AulaDataModel.TABELA);
    }
}
